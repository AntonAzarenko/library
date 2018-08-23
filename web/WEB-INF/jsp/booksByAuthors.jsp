<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h1>This is all books from ${author}</h1>

    <ul>
    <c:forEach items="${listBooks}" var="book" varStatus="status">
        <li>${book.id}</li>
        <li>${book.title}</li>
        <li>${book.author.name}</li>
    </c:forEach>
    </ul>


</body>
</html>