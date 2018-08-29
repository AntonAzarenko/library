<%@ tag  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<%@ attribute name="title" %>
<!DOCTYPE html>
<html>
<head>
    <c:if test="${not empty title}"><title><spring:message code="${title}" text="${title}" /></title></c:if>
    <c:url value="/css/bootstrap.min.css" var="href" /><link href="${href}" rel="stylesheet">
</head>
<body>
<div class="container">
<jsp:doBody />
</div>
<c:url value="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" var="jqhref" /><script src="${jqhref}" type="text/javascript"></script>
<c:url value="/js/bootstrap.min.js" var="bjshref" /><script src="${bjshref}" type="text/javascript"></script>
    <script type="text/javascript">
    //$(document).ready(function() {
    //    $(".navbar").find(".active").removeClass("active");
    //    $('.navbar-nav > li > a[href="'+location.pathname+'"]').parent().addClass('active');
    //});
   </script>
</body>
</html>
