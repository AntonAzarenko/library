<%@ tag pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="css" required="true"%>

<ul class="${css}">
    <jsp:doBody />
</ul>