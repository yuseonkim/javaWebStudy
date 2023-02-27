<%--
  Created by IntelliJ IDEA.
  User: yuling
  Date: 2023/02/27
  Time: 12:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String name = (String)session.getAttribute("name");
  session.setAttribute("address","광주광역시 북구");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  이름은 <%=name%> 입니다<br>
  <a href="session2.jsp">두 번째 페이지로 이동</a>

</body>
</html>
