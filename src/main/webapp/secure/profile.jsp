<%@ page import="am.basic.web.model.User" %><%--
  Created by IntelliJ IDEA.
  User: ruben.khachatryan
  Date: 12/26/2019
  Time: 6:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <% User user = (User) session.getAttribute("ttghg"); %>

<H1><%=user.getUsername()%></H1>

<H3><%=user.getName()%></H3>

<H4> <%   response.getWriter().println(user.getSurname()); %></H4>

</body>

</html>
