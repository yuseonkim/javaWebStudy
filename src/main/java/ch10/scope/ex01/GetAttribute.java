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

@WebServlet("/get")
public class GetAttribute extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out =resp.getWriter();
        ServletContext ctx = getServletContext();
        HttpSession sess = req.getSession();

        String ctxMsg = (String)ctx.getAttribute("context");
        String sesMsg = (String)sess.getAttribute("session");
        String reqMsg = (String)req.getAttribute("request");

        out.print("context 값 : "+ ctxMsg + "<br>");
        out.print("session 값 : "+ sesMsg +"<br>");
        out.print("request 값 : "+reqMsg );
    }
}
