<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<ui:html title="title">
<ui:navbar active="/library"/>
    <ui:title title="title" />

        <form action="search.html" method="post">
            <ui:formGroup id="book_name" label="book.name" name="book"
                          placeholder="book.name" invFeedback="Please choose a bookname."/>
            <ui:formGroup id="author_name" label="author.name" name="author"
                          placeholder="author.name" invFeedback="Please choose a author."/>
            <ui:formGroup id="publisher_name" label="publisher" name="publisher"
                          placeholder="publisher" invFeedback="Please choose a publisher."/>
            <button type="submit" class="btn btn-primary">
                <ui:i19n message="index.button.find"/>
            </button>
        </form>
</ui:html>
