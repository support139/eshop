<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en" xmlns:t="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Shop | E-Shopper</title>
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
<section id="advertisement">
    <div class="container">
        <img src="images/shop/advertisement.jpg" alt=""/>
    </div>
</section>

<section>
    <div class="container">
        <div class="row">
            <form method="get" action="Product">
                <t:sidebar/>
                <select style="width: 150px; margin-left: 550px" name="orderBy" id="orderBy" onchange="submit()">
                    <c:choose>
                        <c:when test="${Filter.orderBy eq 'price'}">
                            <option value="price" selected>Price</option>
                        </c:when>
                        <c:otherwise>
                            <option value="price">Price</option>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${Filter.orderBy eq 'name'}">
                            <option value="name" selected>Name</option>
                        </c:when>
                        <c:otherwise>
                            <option value="name">Name</option>
                        </c:otherwise>
                    </c:choose>
                </select>

                <select style="width: 150px" name="limit" onchange="submit()">
                    <c:choose>
                        <c:when test="${Filter.limit == 3}">
                            <option value="3" selected>3</option>
                        </c:when>
                        <c:otherwise>
                            <option value="3">3</option>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${Filter.limit == 6}">
                            <option value="6" selected>6</option>
                        </c:when>
                        <c:otherwise>
                            <option value="6">6</option>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${Filter.limit == 12}">
                            <option value="12" selected>12</option>
                        </c:when>
                        <c:otherwise>
                            <option value="12">12</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </form>
            <c:if test="${numOfPages > 1}">
                <t:pagination/>
            </c:if>
            <div class="col-sm-9 padding-right">
                <div class="features_items"><!--features_items-->
                    <h2 class="title text-center">Features Items</h2>
                    <c:choose>
                        <c:when test="${numOfPages ne 0}">
                            <c:forEach items="${Guitars}" var="guitar">
                                <div class="col-sm-4">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <img src="Picture?picture=${guitar.picture}" alt=""/>

                                                <h2>$${guitar.price}</h2>

                                                <p>${guitar.name}</p>
                                                    <%--<div id="backetDiv"></div>--%>
                                                <button type="button" onclick="buyAjaxRequest(${guitar.id})"
                                                        class="btn btn-default add-to-cart">
                                                    <i class="fa fa-shopping-cart"></i><f:message key="add"/>
                                                </button>
                                                    <%--<a href="#" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Add to cart</a>--%>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="choose">
                                            <ul class="nav nav-pills nav-justified">
                                                <li><a href=""><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
                                                <li><a href=""><i class="fa fa-plus-square"></i>Add to compare</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            No goods!
                        </c:otherwise>
                    </c:choose>
                </div>
                <!--features_items-->
                <c:if test="${numOfPages > 1}">
                    <t:pagination/>
                </c:if>
                <!--<ul class="pagination">
                    <li class="active"><a href="">1</a></li>
                    <li><a href="">2</a></li>
                    <li><a href="">3</a></li>
                    <li><a href="">&raquo;</a></li>
                </ul>-->
            </div>
        </div>
    </div>
</section>
<t:footer/>
<script src="js/jquery.js"></script>
<script src="js/price-range.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
</body>
</html>