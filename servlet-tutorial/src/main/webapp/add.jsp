<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>i + j</title>
</head>
<body bgcolor="red">
<%
    int i=Integer.parseInt(request.getParameter("num1"));
    int j=Integer.parseInt(request.getParameter("num2"));
    int k=i+j;
    response.getWriter().println("result is "+k);
%>
</body>
</html>
