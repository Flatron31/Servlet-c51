<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 25.01.2022
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Registration</title>

</head>
<body>
<a href="/">Home</a>
<br>
<form action="/registration" method="post">
    <input type="text" name="login" placeholder="Login">
    <br>
    <input type="text" name="password" placeholder="Password">
    <br>
    <input type="text" name="name" placeholder="Name">
    <br>
    <button>Submit</button>
    ${requestScope.messageErrorRegistration}
</form>

</body>
</html>
