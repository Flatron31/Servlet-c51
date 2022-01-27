<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26.01.2022
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>

</head>
<body>
<form action="/calculator" method="post">
    <input type="text" name="value1" placeholder="Value1">
    <input type="text" name="action" placeholder="Action">
    <input type="text" name="value2" placeholder="Value1">
    <br>
    ${requestScope.messageNull}
    ${requestScope.messageEmpty}
    ${requestScope.messageNaN}
    ${requestScope.result}
    <br>
    <button>Result</button>
</form>
</body>
</html>
