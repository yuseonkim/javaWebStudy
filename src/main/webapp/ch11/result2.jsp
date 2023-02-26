<%--
  Created by IntelliJ IDEA.
  User: yuling
  Date: 2023/02/26
  Time: 6:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    String user_id = request.getParameter("user_id");
    String user_pw = request.getParameter("user_pw");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
    if(user_id == null || user_id.length() ==0 ){
    %>
    아이디를 입력하세요.<br>
    <a href="/ch11/login.jsp"> 로그인하기 </a>
    <%
    }else{
    %>
    <h1>환영합니다 <%=user_id%>님!!</h1>
    <%
    }
    %>

</body>
</html>
