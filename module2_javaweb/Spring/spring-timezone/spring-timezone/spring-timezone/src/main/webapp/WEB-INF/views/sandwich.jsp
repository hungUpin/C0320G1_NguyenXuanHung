<%--
  Created by IntelliJ IDEA.
  User: Hung
  Date: 11/06/2020
  Time: 2:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="sandwich" method="get">
    <input type="checkbox" name="condiment" value="Lettuce">
    <span>Lettuce</span>
    <input type="checkbox" name="condiment" value="Tomato">
    <span>Tomato</span>
    <input type="checkbox" name="condiment" value="Mustard">
    <span>Mustard</span>
    <input type="checkbox" name="condiment" value="Sprouts">
    <span>Sprouts</span><br>
    <input type="submit" value="Save">
</form>
<c:if test="${condiment!=null}">
    <span>Result: ${condiment}</span>
</c:if>
</body>
</html>
