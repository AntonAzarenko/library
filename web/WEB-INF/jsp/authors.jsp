<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h1>This is all ours authors!</h1>
<c:if test="${not empty authors}">
    <ul>
    <c:forEach items="${authors}" var="author" varStatus="status">
        <li>${author.id}</li>
        <li></li>
        <li>${author.name}</li>
    </c:forEach>
    </ul>
</c:if>

</body>
</html>