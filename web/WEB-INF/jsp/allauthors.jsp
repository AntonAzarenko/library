<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<ui:html title="Author">
    <ui:navbar active="author"/>
    <c:choose>
        <c:when test="${not empty authors}">
            <h1>This is all authors</h1>
                <c:forEach items="${authors}" var="author" varStatus="status">
                    <ul>
                        <li>id Автора: <b>${author.id}</b></li>
                        <li>Имя автора: <b>${author.name}</b></li>
                    </ul>
                </c:forEach>
        </c:when>
        
    </c:choose>
</ui:html>