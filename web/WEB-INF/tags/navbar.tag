<%@ tag  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<%@ attribute name="active" required="true"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="/library/">Library</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    
      <li ${'library' eq active ?'class="nav-item active"': 'class="nav-item"'}>
        <spring:message code="library" text="Library" var="library" />
        <a class="nav-link" href="/library/">${library}</a>
      </li>
      <li ${'book' eq active ?'class="nav-item active"': 'class="nav-item"'}>
        <spring:message code="book" text="Books" var="book" />
        <a class="nav-link" href="index.html">${book}</a>
      </li>
      <li ${'author' eq active ?'class="nav-item active"': 'class="nav-item"'}>
        <spring:message code="author" text="Authors" var="author" />
        <a class="nav-link" href="authors.html">${author}</a>
      </li>
      <li ${'publisher' eq active ?'class="nav-item active"': 'class="nav-item"'}>
        <spring:message code="publisher" text="Publishers" var="publisher" />
        <a class="nav-link" href="publishers.html">${publisher}</a>
      </li>
    </ul>
  </div>
</nav>