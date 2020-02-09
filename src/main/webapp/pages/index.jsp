<%--
  Created by IntelliJ IDEA.
  User: ruben.khachatryan
  Date: 12/26/2019
  Time: 6:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% if (request.getAttribute("abcd") != null){response.getWriter().println(request.getAttribute("abcd"));} %>


<form method="post" action="/login">
    Username : <input type="text" name="username"><br/>
    Password : <input type="password" name="pass"><br/>
    <input type="submit" name="Sign in">
</form>
<a href="/registr.html">for Registration</a>
</body>
</html>
