<%@ tag  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="name" required="true"%>
<%@ attribute name="url" required="true"%>
<%@ attribute name="active" required="true"%>
<li ${'library' eq active ?'class="nav-item active"': 'class="nav-item"'}>
    <a class="nav-link" href="${url}">${name}</a>
</li>