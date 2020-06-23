<%--
  Created by IntelliJ IDEA.
  User: Hung
  Date: 06/06/2020
  Time: 9:33 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
  .product{
    width: 468px; height: 137px;
    padding: 10px;
    margin: 0;
    border: 1px solid red;
  }
  .label{
    color: black;
    padding: 5px;
    margin: 20px;
    font-family: Arial;
  }
</style>
  <head>
    <title>Product Discount Calculator </title>
  </head>
  <body>
  <form method="post" action="/displayDiscount">
<div class = "product">
  <label >Product Description: </label>
  <input type="text" name = "productDescription" size="20px" placeholder="Product Description" ><br>
  <label > List Price: </label>
  <input type="text" name = "listPrice" size ="20px" placeholder="List Price"><br>
  <label>Discount percent: </label>
  <input type="text" name="discountPrice" size="20px" placeholder="Discount Percent"><br>
  <input type="submit" value="Result">
</div>
  </form>
  </body>
</html>
