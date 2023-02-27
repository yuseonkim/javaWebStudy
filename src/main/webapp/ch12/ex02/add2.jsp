<%--
  Created by IntelliJ IDEA.
  User: yuling
  Date: 2023/02/27
  Time: 1:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@
        page contentType="text/html;charset=UTF-8" language="java"
             pageEncoding="utf-8"
             errorPage="addException.jsp"
%>

<%
    int num = Integer.parseInt(request.getParameter("num"));
    int sum = 0;
    for(int i=1;i<=num;i++){
        sum += i;
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>합계구하기</h2>
    <h1>1부터 <%=num%>까지 합은 <%=sum%>입니다</h1>
</body>
</html>
