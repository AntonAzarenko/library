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
        <div class="jumbotron">
            <form action="booksave.html" method="post">
                <input type="hidden" name="id" value="
                        <c:out value="${book.id}"/>">
                <div class="form-group">
                    <spring:message code="book.name" text="Book name" var="text" />
                    <label for="book_name">${text}</label>
                    <input type="text"  class="form-control" id="book_name" name="title" placeholder="${text}"
                           value="<c:out value="${book.title}"/>">
                    <div class="invalid-feedback">Please choose a book title.</div>
                </div>
                <div class="form-group">
                    <label for="discription">Описание</label>
                    <input type="text" class="form-control" id="discription" name="discription" placeholder="описание"
                           value="<c:out value="${book.description}"/>">
                </div>
                <div class="form-group">
                    <label for="inputSelectPublisher">Выберите издателя</label>
                    <select class="custom-select" name="publisherId" id="inputSelectPublisher">
                        <c:forEach items="${publishers}" var="publisher">
                            <option value="${publisher.id}" ${publisher.id == book.publisher.id?'selected' :''}>${publisher.name}</option>
                            <%--<option value="${publisher.id}">${publisher.name}</option>--%>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="inputSelectPublisher">Выберите автора или нескольких</label>
                    <select class="custom-select" name="authors" id="inputSelectAuthor" multiple size="3" data-live-search-normalize="true" data-live-search="true" data-container="body" data-header="Ocupaciones" data-max-options="2" max-options-text="Solo dos opciones" title="Seleccionar ocupaciones" multiple>
                        <c:forEach items="${authors}" var="author">
                            <option value="${author.id}" ${author.id == book.author.id?'selected' :''}>${author.name}</option>
                        <%--<option value="${author.id}">${author.name}</option>--%>
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
