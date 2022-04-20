<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/iconfont.css">
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/register.js"></script>
</head>

<body>
<div id="maxbox">
    <h1>Welcome to Register</h1>
    <div class="inputbox">
        <form name="form" action="" method="post">
            <div class="inputText">
                <span class="iconfont icon-mine"></span>
                <input id="username" type="text" name="username" placeholder="Username"/>
            </div>
            <div class="inputText">
                <span class="iconfont icon-lock"></span>
                <input id="password" type="password" name="password" placeholder="Password"/>
            </div>
            <div class="inputText">
                <span class="iconfont icon-lock"></span>
                <input id="confirmPassword" type="password" name="confirmPassword" placeholder="Confirm Password"/>
            </div>
            <button class="inputButton" type="button" value="REGISTER">REGISTER</button>
        </form>
        <div id="sign_up">
            Already have account ? <a style="cursor:pointer">Login</a>
        </div>
    </div>
</div>

<script>
    $(function () {
        $('a').click(function () {
            window.location.href = "/login";
        });
        $('a').css('text-decoration','underline');
    })
</script>
</body>

</html>