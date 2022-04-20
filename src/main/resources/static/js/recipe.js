/**
 * Scripts for recipe page
 */

// Check before run ------------------------------------------------------------
const PORT = 8081;
// Fine constants --------------------------------------------------------------
const HOST = '127.0.0.1';
const DOT_SUFFIX = window.location.href.match(/\/.*(\.(?:html|jsp))(?:\?.*)?$/)?.[1] ?? '';
const CODE_OK = 200;
// -----------------------------------------------------------------------------

const params = new URLSearchParams(window.location.search);
const recipeid = Number(params.get('id') ?? 0); // 0 is a COMPROMISE for development
const userid = Number(localStorage.getItem('userid') ?? 0) // 0 is a COMPROMISE for development

function getRatingStarsHTML(rating) {
    if (rating === -1) {
        return '<i>Not yet rated</i>';
    }

    if (rating < 0) {
        rating = 0;
    } else if (rating > 5) {
        rating = 5;
    }

    const numSolid = Math.floor(rating);
    const hasHalf = rating - numSolid >= 0.5;

    let html = '';
    let i = 0;
    while (i < numSolid) {
        html += '<i class="fa fa-star"></i> ';
        i++;
    }
    if (hasHalf) {
        html += '<i class="fa fa-star-half-o"></i> ';
        i++;
    }
    while (i < 5) {
        html += '<i class="fa fa-star-o"></i> ';
        i++;
    }

    return html;
}

class DateUtils {
    static strToMonth = {
        '01': 'Jan', '02': 'Feb', '03': 'Mar', '04': 'Apr', '05': 'May', '06': 'Jun',
        '07': 'Jul', '08': 'Aug', '09': 'Sep', '10': 'Oct', '11': 'Nov', '12': 'Dec',
    };

    static beautifyDate(date) {
        const m = date.match(/^(\d{4})-(\d{2})-(\d{2})$/);
        if (m === null) {
            console.log(`Bad date format: ${date}`);
            return '';
        }
        return `${m[3]} ${DateUtils.strToMonth[m[2]]} ${m[1]}`;
    }

    static verifyDate(date) {
        return date.search(/^\d{4}-\d{2}-\d{2}$/) !== -1;
    }
}

class Review {
    static reviewBoard = document.getElementById('recipeReviews');
    static tReview = document.querySelector('#reviewTemplate');

    constructor(avatar, username, date, rating, content) {
        if (!DateUtils.verifyDate(date)) {
            console.log(`Bad date format ${date}`);
            return null;
        }
        this.avatar = avatar;
        this.username = username;
        this.date = date;
        this.rating = rating;
        this.content = content;
    }

    render() {
        Review.tReview.content.querySelector('img').setAttribute('src', this.avatar);
        Review.tReview.content.querySelector('h6').textContent = this.username;
        Review.tReview.content.querySelector('.text-secondary').textContent = DateUtils.beautifyDate(this.date);
        Review.tReview.content.querySelector('.static-rating-stars').innerHTML = getRatingStarsHTML(this.rating);
        Review.tReview.content.querySelector('.text-justify').innerHTML = this.content;
        Review.reviewBoard.appendChild(document.importNode(Review.tReview.content, true));
    }

    static clearAll() {
        Review.reviewBoard.innerHTML = '';
    }
}

function renderRecipeBackendInfo() {
    // Rating stars
    fetch(`http://${HOST}:${PORT}/api/ratings?recipeId=${recipeid}`, { method: 'GET', })
        .then((response) => response.json(), (_) => {
            console.log('Error in getting recipe rating.');
        })
        .then((json) => {
            if (json.state === CODE_OK) {
                $('#recipeRatingStars').attr('data-content', json.data.rating).html(getRatingStarsHTML(json.data.rating));
            }
        });

    // Reviews
    fetch(`http://${HOST}:${PORT}/api/reviews?recipeId=${recipeid}`, { method: 'GET', })
        .then((response) => response.json(), (_) => {
            console.log('Error in getting recipe reviews.');
        })
        .then((json) => {
            if (json.state === CODE_OK) {
                json.data.reviewList.forEach((r) => {
                    new Review('images/default_avatar.jpg', r.username, r.modifiedTime, r.rating, r.review).render();
                });
            }
        });
}

function renderRecipeExternalInfo(json) {
    // Title
    $('#recipeTitle').text(json.title);

    // Badges
    const $recipeBadges = $('#recipeBadges');
    if (json.glutenFree) {
        $recipeBadges.append('<span class="badge badge-pill badge-success">Gluten-Free</span> ');
    } else {
        $recipeBadges.append('<span class="badge badge-pill badge-secondary">Gluten-Containing</span> ');
    }
    if (json.dairyFree) {
        $recipeBadges.append('<span class="badge badge-pill badge-success">Dairy-Free</span> ');
    } else {
        $recipeBadges.append('<span class="badge badge-pill badge-secondary">Dairy</span> ');
    }
    if (json.vegetarian) {
        $recipeBadges.append('<span class="badge badge-pill badge-success">Vegetarian</span> ');
    } else {
        $recipeBadges.append('<span class="badge badge-pill badge-secondary">Non-Vegetarian</span> ');
    }
    if (json.vegan) {
        $recipeBadges.append('<span class="badge badge-pill badge-success">Vegan</span> ');
    } else {
        $recipeBadges.append('<span class="badge badge-pill badge-secondary">Non-Vegan</span> ');
    }

    // Description
    // $('#recipeDescription').text('')

    // Ingredients
    const recipeIngredients = document.getElementById('recipeIngredients');
    const tIngredient = document.querySelector('#ingredientTemplate');
    json.extendedIngredients.forEach((item) => {
        tIngredient.content.querySelector('span').textContent = item.name;
        recipeIngredients.appendChild(document.importNode(tIngredient.content, true));
    })

    // Image
    $('.recipe-img').attr('src', json.image);

    // Instructions
    const recipeInstructions = document.getElementById('recipeInstructions');
    if (json.analyzedInstructions) {
        const tStep = document.querySelector('#stepTemplate');
        json.analyzedInstructions[0].steps.forEach((item) => {
            tStep.content.querySelector('h4').textContent = `Step ${item.number}`;
            tStep.content.querySelector('p').textContent = item.step;
            recipeInstructions.appendChild(document.importNode(tStep.content, true));
        });
    } else if (json.instructions) {
        recipeInstructions.textContent = json.instructions.replace('.', '.\n');
    } else {
        recipeInstructions.textContent = 'Sorry, no instruction found';
    }
}

function renderErrorInfo() {
    $('body>div[id!="errorInfo"]').remove();
    $('#errorInfo').toggleClass('d-none');
}

function handleFavoritesButton(rid) {
    $('#btnLiked').hide();

    $('#btnLiked').on('click', () => {
        fetch(`http://${HOST}:${PORT}/api/liked?userId=${userid}&recipeId=${recipeid}`, { method: 'DELETE', })
            .then((response) => response.json(), (_) => {
                console.log('Error in removing liked');
            })
            .then((json) => {
                if (json.state === CODE_OK) {
                    $('#btnLike').toggle();
                    $('#btnLiked').toggle();
                }
            });
    });

    fetch(`http://${HOST}:${PORT}/api/liked?userId=${userid}&recipeId=${recipeid}`, { method: 'GET', })
        .then((response) => response.json(), (_) => {
            console.log('Error in getting favorites liked');
        })
        .then((json) => {
            if (json.state === CODE_OK && json.data.liked === true) {
                $('#btnLike').toggle();
                $('#btnLiked').toggle();
            } else {
                fetch(`http://${HOST}:${PORT}/users/favorites?userId=${userid}`, { method: 'GET', })
                    .then((response) => response.json(), (_) => {
                        console.log('Error in getting favorites');
                    })
                    .then((json) => {
                        const dropdownMenu = document.getElementById('btnLikeDropdownMenu');
                        const tItem = document.querySelector('#likeDropdownItemTemplate');
                        json.data.forEach((item) => {
                            tItem.content.querySelector('a').textContent = item.folderName;
                            tItem.content.querySelector('a').setAttribute('id', `fav-${item.id}`);
                            dropdownMenu.appendChild(document.importNode(tItem.content, true));
                            document.getElementById(`fav-${item.id}`).addEventListener('click', () => {
                                fetch(`http://${HOST}:${PORT}/users/favorites/recipes?folderId=${item.id}&recipeId=${rid}`,
                                    {
                                        method: 'POST',
                                    })
                                    .then((response) => response.json(), (_) => {
                                        console.log('Error in adding recipe to favorites');
                                    })
                                    .then((json) => {
                                        if (json.state === CODE_OK) {
                                            $('#btnLike').toggle();
                                            $('#btnLiked').toggle();
                                        } else {
                                            alert('Sorry, something wrong just happened. Please try again.');
                                        }
                                    });
                            });
                        });
                    });
            }
        });
}

$(() => {
    // enable popover
    $('[data-toggle="popover"]').popover({
        trigger: 'hover',
        delay: { show: 500, hide: 100 }
    });

    // navigation bar
    $('a.fa-search').on('click', () => {
        window.location.replace(`./index${DOT_SUFFIX}`);
    });
    $('a.fa-history').on('click', () => {
        window.location.replace(`./history${DOT_SUFFIX}`);
    });
    $('a.fa-bookmark-o').on('click', () => {
        window.location.replace(`./account${DOT_SUFFIX}`);
    });
    $('a.fa-user-o').on('click', () => {
        window.location.replace(`./account${DOT_SUFFIX}`);
    })

    // actions
    fetch(`http://${HOST}:${PORT}/recipes/getRecipe?userId=${userid}&recipeId=${recipeid}`, { method: 'GET', })
        .then((response) => response.json(), (_) => {
            console.log('Error in getting recipe rid');
        })
        .then((json) => {
            handleFavoritesButton(json.data.rid);
        });

    // print button click event
    $('#btnPrint').on('click', () => {
        window.print();
    });

    // submit button click event
    $('#userReviewSubmit').on('click', () => {
        const rate = Number($('.user-rating>input:checked').val());
        if (!rate) {
            alert('You should rate before submit!');
            return false;
        }
        const review = $('#userReviewText').val().trim();
        console.log(`rate: ${rate}, review: ${review}`);

        // communicate with backend (not implemented perfectly)
        // a better solution is to seperate rating and reviewing
        fetch(`http://${HOST}:${PORT}/api/ratings?userId=${userid}&recipeId=${recipeid}&rating=${rate}`,
            {
                method: 'POST',
                headers: {
                    'content-type': 'application/json',
                },
                // body: JSON.stringify({ userId: userid, recipeId: recipeid, rating: rate }),
            })
            .then((response) => response.json())
            .then((json) => {
                if (json.state === CODE_OK && review === '') {  // rate succeeded, no review
                    alert('Successfully rate!');
                } else if (review !== '') { // no matter rate succeeded or not, if review presents, handle it

                } else { // rate failed, no review
                    alert(json.message);
                }
            });

        if (review !== '') {
            fetch(`http://${HOST}:${PORT}/api/reviews?userId=${userid}&recipeId=${recipeid}&review=${review}`,
                {
                    method: 'POST',
                    headers: {
                        'content-type': 'application/json',
                    },
                    // body: JSON.stringify({ userId: userid, recipeId: recipeid, review: review, }),
                })
                .then((response) => response.json())
                .then((json) => {
                    if (json.state === CODE_OK) { // review succeeded
                        alert('Successfully review!');
                    } else { // review failed
                        alert(json.message);
                    }
                });
        }

        // afterwards
        $('.user-rating>input').attr('disabled', 'disabled');
        $('#userReviewText').attr('placeholder', '').val('');

        // refresh rating and reviews
        // $('#recipeRatingStars').removeAttr('data-content').empty();
        // Review.clearAll();
        // renderRecipeBackendInfo();

        return false;
        // return true;
    });

    // load external data
    if (recipeid === 0) { // no recipe has id 0
        renderTemplateInfo();
        renderRecipeBackendInfo();
    } else {
        const url = `https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/${recipeid}/information`;
        const init = {
            method: 'GET',
            headers: {
                'x-rapidapi-host': 'spoonacular-recipe-food-nutrition-v1.p.rapidapi.com',
                'x-rapidapi-key': 'f6520881bcmshd6f451dbcef9ccbp1f81fcjsn2b19cef04503'
            }
        };

        fetch(url, init)
            .then((response) => {
                if (response.ok) {
                    return response.json();
                } else { // when api server returns 4xx 5xx
                    renderErrorInfo();
                }
            }, (_) => {
                renderErrorInfo();
            })
            .then((json) => {
                if (json) {
                    renderRecipeExternalInfo(json);

                    // add or update history
                    // fetch(`http://${HOST}:${PORT}/api/history`, {
                    //     method: 'PUT',
                    //     headers: {
                    //         'content-type': 'application/json',
                    //     },
                    //     body: JSON.stringify({ userid: userid, recipeid: recipeid, title: json.title, image: json.image }),
                    // });
                }
            });

        renderRecipeBackendInfo();
    }
});
