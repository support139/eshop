<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" xmlns:t="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Checkout | E-Shopper</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/responsive.css" rel="stylesheet">
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

<t:header/>
<div id="cart_items">
    <div class="container">
        <div class="breadcrumbs">
            <ol class="breadcrumb">
                <li><a href="#">Home</a></li>
                <li class="active">Check out</li>
            </ol>
        </div>
        <form action="CheckoutOrder" method="post">
            <div class="shopper-informations">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="shopper-info">
                            <p>Shopper Information</p>
                            <input type="text" name="firstname" placeholder="First Name">
                            <input type="text" name="lastname" placeholder="Last Name">
                            <input type="text" name="email" placeholder="Email">
                            <input type="text" name="mobilephone" placeholder="Mobile Phone">

                            <button type="submit" class="btn btn-primary">Continue</button>
                        </div>
                    </div>
                    <div class="col-sm-5 clearfix">
                        <div class="bill-to">
                            <p>Bill To</p>

                            <div class="form-one">
                                <input type="text" name="country" placeholder="Country">
                                <input type="text" name="state" placeholder="State">
                                <input type="text" name="adress" placeholder="Address">
                                <input type="text" name="zipcode" placeholder="Zip / Postal Code">
                                <input type="text" name="cardId" placeholder="Card number" id="cardId">
                            </div>
                            <div class="form-two">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="order-message">
                            <p>Shipping Order</p>
                            <textarea name="message" placeholder="Notes about your order, Special Notes for Delivery"
                                      rows="16"></textarea>
                        </div>
                    </div>
                </div>
            </div>
            <div class="payment-options">
					<span>
						<label><input type="radio" name="payment" value="Bank transfer" id="bankPayment">Direct Bank
                            Transfer</label>
					</span>
					<span>
						<label><input type="radio" name="payment" value="Card payment" id="cardPayment">Card
                            payment</label>
					</span>
					<span>
						<label><input type="radio" name="payment" value="Paypal" id="paypalPayment">Paypal</label>
					</span>
            </div>
            <div>

            </div>
        </form>
    </div>
</div>
</section>

<!--/#cart_items-->

<t:footer/>

<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
</body>
</html>