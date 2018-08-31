<%@ tag pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="href" required="true"%>
<%@ attribute name="text" required="true"%>
<%@ attribute name="css" required="false"%>

 <a ${empty css ? '' : fn:join(fn:split('Class=\",\"', ','), css)} href="<c:out value="${href}"/>"><spring:message code="${text}" text="${text}" /></a>
