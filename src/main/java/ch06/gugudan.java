package ch06;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ch06/gugudan")
public class gugudan extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int dan = Integer.parseInt(req.getParameter("dan"));
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("<table border=1 width=800 align=center>");
        out.print("<tr align=center bgcolor='#FFFF66'>");
        out.print("<td colsapn=2>" + dan + " 단 출력 </td>");
        out.print("</tr>");
        for(int i=1;i<10;i++){
            out.print("<tr align=center>");
            out.print("<td width=400>");
            out.print(dan + " + " + i);
            out.print("</td>");
            out.print("<td width=400>");
            out.print(i * dan);
            out.print("</td>");
            out.print("</tr>");
        }
        out.print("</table>");
        out.print("</html></body>");
    }
}
