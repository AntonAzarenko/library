<%@ tag  pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<%@ attribute name="name" required="true"%>
<%@ attribute name="url" required="true"%>
<%@ attribute name="active" required="true"%>
<ui:link href="${url }" text="${name }" css="${active eq url ? 'dropdown-item active' : 'dropdown-item'}"/>
