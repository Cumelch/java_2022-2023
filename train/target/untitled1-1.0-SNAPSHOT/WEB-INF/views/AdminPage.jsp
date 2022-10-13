<%--
  Created by IntelliJ IDEA.
  User: danii
  Date: 15.11.2022
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="orders" value="${requestScope.listOfIdOfOrders}"/>
<table>
    <c:forEach var="i" items="${orders}">
        <tr><td>${i}</td><td> <form method="post" action="/adminPage">
            <input type="hidden" value="${i}" name="orderId">
            <button type="submit">Готов</button>
        </form></td><td> <form method="post" action="/deleteOrder">
            <input type="hidden" value="${i}" name="deleteId">
            <button type="submit">Выдан</button>
        </form></td></tr>
    </c:forEach>
</table>
</body>
</html>
