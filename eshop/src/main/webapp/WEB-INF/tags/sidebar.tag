<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="my" uri="http://khodyka.com/" %>

<div class="col-sm-3" xmlns:c="http://www.w3.org/1999/html">
    <div class="left-sidebar">
        <h2>Category</h2>

        <div class="panel-group category-products" id="accordian"><!--category-productsr-->
            <c:forEach items="${Categories}" var="category">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <input type="checkbox" name="category" value="${category.id}"
                                   ${my:contains(Filter.categories, category.id)}> ${category.category}
                        </h4>
                    </div>
                </div>
            </c:forEach>
        </div>
        <!--/category-productsr-->
        <div class="brands_products"><!--brands_products-->
            <h2>Brands</h2>

            <div class="brands-name">
                <ul class="nav nav-pills nav-stacked">
                    <c:forEach items="${Manufacturers}" var="manufacturer">
                        <li><input type="checkbox" name="manufacturer" value="${manufacturer.id}"
                                   ${my:contains(Filter.manufacturers, manufacturer.id)}> ${manufacturer.manufacturer}
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <!--/brands_products-->

        <div class="brands_products"><!--brands_products-->
            <h2>Name</h2>
            <div class="brands-name">
                <ul class="nav nav-pills nav-stacked">
                    <input type="text" name="name" class="price">
                </ul>
            </div>
        </div>

        <div class="price-range"><!--price-range-->
            <h2>Price Range</h2>
            Min <input type="number" class="price min-price" name="minPrice">
            Max <input type="number" class="price" name="maxPrice">
            <button type="submit" class="btn btn-default btn-filter add-to-cart">Filter</button>
        </div>
        <!--/price-range-->

        <div class="shipping text-center"><!--shipping-->
            <img src="images/home/shipping.jpg" alt=""/>
        </div>
        <!--/shipping-->
    </div>
</div>