package ch10.scope.ex01;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/set")
public class SetAttribute extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String ctxMsg = "context에 바인딩 됩니다";
        String sesMsg = "session에 바인딩 됩니다";
        String regMsg = "request에 바인딩 됩니다.";

        ServletContext ctx = getServletContext();
        HttpSession session = req.getSession();
        ctx.setAttribute("context",ctxMsg);
        session.setAttribute("session",sesMsg);
        req.setAttribute("request",regMsg);

        out.print("바인딩을 수행합니다");
    }
}
