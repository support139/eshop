<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="my" uri="http://khodyka.com/" %>

<ul class="pagination">

    <input type="hidden" id="url">

    <c:forEach begin="1" end="${numOfPages}" var="pageNum">
        <c:choose>
            <c:when test="${Filter.page == pageNum}">
                <li><a class="pagination_link active" href="${queryString}&page=${pageNum}" page="${pageNum}">${pageNum}</a></li>
            </c:when>
            <c:otherwise>
                <li><a class="pagination_link" href="${queryString}&page=${pageNum}" page="${pageNum}">${pageNum}</a></li>
            </c:otherwise>
        </c:choose>
    </c:forEach>


</ul>