<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

    <c:choose>
        <c:when test="${not empty authors}">
            <h1>This is all selected authors</h1>
                <table>
                <c:forEach items="${authors}" var="author" varStatus="status">
                    <tr>
                        <td>${author.id}</td>
                        <td>${author.name}</td>
                    </tr>
                </c:forEach>
                </table>
        </c:when>
        
    </c:choose>
    

</body>
</html>
