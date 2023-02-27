<%--
  Created by IntelliJ IDEA.
  User: yuling
  Date: 2023/02/27
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    import= "java.util.*"
         import ="ch09.tracking.ex05.*"
%>

<html>
<head>
    <title>Title</title>
    <style>
        h1{
            text-align : center;
        }
    </style>
</head>
<body>
<h1>회원정보출력</h1>

<%
    request.setCharacterEncoding("utf-8");
    String _name = request.getParameter("name");
    MemberVO memberVO = new MemberVO();
    memberVO.setName(_name);
    MemberDAO dao = new MemberDAO();
    List memberList = dao.listMember(memberVO);
%>
<table border="1" width="800" align="center">
    <tr align="center" bgcolor="#FFFF66">
        <td>아이디</td>
        <td>비밀번호</td>
        <td>이름</td>
        <td>이메일</td>
        <td>가입일자</td>
    </tr>

    <%
        for(int i=0;i<memberList.size();i++){
            MemberVO vo = (MemberVO)memberList.get(i);
            String id = vo.getId();
            String pw = vo.getPw();
            String name = vo.getName();
            String email = vo.getEmail();
            Date joinDate = vo.getJoinDate();
    %>

    <tr align="center">
        <td> <%=id%></td>
        <td> <%=pw%></td>
        <td> <%=name%></td>
        <td> <%=email%></td>
        <td> <%=joinDate%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
