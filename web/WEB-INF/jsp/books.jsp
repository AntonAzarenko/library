<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
    <c:choose>
        <c:when test="${not empty listBooks}">
            <h1>This is all books from ${author}</h1>
                <table>
                <c:forEach items="${listBooks}" var="book" varStatus="status">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.title}</td>
                    </tr>
                </c:forEach>
                </table>
        </c:when>
        <c:when test="${not empty book}">
            <h1>This is your selected book</h1>
            <ul>
                <li>${book.id}</li>
                <li>${book.title}</li>
                <li>${book.author.name}</li>
            </ul>
        </c:when>
        <c:when test="${not empty books}">
            <h1>This is all books from publisher: ${publisher.name}</h1>
                <table>
                <c:forEach items="${books}" var="book" varStatus="status">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.title}</td>
                        <td>${book.author.name}</td>
                    </tr>
                </c:forEach>
                </table>
        </c:when>
        <c:otherwise>
        </otherwise>
    </c:choose>
</body>
</html>
