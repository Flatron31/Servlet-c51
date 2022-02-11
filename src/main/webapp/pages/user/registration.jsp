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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<%--    <style>--%>
<%--        button {--%>
<%--            color: aqua;--%>
<%--            background-color: chartreuse;--%>
<%--        }--%>

<%--    </style>--%>
</head>
<body>
<%--<a href="/">Home</a>--%>
<%--<br>--%>
<%--<form action="/registration" method="post">--%>
<%--    <input type="text" name="login" placeholder="Login">--%>
<%--    <br>--%>
<%--    <input type="text" name="password" placeholder="Password">--%>
<%--    <br>--%>
<%--    <input type="text" name="name" placeholder="Name">--%>
<%--    <br>--%>
<%--    <button>Submit</button>--%>
<%--    ${requestScope.messageErrorRegistration}--%>
<%--</form>--%>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-5">
            <form action="/registration" method="post">
                <div class="mb-3">
                    <label for="login" class="form-label">Login</label>
                    <input type="text" name="login" class="form-control" id="login">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="text" name="password" class="form-control" id="password">
                </div>
                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" name="name" class="form-control" id="name">
                </div>
                <button type="submit" class="btn btn-secondary">Registration</button>
                ${requestScope.messageErrorRegistration}
                ${requestScope.ErrorUserExist}
            </form>
        </div>
    </div>
</div>
</body>
</html>
