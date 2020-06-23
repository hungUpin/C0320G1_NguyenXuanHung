<%--
  Created by IntelliJ IDEA.
  User: Hung
  Date: 06/06/2020
  Time: 9:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Simple Calculator</title>
  </head>
  <body>
  <h1>Simple Calculator</h1>
  <form method="post" action="/calculator">
    <table>
      <tr>
        <td>First operand: </td>
        <td><input type="text" name="operand" placeholder="First operand"></td>
      </tr>
      <tr>
        <td>Operator: </td>
        <td><select name="cal">
          <option value="Addition">Addition</option>
          <option value="Subtraction">Subtraction</option>
          <option value="Multiplication">Multiplication</option>
          <option value="Division">Division</option>
        </select></td>
      </tr>
      <tr>
        <td>Second Operand:</td>
        <td> <input type="text" name="secondOperand" placeholder="Second operand"></td>
      </tr>
    </table>
    <input type="submit" value="Calculate">
  </form>
  </body>
</html>
