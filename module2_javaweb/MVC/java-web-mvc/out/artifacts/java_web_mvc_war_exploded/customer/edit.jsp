<%--
  Created by IntelliJ IDEA.
  User: Hung
  Date: 08/06/2020
  Time: 11:27 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit customer</title>
    <style>
        .message{
            color: green;
        }
    </style>
</head>
<body>
<h1>Edit Customer: </h1>
<p>
<c:if test="${requestScope.message!=null}">
    <span class="message" >${requestScope.message}</span>
</c:if>
</p>
<p>
    <a href="/customers">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Edit customer</legend>
        <table>
        <tr>
            <td>Name: </td>
            <td><input type="text" name="name" value="${customer.getName()}"></td>
        </tr>
        <tr>
            <td>Email: </td>
            <td><input type="text" name="email" value="${customer.getEmail()}"></td>
        </tr>
        <tr>
            <td>Address: </td>
            <td><input type="text" name="address" value="${customer.getAddress()}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Update customer"></td>
        </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
