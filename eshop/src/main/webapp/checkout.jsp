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

        <form action="SubmitOrder" method="post">
            <div class="shopper-informations">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="shopper-info">
                            <p>Summary information</p>

                            <input type="text" name="firstname" placeholder="First Name" value="${shopper.firstName}"
                                   disabled="disabled"></label>
                            <input type="text" name="lastname" placeholder="Last Name" value="${shopper.lastName}"
                                   disabled="disabled">
                            <input type="text" name="email" placeholder="Email" value="${shopper.email}"
                                   disabled="disabled">
                            <input type="text" name="mobilephone" placeholder="Mobile Phone"
                                   value="${shopper.mobilePhone}" disabled="disabled">

                            <input type="text" name="country" placeholder="Country" value="${shopper.country}"
                                   disabled="disabled">
                            <input type="text" name="state" placeholder="State" value="${shopper.state}"
                                   disabled="disabled">
                            <input type="text" name="adress" placeholder="Address" value="${shopper.adress}"
                                   disabled="disabled">
                            <input type="text" name="zipcode" placeholder="Zip / Postal Code" value="${shopper.zipCode}"
                                   disabled="disabled">

                            <input type="text" name="payment" placeholder="Payment" value="${shopper.payment}"
                                   disabled="disabled">
                            <c:if test="${shopper.payment eq 'Card payment'}">
                                <input type="text" name="cardId" placeholder="Card number" value="${shopper.cardId}"
                                       disabled="disabled">
                            </c:if>


                        </div>
                    </div>

                    <div class="col-sm-7">
                        <div class="order-message">
                            <p>Order list</p>
                        </div>
                        <div class="table-responsive cart_info">

                            <table class="table table-condensed">
                                <thead>
                                <tr class="cart_menu">
                                    <td class="description">Name</td>
                                    <td class="description">Price</td>
                                    <td class="quantity">Quantity</td>
                                    <td class="total">Total item price</td>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${basket.basket}">
                                    <tr>
                                        <td class="cart_description">
                                            <p>${item.key.name}</p>
                                        </td>
                                        <td class="cart_price">
                                            <p>${item.key.price}$</p>
                                        </td>
                                        <td class="cart_quantity">
                                            <p>${item.value}</p>
                                        </td>
                                        <td class="cart_total">
                                            <p class="cart_total_price">${item.key.price}$</p>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <tr class="cart_menu">
                                    <td></td>
                                    <td></td>
                                    <td class="quantity" id="quantity">Quantity: ${quantity}</td>
                                    <td class="total" id="total">Total: ${totalPrice}$</td>
                                </tr>
                                </tbody>
                            </table>
                            <button type="submit" class="btn btn-primary">Submit order!</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>


<!--/#cart_items-->

<t:footer/>

<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
</body>
</html>