package ch09.tracking.ex03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/sess")
public class sessionTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        out.println("세션 아이디 : "+ session.getId());
        out.println("최초 세션 생성 시각 : " + session.getCreationTime() + "<br>");
        out.println("최초 세션 생성 시각 : " + session.getLastAccessedTime() + "<br>");
        out.println("최초 세션 생성 시각 : " + session.getMaxInactiveInterval() + "<br>");

        if(session.isNew()){
            out.println("새 세션이 만들어졌습니다");
        }


    }
}
