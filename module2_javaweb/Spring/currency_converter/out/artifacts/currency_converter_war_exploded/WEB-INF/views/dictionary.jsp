<%--
  Created by IntelliJ IDEA.
  User: Hung
  Date: 10/06/2020
  Time: 9:27 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dictionary:</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td>Word: </td>
            <td><input type="text" name="word"></td>
        </tr>
        <tr>
            <td rowspan="2"><td><input type="submit" value="Translate"></td></td>
        </tr>
    </table>
    <c:if test="${result!=null}">
        <h3>Result: ${result}</h3>
    </c:if>
</form>
</body>
</html>
