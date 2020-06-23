<%--
  Created by IntelliJ IDEA.
  User: Hung
  Date: 10/06/2020
  Time: 9:20 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency converter</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td>Currency rate:</td>
            <td><input type="text" name="rate" value="22000"></td>
        </tr>
        <tr>
            <td>USD:</td>
            <td><input type="text" name = "usd"></td>
        </tr>
        <td rowspan="2">
            <input type="submit" value="Convert">
        </td>
    </table>
</form>
</body>
</html>
