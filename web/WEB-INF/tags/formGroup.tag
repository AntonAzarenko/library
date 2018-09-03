<%@ tag  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<%@ attribute name="id" required="true"%>
<%@ attribute name="label" required="true"%>
<%@ attribute name="name" required="true"%>
<%@ attribute name="value" required="false" %>
<%@ attribute name="placeholder" required="true"%>
<%@ attribute name="invFeedback" required="true"%>
<%@ attribute name="required"%>
<%--<c:set var="required" value="${not empty required ? required : ''}"/>--%>
<div class="form-group">
    <label for="${id}"><ui:i19n message="${label}"/></label>
    <input type="text"
           class="form-control"
           id="${id}"
           name="${name}"
           value="<c:out value="${value}"/>"
           placeholder='<ui:i19n message="${placeholder}"/>'
    ${not empty required ? ' aria-describedby="inputGroupPrepend" required' :' '}>
    <div class="invalid-feedback"><ui:i19n message="${invFeedback}"/></div>
</div>