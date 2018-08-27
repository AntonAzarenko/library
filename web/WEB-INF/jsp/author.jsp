<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
	<c:if test="${not empty author}">
		<ul>
			<c:forEach items="${author}" var="authors" varStatus="status">
				<li>${authors.id}</li>
				<li>${authors.name}</li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>
