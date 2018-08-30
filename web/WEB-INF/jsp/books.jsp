<%@ page language="java" pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<ui:html title="books">
    <c:if test="${not empty books}">
        <h1><ui:i19n message="book.find"/></h1>
        <table>
            <c:forEach items="${books}" var="book2" varStatus="status">
                <ul>
                    <li><ui:i19n message="book.name"/> <b>${book2.title}</b></li>
                    <c:forEach items="${book2.author}" var="author">
                        <li><ui:i19n message="author.name"/> <b>${author.name}</b></li>
                    </c:forEach>
                </ul>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty books}">
        <ui:nofindalert/>
    </c:if>
</ui:html>
