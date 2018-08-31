<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<ui:html title="title">
    <ui:title title="title" />
    <c:if test="${not empty books}">
    <ul>
        <c:forEach items="${books}" var="booke" varStatus="status">
        <li>${booke.id} ${booke.title} <a href="booksByAuthors.html?id=<c:out value = "${book.author.id}"/>" >${book.author.name}</a> </li>
        </c:forEach>
    </ul>
    </c:if>
</ui:html>
