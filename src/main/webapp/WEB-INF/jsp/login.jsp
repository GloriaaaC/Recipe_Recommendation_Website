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
	<script type="text/javascript" src="https://cdn.bootcss.com/jquery/1.4.0/jquery.js"></script>
	<script src="js/login.js"></script>
</head>

<body>
	<div id="maxbox">
		<h1>Welcome to Login</h1>
		<div class="inputbox">
			<form name="form">
				<div class="inputText">
					<span class="iconfont icon-mine"></span>
					<input id="username" type="text" name="username" placeholder="Username"/>
				</div>
				<div class="inputText">
					<span class="iconfont icon-lock"></span>
					<input id="password" type="password" name="password" placeholder="Password"/>
				</div>
				<button id="inputButton" class="inputButton" type="button" value="LOGIN">LOGIN</button>
			</form>
			<div id="sign_up">
				Don't have account ? <a style="cursor:pointer">Register</a>
			</div>
		</div>
	</div>

	<script>
		$(function () {
			$('a').click(function () {
				window.location.href = "/register";
			});
			$('a').css('text-decoration','underline');
		})
	</script>
</body>

</html>