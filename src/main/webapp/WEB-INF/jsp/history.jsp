<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="css/bootstrap-4.6.0.min.css">
    <link rel="stylesheet" href="css/font-awesome-4.7.0.min.css">
    <link rel="stylesheet" href="css/history-and-recipe.css">

    <title>History | Pick&Cook</title>
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
            <li class="nav-item">
                History
                <!-- <a class="nav-link" href="#">History</a> -->
            </li>
            <!-- <li class="nav-item">
              <a class="nav-link" href="#">Recipe</a>
            </li> -->
        </ul>
        <div class="nav-icons text-right">
            <a class="fa fa-search fa-lg mx-3"></a>
            <a class="fa fa-history fa-lg mx-3"></a>
            <a class="fa fa-bookmark-o fa-lg mx-3"></a>
            <a class="fa fa-user-o fa-lg mx-3"></a>
        </div>
    </div>
</nav>

<!-- History Board -->
<div class="container" id="historyBoard"></div>

<template id="dateBlockTemplate">
    <div class="dateblock mt-4 mb-3">
        <h6 class="text-dark">History Date</h6>
        <div class="row justify-content-start mx-3 px-3 border-left"></div>
    </div>
</template>

<template id="historyItemTemplate">
    <div class="col-6 col-md-4 col-lg-3">
        <div class="card card-custom bg-white border-white my-3">
            <div class="card-custom-img position-relative" style="background-image: url(images/default_recipe.jpg);">
                <a href="#" class="stretched-link"></a>
            </div>
            <div class="card-body scrollbar-enabled scrollbar-dusty-grasss scrollbar-invisible pt-3 pb-0">
                <h5 class="card-title">Recipe Title</h5>
                <!-- <p class="card-text text-secondary font-italic">Recipe Description</p> -->
            </div>
            <div class="card-footer row justify-content-between" style="background: inherit; border-color: inherit;">
                <div class="col static-rating-stars">[Rating Stars]</div>
                <div class="col col-1">
                    <button type="button" class="close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </div>
        </div>
    </div>
</template>

<div class="my-5 text-center d-none" id="emptyInfo">
    <h1 class="text-muted">You don't have any browsing history</h1>
    <h1 class="text-muted">Go and find some <i class="fa fa-smile-o"></i></h1>
</div>

<div class="my-5 text-center d-none" id="errorInfo">
    <h1 class="text-muted">Oops! Something went wrong <i class="fa fa-frown-o"></i></h1>
</div>

<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/bootstrap-4.6.0.bundle.min.js"></script>
<script src="js/history.js"></script>
</body>

</html>