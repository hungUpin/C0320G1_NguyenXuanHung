<%--
  Created by IntelliJ IDEA.
  User: Hung
  Date: 06/06/2020
  Time: 4:59 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Khai báo sử dụng JSTL Core Tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style>
  table,th,td{
    border: 1px solid red;
  }
</style>
  <head>
    <title>Customer List</title>
  </head>
  <body>
  <table >
    <tr>
      <th>Customer Name</th>
      <th>Day of birth</th>
      <th>Address</th>
      <th>Picture</th>
    </tr>
    <c:forEach items="${customers}" var="cus">
    <tr>
      <th>${cus.getName()}</th>
      <th>${cus.getBirth()}</th>
      <th>${cus.getAddress()}</th>
      <th><img src="${cus.getPictureLink()}" alt="${cus.getName()}" width="200px" height="200px"/></th>
    </tr>
    </c:forEach>
  </table>
  </body>
</html>
