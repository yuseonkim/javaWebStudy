package jsp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/exercise3")
public class excercise3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = req.getServletContext();
        HttpSession session = req.getSession();
        PrintWriter writer = resp.getWriter();
        int v = 0;
        String v_ = req.getParameter("value");
        if (!v_.equals("")) v = Integer.parseInt(v_);
        String op = req.getParameter("operator");


        if (op.equals("=")) {
            //int x = (Integer) application.getAttribute("value");
            int x = (Integer)session.getAttribute("value");
            int y = v;
            //String operator = (String) application.getAttribute("operator");
            String operator = (String) session.getAttribute("operator");

            int result = 0;

            if (operator.equals("+"))
                result = x + y;
            else
                result = x - y;
            resp.getWriter().printf("result is %d\n",result);
        } else {
            //application.setAttribute("value", v);
            //application.setAttribute("operator", op);
//            session.setAttribute("value", v);
//            session.setAttribute("operator", op);

            Cookie valueCookie = new Cookie("value",String.valueOf(v));
            Cookie opCookie = new Cookie("op",op);
            resp.addCookie(valueCookie);
            resp.addCookie(opCookie);
        }
    }
}