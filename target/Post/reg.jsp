<%--
  Created by IntelliJ IDEA.
  User: yuling
  Date: 2023/02/01
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="notice-reg" method="post">
        <div>
            <label>제목:</label><input type="text" name="title">
        </div>
        <div>
            <label>내용:</label><input type="text" name="content">
        </div>
        <div>
            <input type="submit" value="등록"/>
        </div>
    </form>

</body>
</html>
