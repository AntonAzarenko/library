<%@ tag  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<%@ attribute name="title" %>
<!DOCTYPE html>
<html>
<head>
    <c:if test="${not empty title}"><title><ui:i19n message="${title}"/></title></c:if>
    <c:url value="/css/bootstrap.min.css" var="href" /><link href="${href}" rel="stylesheet">
    <c:url value="/css/style.css" var="shref"/><link href="${shref}" rel="stylesheet">
    <c:url value="/css/font-awesome.css" var="fhref"/><link href="${fhref}" rel="stylesheet">
</head>
<body>
<c:url value="/js/jquery-3.3.1.min.js" var="jqhref" /><script src="${jqhref}" type="text/javascript"></script>
<c:url value="/js/bootstrap.min.js" var="bjshref" /><script src="${bjshref}" type="text/javascript"></script>
<div class="container">
<jsp:doBody />
</div>
    <script type="text/javascript">
    //$(document).ready(function() {
    //    $(".navbar").find(".active").removeClass("active");
    //    $('.navbar-nav > li > a[href="'+location.pathname+'"]').parent().addClass('active');
    //});
   </script>
</body>
</html>
