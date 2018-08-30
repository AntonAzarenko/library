<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<ui:html title="Author">
    <ui:navbar active="author"/>

<h1><ui:i19n message="author"/></h1>
<div class="d-flex justify-content-sm-center">
<div class="col-md-7">
<a href="#" class="btn btn-primary mb-3"><ui:i19n message="add"/></a>
<c:if test="${not empty authors}">
    <table class="table table-striped">
       <thead class="thead-dark">
       <tr>
          <th class="col-md-8"><ui:i19n message="author.name"/></th>
          <th class="col-md-2"></th>
          <th class="col-md-2"></th>
       </tr>
       </thead>
       <tbody>
        <c:forEach items="${authors}" var="author" varStatus="status">
        <tr>
            <td><a href="booksByAuthors.html?id=${author.id}" >${author.name}</a></td>
            <td><a href="#" class="btn btn-secondary float-right"><ui:i19n message="edit"/></a></td>
            <td><a href="#" class="btn btn-danger float-right"><ui:i19n message="delete"/></a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</div>
</div>
    
</ui:html>