<%--
  Created by IntelliJ IDEA.
  User: Hung
  Date: 08/06/2020
  Time: 11:00 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        .message{
            color: green;
        }
    </style>
</head>
<body>
<h1>Product List</h1>
<c:if test="${requestScope.message!=null}">
    <span class="message">${requestScope.message}</span>
</c:if>
<p>
    <a href="/products?action=create" class="btn btn-primary">Create New Product</a>
</p>
<form method="get">
    <input type="text" class="form-control" name="nameSearch" placeholder="Enter product name"><br>
    <input type="submit" value="Find" class="btn btn-primary">
</form>
<table class="table table-bordered table-dark">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${requestScope.productList}" var="product">
        <tr>
            <td><a href="/products?action=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>
                <a href="/products?action=update&id=${product.getId()}">Update |</a>
                <a href="/products?action=delete&id=${product.getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>

</table>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
