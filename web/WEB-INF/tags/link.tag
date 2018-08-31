<%@ tag pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="href" required="true"%>
<%@ attribute name="text" required="true"%>
<%@ attribute name="css" required="false"%>
 <c:out value="${href}" var="_href_" /><a${empty css ? '' : 'class="' + css + '"'} href="${_href_}"><spring:message code="${text}" text="${text}" /></a>