package ch08.binding.ex03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/ch08/viewMembers")
public class viewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ArrayList<MemberVO> memberList = (ArrayList<MemberVO>) req.getAttribute("memberList");
        out.print("<html><body");
        out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
        out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td>");
        for(int i=0;i<memberList.size();i++){
            MemberVO memberVo = memberList.get(i);
            String id = memberVo.getId();
            String pw = memberVo.getPw();
            String name = memberVo.getName();
            String email = memberVo.getEmail();
            Date joinDate = memberVo.getJoinDate();
            out.print("<tr><td>"+id+"</td><td>"+pw+"</td><td>"+name+"</td><td>"+email+"</td><td>"+joinDate+"</td><td>"+
                    "<a href='/ch07/member3?command=delMember&id="+id);
        }
        out.print("</table></body></html>");
        out.print("<a href='/ch07/memberForm.jsp");
    }
}
