package ch09.tracking.ex03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/sess2")
public class sessionTest2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        out.println("세션 아디디 :" + session.getId()+"<br>");
        out.println("최초 세션 생성 시각 : "+new Date(session.getCreationTime()) +"<br>");
        out.println("최초 세션 접근 시각 : "+new Date(session.getLastAccessedTime()+ "<br>"));
        session.setMaxInactiveInterval(5); //세션 유효시간 5초로 설정
        out.println("세션 유효 시간 : "+session.getMaxInactiveInterval() +"<br>");
        if(session.isNew()){
            out.print("새 세션이 생성되엇습니다.");
        }
    }
}
