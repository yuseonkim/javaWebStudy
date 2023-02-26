<%--
  Created by IntelliJ IDEA.
  User: yuling
  Date: 2023/02/24
  Time: 1:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인창</title>
</head>
<body>
    <form name="frmLogin" method="post" action="login">
        아이디 : <input type="text" name="user_id"><br>
        비밀번호 : <input type="password" name="user_pw"><br>
        <input type="submit" value="로그인">
        <input type="reset" value="다시 입력">
        <input type="hidden" name="user_address" value="광주광역시 북구">
        <input type="hidden" name="user_email" value="yusun715@">
        <input type="hidden" name="user_hp" value="010-111-2222">
    </form>
</body>
</html>
