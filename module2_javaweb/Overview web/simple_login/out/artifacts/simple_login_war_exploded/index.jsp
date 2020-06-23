<%--
  Created by IntelliJ IDEA.
  User: Hung
  Date: 05/06/2020
  Time: 11:04 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style type = "text/css">
  .login{
    height: 180px;width: 230px;
    margin:0;
    padding: 10px;
    border: 1px#CCC solid;
  }
  .login input{
    padding: 5px; margin:5px;
  }
</style>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post" action="/login">
    <div class="login">
      <h2>Login</h2>
      <label>
        <input type = "text" name = "username" size ="20" placeholder="username"/>
      </label>
      <label>
        <input type="password" name="password" size="20" placeholder="password"/>
      </label>
<input type = "submit" value="Sign in"/>
    </div>
  </form>
  </body>
</html>
