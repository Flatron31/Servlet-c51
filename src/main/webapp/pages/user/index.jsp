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


<c:if test="${sessionScope.login != null}">
    <nav class="nav" style="background-color: lightblue">
        <a class="nav-link" href="/calculator">Calculator</a>
        <a class="nav-link" href="/history_calculator">History</a>


        <form action="/logout" method="post">
            <a class="nav-link" href="/logout">Logout</a>
        </form>
    </nav>
</c:if>

<c:if test="${sessionScope.login == null}">
    <nav class="nav" style="background-color: lightblue">
        <a class="nav-link" href="/registration">Registration</a>
        <a class="nav-link" href="/authorization">Authorization</a>
    </nav>
</c:if>







</body>
</html>
