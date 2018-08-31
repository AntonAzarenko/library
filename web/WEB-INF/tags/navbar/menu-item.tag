<%@ tag  pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<%@ attribute name="name" required="true"%>
<%@ attribute name="url" required="true"%>
<%@ attribute name="active" required="true"%>
<li ${url eq active ?'class="nav-item active"': 'class="nav-item"'}>
    <ui:link href="${url }" text="${name }" css="nav-link" />
</li>