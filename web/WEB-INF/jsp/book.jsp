<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<ui:html title="title">
    <ui:navbar active="books.html"/>

    <h1>${not empty book ? book.title : "Oops"}</h1>
    <c:if test="${not empty book}">
        <div class="col-md-12">
            <c:if test="${not empty book.metadata}">
                <c:if test="${not empty book.metadata.picture}">
                    <img src="${book.metadata.picture}"
                         alt="picture" class="img-fluid">
                </c:if>
            </c:if>
            <ul>
                <h4>Title:</h4>
                <li>${book.title}</li>
            </ul>
            <ul>
                <h4>Publisher</h4>
                <li>${book.publisher.name}</li>
            </ul>
            <c:if test="${not empty book.description}">
                <ul>
                    <h4>Description:</h4>
                    <li>{book.description}</li>
                </ul>
            </c:if>
            <ul>
                <h4>Authors</h4>
                <li>
                    <c:forEach items="${book.author}" var="a" varStatus="status">
                        <span>${a.name}</span></br>
                    </c:forEach>
                </li>
            </ul>
        </div>
    </c:if>

</ui:html>
