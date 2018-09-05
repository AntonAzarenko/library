<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<ui:html title="publisher">
    <div class="jumbotron">
        <ui:i19n message=""></ui:i19n>
        <form action="addpublisher.html" method="post">
            <input type="hidden" name="id" value="<c:out value="${publisher.id}"/>"/>
            <div class="form-group">
                <spring:message code="publisher.name" text="publisher name" var="text"/>
                <label for="publisher_name">${text}</label>
                <input type="text" class="form-control" id="publisher_name" name="name" placeholder="${text}" value="<c:out value="${publisher.name}"/>">
           </div>
            <button type="submit" class="btn btn-primary">Сохранить</button>
        </form>
    </div>
</ui:html>