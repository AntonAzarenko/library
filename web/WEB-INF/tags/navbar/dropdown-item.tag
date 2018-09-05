<%@ tag  pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<%@ attribute name="name" required="true"%>
<%@ attribute name="url" required="true"%>
<%@ attribute name="active" required="true"%>
<li ${url eq active ?'class="nav-item dropdown active"': 'class="nav-item dropdown"'}>
    <a class="nav-link dropdown-toggle" href="${url }" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         <spring:message code="${name }" text="${name }" />
    </a>
    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
        <jsp:doBody />
    </div>
</li>
