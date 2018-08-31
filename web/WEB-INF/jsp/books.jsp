<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<ui:html title="title">
    <ui:navbar active="books.html"/>
    
<h1><ui:i19n message="book"/></h1>
<div class="col-md-12">
<a href="edit.html" class="btn btn-primary mb-3"><ui:i19n message="add"/></a>
<c:if test="${not empty books}">
    <table class="table table-striped">
       <thead class="thead-dark">
       <tr>
          <th class="col-md-4"><ui:i19n message="book.name"/></th>
          <th class="col-md-3"><ui:i19n message="publisher.name"/></th>
          <th class="col-md-3"><ui:i19n message="author.name"/></th>
          <th class="col-md-1"></th>
          <th class="col-md-1"></th>
       </tr>
       </thead>
       <tbody>
        <c:forEach items="${books}" var="book" varStatus="status">
        <tr>
            <td>${book.title}</td>
            <td>${book.publisher.name}</td>
            <td>
                <c:forEach items="${book.author}" var="a" varStatus="status">
                    <span>${a.name}</span></br>
                </c:forEach>
            </td>
            <td><a href="edit.html?id=${book.id}" class="btn btn-secondary float-right"><ui:i19n message="edit"/></a></td>
            <td><a href="remove.html?id=${book.id}" class="btn btn-danger float-right"><ui:i19n message="delete"/></a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</div>
    
</ui:html>
