<%--
  Created by IntelliJ IDEA.
  User: yuling
  Date: 2023/02/27
  Time: 12:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    session.setAttribute("name","이순신");
    application.setAttribute("address","광주광역시 북구");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>이름과 주소를 저장합니다</h1>
<a href="appTest2.jsp"> 두 번째 웹 페이지로 이동 </a>

</body>
</html>
