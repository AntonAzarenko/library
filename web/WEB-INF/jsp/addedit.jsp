<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<ui:html title="title">
    <ui:navbar active="library"/>
    <ui:title title="title"/>
    <body>
    <div>
        <div>
            <h3>Add/Edit</h3>
        </div>
        <div class="jumbotron col">
            <form action="/booksave.html" method="post">
                <div class="form-group">
                    <spring:message code="book.name" text="Book name" var="text" />
                    <label for="book_name">${text}</label>
                    <input type="text" class="form-control" id="book_name" name="book" placeholder="${text}">
                    <div class="invalid-feedback">Please choose a book title.</div>
                </div>
                <div class="form-group">
                    <label for="discription">Описание</label>
                    <input type="text" class="form-control" id="discription" name="discription" placeholder="описание">
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <button class="btn btn-outline-secondary" type="button">Добавить</button>
                    </div>
                    <select class="custom-select" id="inputSelectPublisher" aria-label="Example select with button addon">
                        <option selected>Выберите издателя</option>
                        <c:forEach items="${publishers}" var="publisher">
                            <option value="${publisher.id}">${publisher.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <button class="btn btn-outline-secondary" type="button">Добавить</button>
                    </div>
                    <select class="custom-select" id="inputSelectAuthor" aria-label="Example select with button addon">
                        <option selected>Выберите автора</option>
                        <c:forEach items="${authors}" var="author">
                        <option value="${author.id}">${author.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>
        <div class="col">

        </div>
    </div>
    </body>
</ui:html>
