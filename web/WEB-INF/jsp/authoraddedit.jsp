<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<ui:html title="author.edit.title">
    <ui:navbar active="authors"/>
    <ui:title title="author.edit.title" />
    <form action="authorsave.html" method="post">
        <ui:formGroup id="author_name" label="author.name" name="author" placeholder="author.name.placeholder"
                      invFeedback="author.edit.authorinvalidefeedback" required="1"/>
        <button type="submit" class="btn btn-primary">
            <ui:i19n message="author.edit.buttonsave"/>
        </button>
    </form>

</ui:html>