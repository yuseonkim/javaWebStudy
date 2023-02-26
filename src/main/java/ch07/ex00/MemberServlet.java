package ch07.ex00;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
@WebServlet("/ch07/memberList")
public class MemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        MemberDAO dao = new MemberDAO();
        List list = dao.listMember();

        out.print("<html><body>");
        out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
        out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td>");

        for(int i=0;i<list.size();i++) {
            MemberVO memberVO = (MemberVO) list.get(i);
            String id = memberVO.getId();
            String pw= memberVO.getPw();
            String name = memberVO.getName();
            String email = memberVO.getEmail();
            Date joinDate = memberVO.getJoinDate();
            out.print("<tr><td>" + id + "</td><td>" + pw + "</td><td>" + name + "</td><td>" + email + "</td><td>"
                    + joinDate + "</td></tr>");
        }

        out.print("</table></body></html>");

    }
}
