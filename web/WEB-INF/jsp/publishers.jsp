<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<ui:html title="Publishers">
    <c:if test="${not empty publishers}">
        <h1>Publishers</h1>
        <ul>
            <c:forEach items="${publishers}" var="publisher" varStatus="status">
            <li>${publisher.id} ${publisher.name}</li>
            </c:forEach>
        </ul>
    </c:if>
</ui:html>