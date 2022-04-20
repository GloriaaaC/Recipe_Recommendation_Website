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

  <title>Password</title>
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
        Change Password
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
    <div class="menu-item" data-toggle="tab" onclick=folders_on()>
      View all folders
    </div>
    <div class="menu-item" data-toggle="tab" onclick=history_on()>
      History
    </div>
    <div class="menu-item-active" data-toggle="tab" onclick=password_on()>
      Change password
    </div>
    <div class="menu-item" data-toggle="tab" onclick=sign_on()>
      Sign out
    </div>
  </div>

  <div id="right" class="right">

    <div class="col-md-6 offset-md-3 change-password">
      <span class="anchor" id="formChangePassword"></span>

      <div class="card card-outline-secondary">
        <div class="card-header">
          <h3 class="mb-0">Change Password</h3>
        </div>
        <div class="card-body">
          <form class="form" role="form" autocomplete="off">
            <div class="form-group">
              <label for="inputPasswordOld">Current Password</label>
              <input type="password" class="form-control" id="inputPasswordOld">
            </div>
            <div class="form-group">
              <label for="inputPasswordNew">New Password</label>
              <input type="password" class="form-control" id="inputPasswordNew">
              <span class="form-text  small text-muted">
                The password must be 8-20 characters, and must <em>not</em> contain spaces.
              </span>
            </div>
            <div class="form-group">
              <label for="inputPasswordNewVerify">Verify</label>
              <input type="password" class="form-control" id="inputPasswordNewVerify">
              <span class="form-text small text-muted">
                To confirm, type the new password again.
              </span>
            </div>
            <div class="form-group">
              <button class="btn btn-success btn-lg float-right" type="button" onclick=change_password()>Save</button>
            </div>
          </form>
        </div>
      </div>

    </div>

  </div>
</div>

<script src="/js/password.js"></script>
</body>
</html>