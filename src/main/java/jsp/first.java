package jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/notice-reg")
public class first extends HttpServlet {
    protected void service(HttpServletRequest req,
                           HttpServletResponse resp) throws ServletException, IOException {
//        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");
//         req.setCharacterEncoding("UTF-8");


        PrintWriter out = resp.getWriter();
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        out.println(title);
        out.println(content);


    }
}
