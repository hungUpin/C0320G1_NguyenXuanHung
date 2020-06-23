<%--
  Created by IntelliJ IDEA.
  User: Hung
  Date: 08/06/2020
  Time: 2:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer information</title>
</head>
<body>
<h1>Customer information</h1>
<p>
    <a href="/customers">Back to customer list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope.customer.getName()}</td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${requestScope.customer.getEmail()}</td>
    </tr>
    <tr>
        <td>Address: </td>
        <td>${requestScope.customer.getAddress()}</td>
    </tr>
</table>
</body>
</html>
