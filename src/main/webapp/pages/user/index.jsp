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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<%--<c:if test="${sessionScope.login != null}">--%>
<%--    <a href="/calculator">Calculator</a>--%>
<%--    <a href="/history_calculator">History</a>--%>
<%--    <form action="/logout" method="post">--%>
<%--        <button>Logout</button>--%>
<%--    </form>--%>
<%--</c:if>--%>

<%--<c:if test="${sessionScope.login == null}">--%>
<%--    <a href="/registration">Registration</a>--%>
<%--    <a href="/authorization">Authorization</a>--%>
<%--</c:if>--%>

<%--        --%>
<%--        <form action="/history_calculator">--%>
<%--            <button type="button" class="btn btn-primary">Нistory</button>--%>
<%--            <button type="submit" class="btn btn-primary" style="background-color: slateblue">Нistory</button>--%>
<%--        </form>--%>
<%--        <form action="/logout" method="post">--%>
<%--            <button type="submit" class="btn btn-primary" style="background-color: slateblue">Logout</button>--%>
<%--        </form>--%>
<c:if test="${sessionScope.login != null}">
    <nav class="nav" style="background-color: lightblue">
        <div class="btn-group" role="group" aria-label="Basic example">
            <a class="nav-link" href="/history_calculator">Нistory</a>

            <form action="/logout" method="post">
                <button type="submit" class="btn btn-primary">Logout</button>
            </form>
        </div>
    </nav>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-4">
                <form action="/calculator" method="post">
                    <div class="mb-3">
                        <input type="text" name="value1" placeholder="Value1" class="form-control" pattern="[+-]?([0-9]*[.])?[0-9]+" required>
                    </div>
                    <select class="form-select mb-3" name="operation" required>
                        <option disabled selected>Choose operation</option>
                        <option value="sum">+</option>
                        <option value="div">/</option>
                        <option value="dif">-</option>
                        <option value="mult">*</option>
                    </select>
                    <div class="mb-3">
                        <input type="text" name="value2" placeholder="Value2"class="form-control" pattern="[+-]?([0-9]*[.])?[0-9]+" required>
                    </div>
                        ${requestScope.messageNull}
                        ${requestScope.messageEmpty}
                        ${requestScope.messageNaN}
                    <button type="submit" class="btn btn-primary">Result</button> ${requestScope.result}
                </form>
            </div>
        </div>
    </div>
</c:if>

<c:if test="${sessionScope.login == null}">
    <nav class="nav" style="background-color: lightblue">
        <a class="nav-link" href="/registration">Registration</a>
        <a class="nav-link" href="/authorization">Authorization</a>
    </nav>
</c:if>







</body>
</html>
