<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 25.01.2022
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home</title>
</head>
<body>
<c:if test="${sessionScope.login != null}">
    <a href="/calculator">Calculator</a>
    <a href="/history_calculator">History</a>
    <form action="/logout" method="post">
        <button>Logout</button>
    </form>
</c:if>

<c:if test="${sessionScope.login == null}">
    <a href="/registration">Registration</a>
    <a href="/authorization">Authorization</a>
</c:if>
</body>
</html>
