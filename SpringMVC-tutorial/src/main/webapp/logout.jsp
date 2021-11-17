<%--
  Created by IntelliJ IDEA.
  User: Harrdy
  Date: 2021/11/17
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退出登录</title>
</head>
<body>
    <p>退出系统</p>
    <% session.removeAttribute("username"); %>
</body>
</html>
