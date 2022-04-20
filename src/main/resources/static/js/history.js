/**N
 * Scripts for history page
 */

// Check before run ------------------------------------------------------------
const PORT = 8081;
// Fine constants --------------------------------------------------------------
const HOST = '127.0.0.1';
const DOT_SUFFIX = window.location.href.match(/\/.*(\.(?:html|jsp))(?:\?.*)?$/)?.[1] ?? '';
const CODE_OK = 200;
// -----------------------------------------------------------------------------

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

class DateHistory {
    static historyBoard = document.getElementById('historyBoard');
    static tBlock = document.querySelector('#dateBlockTemplate');
    static tItem = document.querySelector('#historyItemTemplate');

    constructor(date) {
        if (!DateUtils.verifyDate(date)) {
            console.log(`Bad date format ${date}`);
            return null;
        }
        this.date = date; // YYYY-MM-DD
        this.items = [];
    }

    appendItem(historyId, imageUrl, recipeName, recipeId, avgRating) {
        this.items.push({ historyId, imageUrl, recipeName, recipeId, avgRating });
    }

    render() {
        DateHistory.tBlock.content.querySelector('h6').textContent = DateUtils.beautifyDate(this.date);
        DateHistory.tBlock.content.querySelector('.row').setAttribute('id', `date-${this.date}`);
        DateHistory.historyBoard.appendChild(document.importNode(DateHistory.tBlock.content, true));
        const root = document.getElementById(`date-${this.date}`);

        this.items.forEach((item) => {
            DateHistory.tItem.content.querySelector('.card').setAttribute('id', `item-${item.historyId}`);
            DateHistory.tItem.content.querySelector('.card-custom-img')
                .setAttribute('style', `background-image: url(${item.imageUrl});`);
            DateHistory.tItem.content.querySelector('.card-title').textContent = item.recipeName;
            DateHistory.tItem.content.querySelector('.static-rating-stars').innerHTML = getRatingStarsHTML(item.avgRating);
            root.appendChild(document.importNode(DateHistory.tItem.content, true));

            // add click event listener to recipe image
            document.querySelector(`#item-${item.historyId} a`).addEventListener('click', () => {
                window.location.replace(`./recipe${DOT_SUFFIX}?id=${item.recipeId}`);
            });

            // add click event listener to close button
            document.querySelector(`#item-${item.historyId} button`).addEventListener('click', () => {
                fetch(`http://${HOST}:${PORT}/api/history?historyId=${item.historyId}`,
                    {
                        method: 'DELETE',
                    })
                    .then((response) => response.json(), (_) => {
                        console.log('Error in delete history item.');
                    })
                    .then((json) => {
                        if (json?.state === CODE_OK) { // successfully removed the item in backend
                            $(`#item-${item.historyId}`).parent().remove();
                            const container = $(`#date-${this.date}`);
                            if (!container.html().trim()) {
                                container.parent().remove();
                            }
                        }
                    });
            });
        });
    }
}

function renderHistoryInfo(json) {
    // if the user has no browsing history
    if (!json.data || json.data.length === 0) {
        $('#emptyInfo').toggleClass('d-none');
        return;
    }

    // otherwise, render the browsing history
    json.data.forEach((dateHistory) => {
        const block = new DateHistory(dateHistory.date);
        dateHistory.items.forEach((item) => {
            if (item.isDelete === 0) {
                block.appendItem(item.rid, item.imageUrl, item.recipeName, item.recipeId, item.avgRating);
            }
        });
        block.render();
    });
}

function renderErrorInfo() {
    $('#errorInfo').toggleClass('d-none');
}

function renderSampleInfo() {
    console.log('Render sample info');
    // content for 2021/09/17
    const date20210917 = new DateHistory('2021-09-17');
    date20210917.appendItem(11, 'https://spoonacular.com/recipeImages/1110-556x370.jpg', 'Recipe 11 Title', 11, 4.8);
    date20210917.render();
    // content for 2021/08/15
    const date20210815 = new DateHistory('2021-08-15');
    date20210815.appendItem(21, 'https://spoonacular.com/recipeImages/2100-556x370.jpg', 'Recipe 21 Title', 21, 7.5);
    date20210815.appendItem(22, 'https://spoonacular.com/recipeImages/2200-556x370.jpg', 'Recipe 22 Title', 22, 2.1);
    date20210815.appendItem(23, 'https://spoonacular.com/recipeImages/2315-556x370.jpg', 'Recipe 23 Title', 23, 3);
    date20210815.appendItem(24, 'https://spoonacular.com/recipeImages/2400-556x370.jpg', 'Recipe 24 Title', 24, 3.8);
    date20210815.appendItem(25, 'https://spoonacular.com/recipeImages/2500-556x370.jpg', 'Recipe Long Title 25 Recipe Long Title Recipe Long Title Recipe Long Title Recipe Long Title Recipe Long Title', 25, 3.5);
    date20210815.render();
}

let obj;

$(() => {
    // navigation bar
    $('a.fa-search').on('click', () => {
        window.location.replace(`./index${DOT_SUFFIX}`);
    });
    $('a.fa-history').on('click', () => {
        window.location.reload();
    });
    $('a.fa-bookmark-o').on('click', () => {
        window.location.replace(`./account${DOT_SUFFIX}`);
    });
    $('a.fa-user-o').on('click', () => {
        window.location.replace(`./account${DOT_SUFFIX}`);
    })

    const url = `http://${HOST}:${PORT}/api/history?userId=${userid}`;
    const init = { method: 'GET', };
    fetch(url, init)
        .then((response) => response.json(), (_) => {
            // renderSampleInfo();
            renderErrorInfo();
        })
        .then((json) => {
            if (json) {
                renderHistoryInfo(json);
                obj = json;
            }
        });
});
