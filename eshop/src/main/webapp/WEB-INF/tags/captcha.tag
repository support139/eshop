<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${hiddenCaptchaId ne null}">
		<img src="Captcha?hiddenCaptchaId=${hiddenCaptchaId}">
		<input type="hidden" value="${hiddenCaptchaId}" name="captcha">
	</c:when>
	<c:otherwise>
		<img src="Captcha">
	</c:otherwise>
</c:choose>
<input type="text" name="captchaValue">
