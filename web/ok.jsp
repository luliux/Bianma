<%--
  Created by IntelliJ IDEA.
  User: 卢柳辛
  Date: 2023/6/23
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  out.print("欢迎您:"+session.getAttribute("username"));
%>
</body>
</html>
