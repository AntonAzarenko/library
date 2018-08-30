<%@ page language="java" pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<ui:html title="books">
    <c:if test="${not empty books}">
        <h1><ui:i19n message="book.find"/></h1>
       <table class="table table-striped">
       <thead class="thead-dark">
       <tr>
          <th class="col-md-4"><ui:i19n message="book.name"/></th>
          <th class="col-md-3"><ui:i19n message="author.name"/></th>
          <th class="col-md-3"><ui:i19n message="publisher.name"/></th>
       </tr>
       </thead>
       <tbody>
        <c:forEach items="${books}" var="book" varStatus="status">
        <tr>
            <td>${book.title}</td>
            <td>
                <c:forEach items="${book.author}" var="a" varStatus="status">
                    <span>${a.name}</span></br>
                </c:forEach>
            </td>
            <td>${book.publisher.name}</td>
        </tr>
        </c:forEach>
        </tbody>
        </table>
        
    </c:if>
    <c:if test="${empty books}">
        <ui:nofindalert/>
    </c:if>
</ui:html>
