<%@ tag  pageEncoding="UTF-8"%>
<%@ attribute name="message" required="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:message code="${message}" text="${message}" />