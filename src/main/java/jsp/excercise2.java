package jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/jsp.excercise2")
public class excercise2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        String button = req.getParameter("button");


        String[] num = req.getParameterValues("num");
        int result = 0;
        for(int i=0;i<num.length;i++){
            result += Integer.parseInt(num[i]);
        }

        writer.println(result);

    }
}
