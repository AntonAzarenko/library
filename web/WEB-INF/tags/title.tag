<%@ tag  pageEncoding="UTF-8"%>
<%@ attribute name="title" required="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<h1><spring:message code="${title}" text="${title}" /></h1>
