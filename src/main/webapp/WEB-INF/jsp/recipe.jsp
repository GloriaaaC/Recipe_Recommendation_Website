<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link rel="stylesheet" href="css/bootstrap-4.6.0.min.css">
  <link rel="stylesheet" href="css/font-awesome-4.7.0.min.css">
  <link rel="stylesheet" href="css/history-and-recipe.css">

  <title>Recipe | Pick&Cook</title>
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

<!-- Recipe Board -->
<div class="container my-5">
  <header class="mb-2">
    <h1 class="font-weight-bold" id="recipeTitle"></h1>

    <div class="row">
      <div class="col col-auto static-rating-stars" id="recipeRatingStars" data-toggle="popover" data-content="">
      </div>
    </div>
  </header>

  <div class="row justify-content-start">
    <div class="col-12 col-md-6">
      <div id="recipeBadges">
        <!-- Add recipe badges here -->
      </div>
      <template id="badgeTemplate">
        <span class="badge badge-pill badge-success">Success</span>
        <span class="badge badge-pill badge-secondary">Secondary</span>
      </template>

      <!-- <div class="text-secondary" id="recipeDescription"></div> -->

      <div class="mt-5">
        <h3>Ingredients</h3>
        <h5 class="text-capitalize" id="recipeIngredients"></h5>
        <template id="ingredientTemplate">
          <span class="badge badge-light"></span>
        </template>
      </div>

      <div class="mt-5">
        <h3>Actions</h3>
        <div class="dropdown d-inline">
          <button class="btn btn-outline-danger ml-1" id="btnLike" data-toggle="dropdown">
            <i class="fa fa-heart-o"></i>
          </button>
          <div class="dropdown-menu" id="btnLikeDropdownMenu">
            <h6 class="dropdown-header">Select a folder</h6>
          </div>
          <template id="likeDropdownItemTemplate">
            <a class="dropdown-item"></a>
          </template>
        </div>
        <button class="btn btn-outline-danger ml-1" id="btnLiked" data-toggle="popover" data-placement="bottom"
                data-content="Remove from favorites">
          <i class="fa fa-heart"></i>
        </button>
        <button class="btn btn-outline-info ml-1" id="btnPrint" data-toggle="popover" data-placement="bottom"
                data-content="Print the recipe">
          <i class="fa fa-print"></i>
        </button>
        <!-- <a class="btn btn-outline-dark ml-1" id="btnSrc">
          <i class="fa fa-file-archive-o"></i>
        </a> -->
      </div>

    </div>
    <div class="col-12 col-md-6 text-center my-4 my-md-auto">
      <img class="rounded recipe-img" alt="loading ...">
    </div>
  </div>
</div>

<div class="container">
  <hr class="sep" />
</div>

<div class="container my-5 text-justify" id="recipeInstructions"></div>
<template id='stepTemplate'>
  <h4></h4>
  <p></p>
</template>

<div class="container">
  <hr class="sep" />
</div>

<div class="container my-5">
  <h3 class="mb-4">Reviews</h3>
  <ul class="list-unstyled" id="recipeReviews"></ul>
  <template id="reviewTemplate">
    <li class="media my-3">
      <img class="media-img rounded-lg mr-4" alt="profile image">
      <div class="media-body">
        <div class="row justify-content-between">
          <div class="col">
            <h6>Name</h6>
          </div>
          <div class="col text-right text-secondary">Date</div>
        </div>
        <div class="static-rating-stars">Rating stars</div>
        <div class="text-justify">Content</div>
      </div>
    </li>
  </template>

  <h4>Leave a Review</h4>
  <form>
    <div class="card user-rating-card mb-1">
      <div class="card-body">
        <div class="user-rating">
          <input type="radio" id="star5" name="rating" value="5" />
          <label class="full" for="star5" title="5"></label>
          <input type="radio" id="star4half" name="rating" value="4.5" />
          <label class="half" for="star4half" title="4.5"></label>
          <input type="radio" id="star4" name="rating" value="4" />
          <label class="full" for="star4" title="4"></label>
          <input type="radio" id="star3half" name="rating" value="3.5" />
          <label class="half" for="star3half" title="3.5"></label>
          <input type="radio" id="star3" name="rating" value="3" />
          <label class="full" for="star3" title="3"></label>
          <input type="radio" id="star2half" name="rating" value="2.5" />
          <label class="half" for="star2half" title="2.5"></label>
          <input type="radio" id="star2" name="rating" value="2" />
          <label class="full" for="star2" title="2"></label>
          <input type="radio" id="star1half" name="rating" value="1.5" />
          <label class="half" for="star1half" title="1.5"></label>
          <input type="radio" id="star1" name="rating" value="1" />
          <label class="full" for="star1" title="1"></label>
          <input type="radio" id="starhalf" name="rating" value="0.5" />
          <label class="half" for="starhalf" title=" 0.5"></label>
        </div>
      </div>
    </div>

    <div class="form-group">
      <textarea class="form-control" id="userReviewText" rows="3" placeholder="Click to write"></textarea>
    </div>
    <div class="text-right">
      <button type="submit" id="userReviewSubmit" class="btn btn-primary">Submit</button>
    </div>
  </form>
</div>

<div class="my-5 text-center d-none" id="errorInfo">
  <h1 class="text-muted">Oops! Something went wrong <i class="fa fa-frown-o"></i></h1>
</div>

<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/bootstrap-4.6.0.bundle.min.js"></script>
<script src="js/recipe.js"></script>
</body>

</html>