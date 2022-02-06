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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<%--<a href="/">Home</a>--%>
<%--<br>--%>
<%--<form action="/calculator" method="post">--%>
<%--    <input type="text" name="value1" placeholder="Value1" pattern="[+-]?([0-9]*[.])?[0-9]+" required>--%>
<%--    <select name="operation" required>--%>
<%--        <option disabled selected>Choose operation</option>--%>
<%--        <option value="sum">+</option>--%>
<%--        <option value="div">/</option>--%>
<%--        <option value="dif">-</option>--%>
<%--        <option value="mult">*</option>--%>
<%--    </select>--%>
<%--    <input type="text" name="value2" placeholder="Value1" pattern="[+-]?([0-9]*[.])?[0-9]+" required>--%>
<%--    ${requestScope.messageNull}--%>
<%--    ${requestScope.messageEmpty}--%>
<%--    ${requestScope.messageNaN}--%>
<%--    <br>--%>
<%--    <button>Result</button> ${requestScope.result}--%>


    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-5">
                <form action="/calculator" method="post">
                    <div class="mb-3">
                        <input type="text" name="value1" placeholder="Value1" pattern="[+-]?([0-9]*[.])?[0-9]+" required>
                    </div>
                    <select name="operation" required>
                        <option disabled selected>Choose operation</option>
                        <option value="sum">+</option>
                        <option value="div">/</option>
                        <option value="dif">-</option>
                        <option value="mult">*</option>
                    </select>
                    <div class="mb-3">
                        <input type="text" name="value2" placeholder="Value2" pattern="[+-]?([0-9]*[.])?[0-9]+" required>
                    </div>
                    ${requestScope.messageNull}
                    ${requestScope.messageEmpty}
                    ${requestScope.messageNaN}
                    <button type="submit" class="btn btn-primary">Result</button> ${requestScope.result}
                </form>
            </div>
        </div>
    </div>



</form>
</body>
</html>
