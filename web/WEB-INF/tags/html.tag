<%@ tag  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="title" %>
<!DOCTYPE html>
<html>
<head>
    <c:if test="${not empty title}"><title><spring:message code="${title}" text="${title}" /></title></c:if>
    <c:url value="/css/bootstrap.css" var="href" /><link href="${href}" rel="stylesheet">
</head>
<body>
<div class="container">
<jsp:doBody />
</div>
</body>
</html>
