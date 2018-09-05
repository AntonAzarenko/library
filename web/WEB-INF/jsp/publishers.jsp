<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags"%>
<ui:html title="Publishers">
<ui:navbar active="publishers.html"/>
<h1><ui:i19n message="publisher"/></h1>
<div class="d-flex justify-content-sm-center">
<div class="col-md-7">
<a href="addpublisher.html" class="btn btn-primary mb-3"><ui:i19n message="add"/></a>
<c:if test="${not empty publishers}">
	<table class="table table-striped">
       <thead class="thead-dark">
       <tr>
          <th class="col-md-8"><ui:i19n message="publisher.name"/></th>
          <th class="col-md-2"></th>
          <th class="col-md-2"></th>
       </tr>
       </thead>
       <tbody>
        <c:forEach items="${publishers}" var="publisher" varStatus="status">
        <tr>
            <td><a href="booksByPublisher.html?publisher_name=${publisher.name}" >${publisher.name}</a></td>
            <td><a href="editpublisher.html?id=${publisher.id }" class="btn btn-secondary float-right"><ui:i19n message="edit"/></a></td>
            <td>
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#confirDialog" data-id="${publisher.id }" data-text="${publisher.name }"><ui:i19n message="delete"/></button>
             </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</div>
</div>

<ui:deleteDialog message="Вы точно хотите удалить" action="removePublisher.html" title="Подтверждение удаления"/>

</ui:html>