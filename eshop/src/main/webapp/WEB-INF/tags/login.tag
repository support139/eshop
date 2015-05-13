<%@ tag language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pull-right login-header-form" style="height: 80px">
    <c:choose>
        <c:when test="${CURRENT_USER ne null}">
            <img src="Avatar?id=${CURRENT_USER.avatar}" height="100px">
            <a href="Logout">(logout)</a>
        </c:when>
        <c:otherwise>
            <form action="Login" method="post">
                <input type="text" placeholder="Login" name="login"/>
                <input type="password" placeholder="Password" name="password"/>
                <button type="submit">login</button>
            </form>
        </c:otherwise>
    </c:choose>
</div>
