<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" xmlns:t="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Cart | E-Shopper</title>
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

<body>
<t:header/>
<section id="cart_items">
    <div class="container">
        <div class="breadcrumbs">
            <ol class="breadcrumb">
                <li><a href="#">Home</a></li>
                <li class="active">Shopping Cart</li>
            </ol>
        </div>
        <div class="table-responsive cart_info">
            <table class="table table-condensed">
                <thead>
                <tr class="cart_menu">
                    <td class="image">Item</td>
                    <td class="description">Name</td>
                    <td class="description">Price</td>
                    <td class="quantity">Quantity</td>
                    <td class="total">Total</td>
                    <td></td>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="item" items="${basket.basket}">
                    <tr id="${item.key.id}">
                        <td class="cart_product">
                            <img src="Picture?picture=${item.key.picture}" width="200">
                        </td>
                        <td class="cart_description">
                            <p>${item.key.name}</p>
                        </td>
                        <td class="cart_price">
                            <p>${item.key.price}$</p>
                        </td>
                        <td class="cart_quantity">
                            <input type="number" class="product-quantity" min="1" value="${item.value}"
                                   onchange="quantityAjaxRequest(${item.key.id}, $(this).val())">
                        </td>
                        <td class="cart_total">
                            <p class="cart_total_price">${item.value * item.key.price}$</p>
                        </td>
                        <td class="cart_delete">
                            <a class="cart_quantity_delete" onclick="deleteOrderItemRequest(${item.key.id})"><i
                                    class="fa fa-times"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                <tr class="cart_menu">
                    <td class="quantity" id="quantity" colspan="4" style="text-align: right">Quantity: ${quantity}</td>
                    <td class="total" id="total" colspan="2">Total: ${totalPrice}$</td>
                </tr>
                </tbody>
            </table>
            <form action="NewOrder" method="post">
                <button type="submit" class="btn btn-primary">Next!</button>
            </form>
        </div>
    </div>
</section>
<t:footer/>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
</body>
</html>