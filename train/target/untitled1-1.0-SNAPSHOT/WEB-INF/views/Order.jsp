<%--
  Created by IntelliJ IDEA.
  User: danii
  Date: 15.11.2022
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set value="${requestScope.ListOfFood}" var="listOfFood"/>
<table>
    <tr><th>id</th><th>name</th><th>cost</th><th></th></tr>
    <c:forEach var="i" items="${listOfFood}">

        <tr><td>${i.id}</td><td>${i.name}</td><td>${i.cost}</td><td><form method="post" action="/addOrder">
            <input type="hidden" name="id" value="${i.id}">
            <button type="submit">В корзину</button>
        </form></td></tr>
    </c:forEach>
</table>
<h2>Выбранная еда</h2>

<c:set value="${requestScope.basketFood}" var="basketFood"/>
<table>
    <tr><th>id</th><th>name</th><th>cost</th><th></th></tr>
    <c:forEach var="i" items="${basketFood}">
        <tr><td>${i.id}</td><td>${i.name}</td><td>${i.cost}</td></tr>
    </c:forEach>
</table>
<button onclick="location.href='/formOrder'">Оформить</button>
</body>
</html>