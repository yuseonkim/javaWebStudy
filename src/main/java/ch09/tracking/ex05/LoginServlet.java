package ch09.tracking.ex05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ch09/login3")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req,resp);
    }

    protected void doHandle(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        String user_id = req.getParameter("user_id");
        String user_pw = req.getParameter("user_pw");

        MemberVO memberVO = new MemberVO(user_id,user_pw);
        MemberDAO dao = new MemberDAO();
        boolean result = dao.isExisted(memberVO);
        if(result){
            HttpSession session = req.getSession();
            session.setAttribute("isLogon",true);
            session.setAttribute("user_id",user_id);
            session.setAttribute("user_pw",user_pw);
            out.print("<html><body>");
            out.print("안녕하세요 "+user_id +"님!!<br>");
            out.print("<a href='show'>회원정보 조회</a>");
            out.print("</body></html>");
        }else{
            out.print("회원 아이디가틀립니다.");
            out.print("<a href='login3'> 다시 로그인하기</a>");
        }


    }
}
