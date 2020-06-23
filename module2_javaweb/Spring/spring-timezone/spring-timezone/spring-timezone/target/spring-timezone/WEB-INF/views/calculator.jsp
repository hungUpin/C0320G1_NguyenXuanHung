<%--
  Created by IntelliJ IDEA.
  User: Hung
  Date: 11/06/2020
  Time: 4:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculator" method="get">
<input type="text" name="firstNum">
<input type="text" name="secondNum"><br><br>
<input type="submit" name="button" value="Addition(+)">
<input type="submit" name="button" value="Subtraction(-)">
<input type="submit" name="button" value="Multiplication(X)">
<input type="submit" name="button" value="Division(/)">
</form>
<c:if test="${result!=null}">
    <h2>Result: ${result}</h2>
</c:if>
</body>
</html>
