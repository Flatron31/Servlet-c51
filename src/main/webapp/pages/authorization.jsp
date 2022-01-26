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

</head>
<body>
<form action="/authorization" method="post">
    <input type="text" name="login" placeholder="Login"> <p>${requestScope.msg1}</p>
    <input type="text" name="password" placeholder="Password"> <p>${requestScope.msg}</p>
    <p>${requestScope.error}</p>
    <button>Submit</button>
</form>

</body>
</html>
