<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26.01.2022
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Authorization</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<%--<form action="/authorization" method="post">--%>
<%--    <input type="text" name="login" placeholder="Login">--%>
<%--    ${requestScope.message1}--%>
<%--    <br>--%>
<%--    <input type="text" name="password" placeholder="Password">--%>
<%--    ${requestScope.message}--%>
<%--    <br>--%>
<%--    <button>Submit</button>--%>
<%--    ${requestScope.error}--%>
<%--</form>--%>
<%--<a href="/">Home</a>--%>
<%--<br>--%>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-5">
            <form action="/authorization" method="post">
                <div class="mb-3">
                    <label for="login" class="form-label">Login</label>
                    <input type="text" name="login" class="form-control" id="login">
                    ${requestScope.message1}
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="text" name="password" class="form-control" id="password">
                    ${requestScope.message}
                </div>
                <button type="submit" class="btn btn-info">Submit</button>
                ${requestScope.error}
            </form>
        </div>
    </div>
</div>

</body>
</html>
