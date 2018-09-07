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
            <form action="booksave.html" method="post" enctype="multipart/form-data" multiple="true">

                <input type="hidden" name="id" value="
                        <c:out value="${book.id}"/>">
<%--                <div class="form-group">
                    <spring:message code="book.name" text="Book name" var="text"/>
                    <label for="book_name">${text}</label>
                    <input type="text" class="form-control" id="book_name" name="title" placeholder="${text}"
                           value="<c:out value="${book.title}"/>">
                </div>
                <div class="form-group">
                    <label for="discription">Описание</label>
                    <input type="text" class="form-control" id="discription" name="discription" placeholder="описание"
                           value="<c:out value="${book.description}"/>">
                </div>--%>
                <ui:formGroup id="book_name" label="${text}" name="title" placeholder="book.name.placeholder"
                              invFeedback="Write book name" value="${book.title}" required="true"/>
                <ui:formGroup id="description" label="Описание" name="description"
                              placeholder="book.description.placeholder" invFeedback="Write description"
                              value="${book.description}"/>
                <div class="row">
                    <div class="col-8">
                        <div class="form-group">
                            <label for="inputSelectPublisher">Выберите издателя</label>
                            <select class="custom-select" name="publisherId" id="inputSelectPublisher">
                                <c:forEach items="${publishers}" var="publisher">
                                    <option value="${publisher.id}" ${publisher.id == book.publisher.id?'selected' :''}>${publisher.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-sm pt-2 mt-3">
                        <a href="#" class="btn btn-info"><i class="fa fa-plus"></i></a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-8">
                        <div class="form-group">
                            <label for="inputSelectPublisher">Выберите автора или нескольких</label>
                            <select class="custom-select" name="authors" id="inputSelectAuthor" multiple size="3"
                                    data-live-search-normalize="true" data-live-search="true" data-container="body"
                                    data-header="Ocupaciones" data-max-options="2" max-options-text="Solo dos opciones"
                                    title="Seleccionar ocupaciones" multiple>
                                <c:forEach items="${authors}" var="author">
                                    <option value="${author.id}" ${book.author.contains(author)?'selected' :''}>${author.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-sm pt-2 mt-5">
                        <a href="authoredit.html" class="btn btn-info"><i class="fa fa-plus"></i></a>
                    </div>
                </div>
                <div class="form-group">
                    <div>
                        <label for="inputGroupFile01">Выберите обложку</label>
                    </div>
                    <div class="input-group mb-3">
                        <div class="custom-file">
                            <input type="file" name="files" accept="image/*" class="custom-file-input" id="inputGroupFile01"
                                   aria-describedby="inputGroupFileAddon01">
                            <label class="custom-file-label" for="bookimg">Choose file</label>
                            <!-- input id="bookimg" type="file" name="files" accept="image/*"-->
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div>
                        <label for="inputGroupFile02">Выберите файл</label>
                    </div>
                    <div class="input-group mb-3">
                        <div class="custom-file">
                            <input type="file" name="files" accept="application/zip" class="custom-file-input" id="inputGroupFile02"
                                   aria-describedby="inputGroupFileAddon02">
                            <label class="custom-file-label" for="bookzip">Choose file</label>
                            <!-- input id="bookzip" type="file" name="files" accept="application/zip"-->
                        </div>
                    </div>
                </div>


                <button type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>
    </div>
        <script>
            $('#inputGroupFile01,#inputGroupFile02').on('change',function(){
                var fileName = $(this).val();
                $(this).next('.custom-file-label').html(fileName);
            });
        </script>
    </body>
</ui:html>
