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
<a href="/">Home</a>
<br>
<form action="/calculator" method="post">
    <input type="text" name="value1" placeholder="Value1" pattern="[+-]?([0-9]*[.])?[0-9]+" required>
    <select name="operation" required>
        <option disabled selected>Choose operation</option>
        <option value="sum">+</option>
        <option value="div">/</option>
        <option value="dif">-</option>
        <option value="mult">*</option>
    </select>
    <input type="text" name="value2" placeholder="Value1" pattern="[+-]?([0-9]*[.])?[0-9]+" required>
    ${requestScope.messageNull}
    ${requestScope.messageEmpty}
    ${requestScope.messageNaN}
    <br>
    <button>Result</button> ${requestScope.result}

</form>
</body>
</html>
