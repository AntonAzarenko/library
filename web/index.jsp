<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<ui:html title="title">
    <ui:navbar page="asas" />

    <ui:title title="title" />

        <form action="search.html" method="post">
            <div class="form-group">
                <spring:message code="book.name" text="Book name" var="text" />
                <label for="book_name">${text}</label>
                <input type="text" class="form-control" id="book_name" name="book" placeholder="${text}">
                <div class="invalid-feedback">Please choose a username.</div>
            </div>
            <div class="form-group">
                <label for="author_name">Имя автора</label>
                <input type="text" class="form-control" id="author_name" name="author" placeholder="Имя автора">
            </div>
            <button type="submit" class="btn btn-primary">Найти</button>
        </form>

<table>
<tr>
<th></th>
<th>Book</th>
<th>Авторы</th>
<th>Издание</th>
</tr>
<tr>
<td><b>GET ALL</b></td>
<td><a href="index.html">Книги</a></td>
<td><a href="authors.html">Авторы</a></td>
<td><a href="publishers.html">Издательства</a></td>
</tr>
<tr>
<td><b>GET BY NAME</b></td>
<td><form action="booksByName.html" method="get"><input type="text" name="title" placeholder="Имя книги">
<button type="submit">Найти</button></form></td>
<td><form action="getAuthorByName.html" method="get"><input type="text" name="name" placeholder="Имя автора">
<button type="submit">Найти</button></form></td>
<td><form action="publisherByName.html" method="get"><input type="text" name="name" placeholder="Имя издательства">
<button type="submit">Найти</button></form></td>
</tr>
<tr>
<td><b>GET BY ID</b></td>
<td><form action="booksByAuthors.html" method="get"><input type="text" name="id" placeholder="Поиск по id Автора">
<button type="submit">Найти</button></form></td>
<td><form action="getAuthorById.html" method="get"><input type="text" name="id" placeholder="id Автора">
<button type="submit">Найти</button></form></td>
<td><form action="publisherById.html" method="get"><input type="text" name="id" placeholder="id Издательства">
<button type="submit">Найти</button></form></td>
</tr>
<tr>
<td></td>
<td><b>Books by publisher</b></td>
<td></td>
<td><b>Publisher by Author id</b></td>
</tr>
<tr>
<td></td>
<td><form action="booksByPublisher.html" method="get"><input type="text" name="publisher_name" placeholder="Поиск по издательству">
<button type="submit">Найти</button></form></td>
<td></td>
<td><form action="publisherByAuthorId.html" method="get"><input type="text" name="id" placeholder="Поиск по id Автора">
<button type="submit">Найти</button></form></td>
<td></td>
</table>
</ui:html>
