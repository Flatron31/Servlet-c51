<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 27.01.2022
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
</head>
<body>
<nav class="nav" style="background-color: lightblue">
    <h1>History:</h1>
</nav>
<%--<a href="/">Home</a>--%>
<%--<br>--%>

    ${requestScope.history}
</body>
</html>
