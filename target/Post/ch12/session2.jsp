<%--
  Created by IntelliJ IDEA.
  User: yuling
  Date: 2023/02/27
  Time: 12:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = (String)session.getAttribute("name");
    String address = (String)session.getAttribute("address");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    이름은 <%=name%>입니다<br>
    주소는 <%=address%>입니다<br>
</body>
</html>
