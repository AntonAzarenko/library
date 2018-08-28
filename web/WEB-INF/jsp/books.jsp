<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<ui:html title="books">
	<c:choose>
		<c:when test="${not empty listBooks}">
			<h1>This is all books from Author: ${param.id}</h1>
			<table>
				<c:forEach items="${listBooks}" var="book" varStatus="status">
					<ul>
						<li>Номер книги: <b>${book.id}</b></li>
						<li>Название книги: <b>${book.title}</b></li>
					</ul>
				</c:forEach>
			</table>
		</c:when>
		<c:when test="${not empty book}">
			<h1>This is your selected book: ${param.title}</h1>
			<c:forEach items="${book}" var="books" varStatus="status">
				<ul>
					<li>Номер книги: <b>${books.id}</b></li>
					<li>Название книги: <b>${books.title}</b></li>
				</ul>
			</c:forEach>
		</c:when>
		<c:when test="${not empty books}">
			<h1>This is all books from publisher: ${param.publisher_name}</h1>
			<table>
				<c:forEach items="${books}" var="book2" varStatus="status">
					<ul>
						<li>Номер книги: <b>${book2.id}</b></li>
						<li>Название книги: <b>${book2.title}</b></li>
					</ul>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
</ui:html>
