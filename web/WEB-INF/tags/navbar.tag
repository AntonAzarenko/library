<%@ tag  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="m" tagdir="/WEB-INF/tags/navbar" %>
<%@ attribute name="active" required="true"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="/library/"><ui:i19n message="library"/></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <m:menu css="navbar-nav mr-auto">
        <m:item url="/library" name="home" active="${active}"/>
        <m:item url="books.html" name="book" active="${active}"/>
        <m:item url="authors.html" name="author" active="${active}"/>
        <m:item url="publishers.html" name="publisher" active="${active}"/>
    </m:menu>
  </div>
</nav>
