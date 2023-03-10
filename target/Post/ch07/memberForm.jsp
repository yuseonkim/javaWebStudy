<%--
  Created by IntelliJ IDEA.
  User: yuling
  Date: 2023/02/19
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입창</title>
    <script type="text/javascript">
        function fn_sendMember(){
            var frmMember = document.frmMember;
            var id = frmMember.id.value;
            var pw = frmMember.pw.value;
            var name = frmMember.name.value;
            var email = frmMember.email.value;

            if(id.length == 0 || id == ""){
                alert("아이디는 필수입니다.");
            }else if(pw.length == 0 || pw == ""){
                alert("패스워드는 필수입니다.");
            }else if(name.length==0 || name == ""){
                alert("이름은 필수입니다.");
            }else if(email.length ==0 || email == ""){
                alert("이메일은 필수입니다.");
            }else {
                frmMember.method = "post";
                frmMember.action = "member3";
                frmMember.submit();
            }
        }
    </script>
</head>
<body>
    <form name="frmMember">
        <table>
            <th>회원가입창</th>
            <tr>
                <td>아이디</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="pw"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text" name="email"></td>
            </tr>
        </table>
        <input type="button" value="가입하기" onclick="fn_sendMember()">
        <input type="reset" value="다시입력">
        <input type="hidden" name="command" value="addMember"/>
    </form>

</body>
</html>
