package ch07.ex02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/ch07/member3")
public class MemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }

    private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDAO dao = new MemberDAO();
        PrintWriter out = resp.getWriter();
        String command = req.getParameter("command");

        if (command != null && command.equals("addMember")){
            String _id = req.getParameter("id");
            String _pw = req.getParameter("pw");
            String _name = req.getParameter("name");
            String _email = req.getParameter("email");
            MemberVO vo = new MemberVO();

            vo.setId(_id);
            vo.setPw(_pw);
            vo.setName(_name);
            vo.setEmail(_email);
            dao.addMember(vo);
        } else if (command != null && command.equals("delMember")) {
            String id = req.getParameter("id");
           // dao.delMember(id);
        }

        ArrayList<MemberVO> list = dao.listMember();
        out.print("<html><body>");
        out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
        out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td></tr>");

        for (int i = 0; i < list.size(); i++) {
            MemberVO memberVO = (MemberVO) list.get(i);
            String id = memberVO.getId();
            String pw = memberVO.getPw();
            String name = memberVO.getName();
            String email = memberVO.getEmail();
            Date joinDate = memberVO.getJoinDate();
            out.print("<tr><td>" + id + "</td><td>" + pw + "</td><td>" + name + "</td><td>" + email + "</td><td>" + joinDate
                    + "</td><td>" + "<a href='/ch07/member3?command=delMember&id="+id+ "'> 삭제 </a></td></tr>");
        }

        out.print("</table></body></html>");
        out.print("<a href='/ch07/memberForm.jsp'>새회원가입하기</a>");

    }


}


