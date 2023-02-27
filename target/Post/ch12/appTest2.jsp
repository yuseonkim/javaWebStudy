<%--
  Created by IntelliJ IDEA.
  User: yuling
  Date: 2023/02/27
  Time: 12:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = (String)session.getAttribute("name");
    String address = (String)application.getAttribute("address");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>이름은 <%=name%> <br></h1>
<h1>주소는 <%=address%></h1>
</body>
</html>
