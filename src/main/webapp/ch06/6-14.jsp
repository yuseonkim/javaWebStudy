<%--
  Created by IntelliJ IDEA.
  User: yuling
  Date: 2023/02/15
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript">
        function fn_validate(){
            var frmLogin = document.frmLogin;
            var id = document.id.value;
            var password = document.password.value;

            if((id.length == 0 || id == "") || (password.length == 0 || pasword == "")) {
                alert("아이디와 비밀번호는 필수 입니다");
            }
                else{
                    frmLogin.method = "post";
                    frmLogin.action = "login5";
                    frmLogin.submit();
                }
        }

    </script>
    <title>Title</title>
</head>
<body>
    <form name ='frmLogin' method="post" action="login">
        <input type ="text" name="id" > 아이디  <br>
        <input type="password" name="password"><br>
        <input type="button" onClick="fn_validate()" value="로그인"><br>
        <input type="reset" value="다시입력"><br>
        <input type="hidden" name="user_address" value="광주광역시 북구"/>
    </form>

</body>
</html>
