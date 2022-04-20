<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="/css/bootstrap-4.6.0.min.css">
    <link rel="stylesheet" href="/css/font-awesome-4.7.0.min.css">
    <link rel="stylesheet" href="/css/history-and-recipe.css">
    <link rel="stylesheet" href="/css/account.css">
    <link rel="stylesheet" href="/css/iconfont.css">

    <title>favourites</title>
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
                Favourite Recipes
                <!-- <a class="nav-link" href="#">History</a> -->
            </li>
            <!-- <li class="nav-item">
              <a class="nav-link" href="#">Recipe</a>
            </li> -->
        </ul>
        <div class="nav-icons text-right">
            <a class="fa fa-search fa-lg mx-3" href="/index"></a>
            <a class="fa fa-history fa-lg mx-3" href="/history"></a>
            <a class="fa fa-user-o fa-lg mx-3" href="/account"></a>
        </div>
    </div>
</nav>

<div class="container-fluid">

    <div id="left" class="left">
        <div id="logoDiv" class="logoDiv">
            <p id="logoTitle" class="logoTitle">
                <span style="font-size:24px;">MY ACCOUNT</span>
            </p>
        </div>

        <div class='profile'>
            <img src="http://5b0988e595225.cdn.sohucs.com/images/20190819/aa5810f6582243bb823377630fa79832.jpeg" class="round_icon"  alt="">
        </div>

        <div class="menu-title" style="font-size:20px; color: white" >Personal Setting</div>
        <div class="menu-item" data-toggle="tab" onclick=folders()>
            View all folders
        </div>
        <div class="menu-item" data-toggle="tab" onclick=view_history()>
            History
        </div>
        <div class="menu-item" data-toggle="tab" onclick=reset_password()>
            Change password
        </div>
        <div class="menu-item" data-toggle="tab" onclick=signout()>
            Sign out
        </div>
    </div>

    <div id="right" class="right">
            <div class="col-md-12 favourite-title">
              <h1 id="folder_name">  </h1>
            </div>
        <div class="row justify-content-start mx-6 px-6 favourite-title" id="recipe_list">


        </div>


    </div>
</div>>

<script src="/js/favourite.js"></script>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/bootstrap-4.6.0.bundle.min.js"></script>
</body>
</html>