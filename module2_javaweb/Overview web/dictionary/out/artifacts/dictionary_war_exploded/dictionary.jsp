<%@ page import="javax.naming.ldap.HasControls" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Hung
  Date: 07/06/2020
  Time: 10:45 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<%!
    Map<String,String> dictionary = new HashMap<String,String>();
%>
<%
    dictionary.put("hello","xin chào");
    dictionary.put("today","hôm nay");
    dictionary.put("hi","chào");
    String word = request.getParameter("word");
    String result = dictionary.get(word);
    if (result != null) {
        out.println("Word: " + word);
        out.println("<br>Result: " + result);
    } else {
        out.println("Not found");
    }
%>
</body>
</html>
