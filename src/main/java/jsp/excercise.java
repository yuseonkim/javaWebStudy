package jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/jsp.excercise")
public class excercise extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        String button = req.getParameter("button");

        String a_ = req.getParameter("a");
        String b_ = req.getParameter("b");
        int a = 0;
        int b = 0;
        if(!a_.equals("")) a = Integer.parseInt(a_);
        if(!b_.equals("")) b = Integer.parseInt(b_);


        if(button.equals("덧셈"))
            writer.println(a+b);
        if(button.equals("뺄셈"))
            writer.println(a-b);
    }
}
