package ch08.forward.ex04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second4")
public class second extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("dispatch를 이용한 forward 실습입니다");
        out.println("name : " + name);
        out.println("</body></html>");
    }
}
