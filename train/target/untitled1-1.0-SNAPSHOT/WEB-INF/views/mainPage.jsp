<%--
  Created by IntelliJ IDEA.
  User: danii
  Date: 15.11.2022
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button onclick="location.href='/signIn'">signIn</button>
<button onclick="location.href='/addOrder'">AddOrder</button>
<c:set var="i" value="${requestScope.list}"/>
<table>
    <c:forEach var="j" items="${i}">
        <tr><td>${j.id}</td><td>${j.status}</td></tr>
    </c:forEach>
</table>
</body>
</html>
