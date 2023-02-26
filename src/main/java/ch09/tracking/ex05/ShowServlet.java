package ch09.tracking.ex05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ch09/show")
public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String id = "";
        String pw = "";

        Boolean isLogon = false;
        HttpSession session = req.getSession(false);
        if(session != null){
            isLogon = (Boolean)session.getAttribute("isLogon");
            if(isLogon){
                id = (String)session.getAttribute("user_id");
                pw = (String)session.getAttribute("user_pw");
                out.println("아이디 : "+id +"<br> 비밀번호 : "+ pw);
            }
        }
    }
}
