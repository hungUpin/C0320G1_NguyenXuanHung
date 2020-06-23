<%--
  Created by IntelliJ IDEA.
  User: Hung
  Date: 09/06/2020
  Time: 8:40 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<form method="post">
    <p >
        <a class="btn btn-primary" href="/products">Back</a>
    </p>
        <h1>Are you sure to delete?</h1>
        <table class="table table-bordered table-dark">
            <tr>
                <td>Name: </td>
                <td>${requestScope.product.getName()}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${requestScope.product.getPrice()}</td>
            </tr>
            <tr>
                <td>Description: </td>
                <td>${requestScope.product.getDescription()}</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Delete product"></td>
            </tr>
        </table>
</form>
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
