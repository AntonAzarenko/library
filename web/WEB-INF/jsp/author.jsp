<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<ui:html title="author">
	<c:if test="${not empty author}">
		<h1>This is selected Author</h1>
		<ul>
				<li>id Автора: <b>${author.id}</b></li>
				<li>Имя автора: <b>${author.name}</b></li>
		</ul>
	</c:if>
	<c:if test="${empty author}">
		<ui:nofindalert/>
	</c:if>
</ui:html>
