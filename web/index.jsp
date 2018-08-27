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
</table>
</body>
</html>