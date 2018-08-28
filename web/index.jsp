<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
 table{
    width:500px;
    padding: 5px;
    text-align: center;
 }
 td{
    text-align: center;
    }
</style>
</head>
<body>
<h1>Hello!</h1>
<table>
<tr>
<th></th>
<th>Book</th>
<th>Авторы</th>
<th>Издание</th>
</tr>
<tr>
<td><b>GET ALL</b></td>
<td><a href="index.html">Книги</a></td>
<td><a href="authors.html">Авторы</a></td>
<td><a href="publishers.html">Издательства</a></td>
</tr>
<tr>
<td><b>GET BY NAME</b></td>
<td><form action="booksByName.html" method="get"><input type="text" name="title" placeholder="Имя книги">
<button type="submit">Найти</button></form></td>
<td><form action="getAuthorByName.html" method="get"><input type="text" name="name" placeholder="Имя автора">
<button type="submit">Найти</button></form></td>
<td><form action="publisherByName.html" method="get"><input type="text" name="name" placeholder="Имя издательства">
<button type="submit">Найти</button></form></td>
</tr>
<tr>
<td><b>GET BY ID</b></td>
<td><form action="booksByAuthors.html" method="get"><input type="text" name="id" placeholder="Поиск по id Автора">
<button type="submit">Найти</button></form></td>
<td><form action="getAuthorById.html" method="get"><input type="text" name="id" placeholder="id Автора">
<button type="submit">Найти</button></form></td>
<td><form action="publisherById.html" method="get"><input type="text" name="id" placeholder="id Издательства">
<button type="submit">Найти</button></form></td>
</tr>
<tr>
<td></td>
<td><b>Books by publisher</b></td>
<td></td>
<td><b>Publisher by Author id</b></td>
</tr>
<tr>
<td></td>
<td><form action="booksByPublisher.html" method="get"><input type="text" name="publisher_name" placeholder="Поиск по издательству">
<button type="submit">Найти</button></form></td>
<td></td>
<td><form action="publisherByAuthorId.html" method="get"><input type="text" name="id" placeholder="Поиск по id Автора">
<button type="submit">Найти</button></form></td>
<td></td>
</table>
</body>
</html>