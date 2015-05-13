<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Login | E-Shopper</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/responsive.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head>
<!--/head-->

<body>
<t:header/>
<section id="form"><!--form-->
    <div class="container">
        <div class="row">
            <div class="col-sm-4 col-sm-offset-1">
                <div class="login-form"><!--login form-->
                    <h2>Login to your account</h2>

                    <form action="Login" method="post">
                        <input type="text" placeholder="Login" name="login"/>
                        <input type="password" placeholder="Password" name="password"/>
							<span>
								<input type="checkbox" class="checkbox"> 
								Keep me signed in
							</span>
                        <button type="submit" class="btn btn-default">Login</button>
                    </form>
                </div>
                <!--/login form-->
            </div>
            <div class="col-sm-1">
                <h2 class="or">OR</h2>
            </div>
            <div class="col-sm-4">

                <div class="signup-form"><!--sign up form-->
                    <h2>New User Signup!</h2>

                    <form action="Signup" id="signUpForm" method="post" enctype="multipart/form-data">
                        <input type="text" placeholder="Login" id="login" name="login" value="${formBean.login.value}"/>
                        <span id="loginRequired" class="errorSpan loginErrorSpan">Please enter login</span>
                        <span id="loginRegex" class="errorSpan loginErrorSpan">Invalid login</span>
                        <span id="loginServer"
                              class="errorSpan loginErrorSpan showError">${formBean.login.errorMessage}</span>

                        <input type="password" placeholder="Password" id="password" name="password"
                               value="${formBean.password.value}"/>
                        <span id="passwordRequired" class="errorSpan passwordErrorSpan">Please enter password</span>
                        <span id="passwordRegex" class="errorSpan passwordErrorSpan">Invalid password</span>
                        <span id="passwordServer"
                              class="errorSpan passwordErrorSpan showError">${formBean.password.errorMessage}</span>

                        <input type="text" placeholder="Name" id="name" name="name" value="${formBean.name.value}"/>
                        <span id="nameRequired" class="errorSpan nameErrorSpan">Please enter name</span>
                        <span id="nameRegex" class="errorSpan nameErrorSpan">Invalid name</span>
                        <span id="nameServer"
                              class="errorSpan nameErrorSpan showError">${formBean.name.errorMessage}</span>

                        <input type="text" placeholder="Surname" id="surname" name="surname"
                               value="${formBean.surname.value}"/>
                        <span id="surnameRequired" class="errorSpan surnameErrorSpan">Please enter surname</span>
                        <span id="surnameRegex" class="errorSpan surnameErrorSpan">Invalid surname</span>
                        <span id="surnameServer"
                              class="errorSpan surnameErrorSpan showError">${formBean.surname.errorMessage}</span>

                        <input type="text" placeholder="Email" id="email" name="email" value="${formBean.email.value}"/>
                        <span id="emailRequired" class="errorSpan emailErrorSpan">Please enter email</span>
                        <span id="emailRegex" class="errorSpan emailErrorSpan">Invalid email</span>
                        <span id="emailServer"
                              class="errorSpan emailErrorSpan showError">${formBean.email.errorMessage}</span>

                        <input name="avatar" type="file" accept="image/jpeg">
                        <t:captcha/>
                        <button type="submit" class="btn btn-default">Signup</button>
                    </form>
                </div>
                <!--/sign up form-->
            </div>
        </div>
    </div>
</section>
<!--/form-->
<t:footer/>
<script src="js/jquery.js"></script>
<script src="js/price-range.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
<!--  <script src="js/jqueryValid.js"></script>  -->
<!-- <script src="js/jsValidator.js"></script> -->
</body>
</html>