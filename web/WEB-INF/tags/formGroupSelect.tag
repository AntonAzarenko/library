<%@ tag  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<%@ attribute name="ids" required="true"%>
<%@ attribute name="label" required="true"%>
<%@ attribute name="name" required="true"%>
<%@ attribute name="value" required="false" %>
<%@ attribute name="item" required="true" %>
<%@ attribute name="var" required="true" %>
<%@ attribute name="book" required="true" %>
<%@ attribute name="invFeedback" required="true"%>
<%@ attribute name="required"%>
<%--<c:set var="required" value="${not empty required ? required : ''}"/>--%>
<div class="form-group">
    <label for="${ids}"><ui:i19n message="${label}"/></label>
    <select type="text"
           class="custom-select"
           id="${ids}"
           name="${name}">
        <c:forEach items="${item}" var="${var}">
            <option value="${var.id}" ${var.id == book.publisher.id?'selected' :''}>${publisher.name}</option>
        </c:forEach>
    </select>

           value="<c:out value="${value}"/>"/>

    <div class="invalid-feedback"><ui:i19n message="${invFeedback}"/></div>
</div>