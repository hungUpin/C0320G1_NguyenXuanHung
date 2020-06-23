<%--
  Created by IntelliJ IDEA.
  User: Hung
  Date: 08/06/2020
  Time: 9:12 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h1>
    <c:if test="${requestScope.deleteMessage!=null}">
        <span>${requestScope.deleteMessage}</span>
    </c:if>
</h1>
<h1>Customers</h1>
<p>
    <a href="/customers?action=create" class="btn btn-primary">Create new customer</a>
</p>
<table class="table table-bordered table-dark">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td>
            <a href="/customers?action=view&id=${customer.getCustomerID()}">${customer.getName()}</a>
            </td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td>
                <a href="/customers?action=edit&id=${customer.getCustomerID()}">edit</a>
            </td>
            <td>
                <a href="/customers?action=delete&id=${customer.getCustomerID()}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
