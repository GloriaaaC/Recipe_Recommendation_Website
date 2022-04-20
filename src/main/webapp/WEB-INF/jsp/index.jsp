<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Search Page</title>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <link href="css/search.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="css/iconfont.css">
    <script src="js/jquery-3.6.0.min.js"></script>
    <script src="js/index.js"></script>
    <link rel="stylesheet" href="css/bootstrap-4.6.0.min.css">
    <link rel="stylesheet" href="css/font-awesome-4.7.0.min.css">
    <link rel="stylesheet" href="css/history-and-recipe.css">
<%--    <script src="js/recipe.js"></script>--%>
    <script src="js/bootstrap-4.6.0.bundle.min.js"></script>
</head>

<body>

<!-- Navigation Bar -->
<nav class="navbar navbar-expand-sm navbar-light bg-light">
    <a class="navbar-brand font-weight-bold" href="#">Pick&Cook</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav mr-auto">
            <!-- <li class="nav-item">
              <a class="nav-link" href="#">History</a>
            </li> -->
            <li class="nav-item">
                Recipe
                <!-- <a class="nav-link" href="#">Recipe</a> -->
            </li>
        </ul>
        <div class="nav-icons text-right">
            <a class="fa fa-search fa-lg mx-3" href="#"></a>
            <a class="fa fa-history fa-lg mx-3" href="#"></a>
            <a class="fa fa-bookmark-o fa-lg mx-3" href="#"></a>
            <a class="fa fa-user-o fa-lg mx-3" href="#"></a>
        </div>
    </div>
</nav>

<div class="out_wrapper">

    <div class="brand_wrap mt10 clearfix">
        <div class="brand_left">
            <div class="brand_head">Ingredient</div>
            <div class="brand_nav">
                <div class="brand_side">
                    <div class="numA-Z">
                        <a href="javascript:void(0)" class="active">Vegetable</a>
                        <a href="javascript:void(0)">Fruit</a>
                        <a href="javascript:void(0)">Seafood</a>
                        <a href="javascript:void(0)">Meat</a>
                        <a href="javascript:void(0)">Beans</a>
                        <a href="javascript:void(0)">Root vegetables</a>
                        <a href="javascript:void(0)">Condiments</a>
<%--                        <a href="javascript:void(0)">J</a>--%>
<%--                        <a href="javascript:void(0)">K</a>--%>
<%--                        <a href="javascript:void(0)">L</a>--%>
<%--                        <a href="javascript:void(0)">M</a>--%>
<%--                        <a href="javascript:void(0)">N</a>--%>
<%--                        <a href="javascript:void(0)">O</a>--%>
<%--                        <a href="javascript:void(0)">Q</a>--%>
<%--                        <a href="javascript:void(0)">R</a>--%>
<%--                        <a href="javascript:void(0)">S</a>--%>
<%--                        <a href="javascript:void(0)">T</a>--%>
<%--                        <a href="javascript:void(0)">W</a>--%>
<%--                        <a href="javascript:void(0)">X</a>--%>
<%--                        <a href="javascript:void(0)">Y</a>--%>
<%--                        <a href="javascript:void(0)">Z</a>--%>
                    </div>
                </div>
                <div class="brand_col">
                    <div class="brand_list">
                        <ul class="list_cont">
                            <li class="name">Vegetable</li>
                            <li><span class="iconfont icon-success"></span>Onion<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Potato<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Tomato<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Cabbage<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Eggplant<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Spinach<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Chili<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Mushroom<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Pumpkin<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Cucumber<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Green onions<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Ginger<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Lettuce<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Chinese chives<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Cauliflower<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Celery<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Garlic sprouts<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Purple cabbage<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Water spinach<span class="iconfont icon-delete"></span></li>

                            <li class="name">Fruit</li>
                            <li><span class="iconfont icon-success"></span>Orange<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Apple<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Peer<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Peach<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Hawthorn<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Apricot<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Pineapple<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Mango<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Banana<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Cherry<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Papaw<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Strawberry<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>blueberry<span class="iconfont icon-delete"></span></li>
                            <li class="name">Seafood</li>
                            <li><span class="iconfont icon-success"></span>Sea cucumber<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Shark fin<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Abalone<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Dried scallops<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Crab<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Shrimp<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Squid<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Flounder<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Lobster<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Oyster<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Salmon<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Weever<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Tuna<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Hairtail<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Scallop<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Kelp<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Pilchard<span class="iconfont icon-delete"></span></li>
                            <li class="name">Meat</li>
                            <li><span class="iconfont icon-success"></span>Duck<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Pork<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Chicken<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Lamb<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Beef<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Fish<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Sausage<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Bacon<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Ham<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Roast<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Steak<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Mutton<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Venison<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Mutton<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Mutton<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Mutton<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Mutton<span class="iconfont icon-delete"></span></li>
                            <li class="name">Beans</li>
                            <li><span class="iconfont icon-success"></span>Coffee bean<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Cocoa bean<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Soybean<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Red bean<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Frozen peas<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>French green pea<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Haricot<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Garden pea<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Lima bean<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Hyacinth<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Common bean<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Mung bean<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Cowpea<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Chickpea<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Lentil<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Pea<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Broad bean<span class="iconfont icon-delete"></span></li>
                            <li class="name">Root vegetables</li>
                            <li><span class="iconfont icon-success"></span>Cauliflower<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Kohlrabi<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>broccoli<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>kale<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>brussel sprouts<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Beet<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Globe artichoke<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>palm heart<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>asparagus<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>fennel<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>celery<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>chicory<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Leek<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Parsnip<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Rhubarb<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>Knollensellerie <span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>onion<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>potato<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>carrot<span class="iconfont icon-delete"></span></li>
                            <li class="name">Condiments</li>
                            <li><span class="iconfont icon-success"></span>salt<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>sugar<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>gourmet powder<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>vinegar<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>soy sauce<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>star anise<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>cinnamon<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>curry<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>white pepper<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>cumin<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>black pepper<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>flower pepper<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>miso<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>caviar<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>barbeque sauce<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>tomato sauce<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>hoisin sauce<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>mayonnaise<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>blueberry jam<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>lekvar<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>marmalade<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>mincemeat<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>mustard<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>lard<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>butter<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>chili oil<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>olive oil<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>fish sauce<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>oyster sauce<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>mint<span class="iconfont icon-delete"></span></li>
                            <li><span class="iconfont icon-success"></span>rosemary<span class="iconfont icon-delete"></span></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <div class="ct-pageWrapper">
        <main>
            <div class="search d1">
                <form>
                    <input type="text" id="searchInput" placeholder="enter recipe you like..." style="width: 308px; height: 36px; box-sizing: border-box; vertical-align: top;">
                    <button type="button" id="searchButton" class="btn btn-primary" value="QUERY"><a style="color: black" class="fa fa-search fa-lg mx-3"></a></button>
                </form>
            </div>
            <div class="container">
                <div class="selected">
                    <p>Selected:</p>
                </div>
                <div class="avoided">
                    <p>Avoided:</p>
                </div>
                <button type="button" id="button" class="btn btn-primary" value="QUERY">Query</button>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-9">
                        <div class="row">
<%--                            <div class="col-sm-4">--%>
<%--                                <div class="ct-product">--%>
<%--                                    <div class="image"><img src="images/product-01.jpg" alt=""></div>--%>
<%--                                    <div class="inner"><a href="#" class="btn btn-motive ct-product-button"><i class="fa fa-shopping-cart"></i></a>--%>
<%--                                        <h2 class="ct-product-title">Box of macaroons</h2>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>

    <script>
        $(document).ready(function () {
            $("#button").click(function () {
                query();
            });
            $("#searchButton").click(function () {
                search();
            })
        });
        function query() {
            const url1 = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/findByIngredients?ingredients=";
            const url2 = "&number=5&ignorePantry=true&ranking=1";
            const length = $(".ct-pageWrapper .container p").children().length;
            let url3 = "";
            for (let i = 0; i < length; i++) {
                if (i !== length-1){
                    url3 = url3 + $(".ct-pageWrapper .container p").children().eq(i).text() + "%2C";
                } else {
                    url3 = url3 + $(".ct-pageWrapper .container p").children().eq(i).text();
                }
            }
            const url = url1+url3+url2;

            const settings = {
                "async": true,
                "crossDomain": true,
                "url": url,
                "method": "GET",
                "headers": {
                    "x-rapidapi-host": "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com",
                    "x-rapidapi-key": "abe7289ee5msh16e0e63abe50c7bp1f967bjsnb144deda63cb"
                }
            };

            $.ajax(settings).done(function (response) {
                console.log(response);
                $('.ct-pageWrapper .container .row .col-md-9 .row').empty();
                for (let j = 0; j < response.length; j++) {
                    const node = $('<div class="col-sm-4">' +
                        '<div class="ct-product">' +
                        '<div class="image"><img src="' + response[j].image + '" alt=""></div>' +
                        '<div class="inner"><button type="button" class="btn btn-motive ct-product-button" id="' + response[j].id + '"><i class="fa fa-thumbs-up"></i></button><h2 class="ct-product-title">' + response[j].title + '</h2>' +
                        '</div>' +
                        '</div>' +
                        '</div>');
                    $('.ct-pageWrapper .container .row .col-md-9 .row').append(node);
                }
            });
        }

        function search() {
            const url = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/search?query=" + $("#searchInput").val();
            const settings = {
                "async": true,
                "crossDomain": true,
                "url": url,
                "method": "GET",
                "headers": {
                    "x-rapidapi-host": "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com",
                    "x-rapidapi-key": "abe7289ee5msh16e0e63abe50c7bp1f967bjsnb144deda63cb"
                }
            };

            $.ajax(settings).done(function (response) {
                console.log(response);
                $('.ct-pageWrapper .container .row .col-md-9 .row').empty();
                for (let j = 0; j < response.results.length; j++) {
                    const node = $('<div class="col-sm-4">' +
                        '<div class="ct-product">' +
                        '<div class="image"><img width="200px" height="200px" src="' + response.baseUri + response.results[j].image + '" alt=""></div>' +
                        '<div class="inner"><button type="button" class="btn btn-motive ct-product-button" id="' + response.results[j].id + '"><i class="fa fa-thumbs-up"></i></button><h2 class="ct-product-title">' + response.results[j].title + '</h2>' +
                        '</div>' +
                        '</div>' +
                        '</div>');
                    $('.ct-pageWrapper .container .row .col-md-9 .row').append(node);
                }
            });
        }
    </script>

</div>
</body>

</html>