<%@ tag  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<%@ attribute name="active" required="true"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="/library/"><ui:i19n message="library"/></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li ${'library' eq active ?'class="nav-item active"': 'class="nav-item"'}>
        <a class="nav-link" href="/library/"><ui:i19n message="home"/></a>
      </li>
      <li ${'book' eq active ?'class="nav-item active"': 'class="nav-item"'}>
        <a class="nav-link" href="index.html"><ui:i19n message="book"/></a>
      </li>
      <li ${'author' eq active ?'class="nav-item active"': 'class="nav-item"'}>
        <a class="nav-link" href="authors.html"><ui:i19n message="author"/></a>
      </li>
      <li ${'publisher' eq active ?'class="nav-item active"': 'class="nav-item"'}>
        <a class="nav-link" href="publishers.html"><ui:i19n message="publisher"/></a>
      </li>
    </ul>
  </div>
</nav>