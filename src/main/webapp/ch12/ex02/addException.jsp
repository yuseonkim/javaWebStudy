<%--
  Created by IntelliJ IDEA.
  User: yuling
  Date: 2023/02/27
  Time: 1:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@
        page contentType="text/html;charset=UTF-8" language="java"
             isErrorPage="true"
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
====== toString() 내용 ====== <br>
<h1><%=exception.toString()%> </h1>
====== getMessage() 내용 ====== <br>
<h1><%=exception.getMessage() %></h1>
====== printStackTrace() 내용 ====== <br>
<h1> <% exception.printStackTrace(); %></h1>
<h3>
    숫자만 입력 가능합니다. 다시 시도하세요!!!
    <a href="add.jsp">다시 하기 </a>
</h3>
</body>
</html>
