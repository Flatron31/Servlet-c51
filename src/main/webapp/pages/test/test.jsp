<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 25.01.2022
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test ="${sessionScope.user == null}">
    <a href="registration">Registration</a>
    <a href="authorization">Authorization</a>
</c:if>

<ul>
    <c:forEach items="${requestScope.items}" var="item">
    <li>${item}</li>
    </c:forEach>
</ul>

<a href="/logout">Logout</a>


</body>
</html>
