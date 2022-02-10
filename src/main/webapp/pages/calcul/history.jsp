<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 27.01.2022
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>History</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav class="nav" style="background-color: lightblue">
    <h3>History:</h3>
</nav>
<nav class="nav" style="background-color: lightblue">
    <div class="btn-group" role="group" aria-label="Basic example">
        <a class="nav-link" href="/calculator">Calculator</a>
        <div class="row justify-content-right">
            <form action="/logout" method="post">
                <button type="submit" class="btn btn-primary">Logout</button>
            </form>
        </div>
    </div>
</nav>
<%--<a href="/">Home</a>--%>
<%--<br>--%>
<ul>
    <c:if test="${requestScope.history.size() != 0}">
        <c:forEach items="${requestScope.history}" var="item">
            <li>${item}</li>
        </c:forEach>
    </c:if>
</ul>

<c:if test="${requestScope.history.size() == 0}">
    <p>History  user is empty</p>
</c:if>






</body>
</html>
