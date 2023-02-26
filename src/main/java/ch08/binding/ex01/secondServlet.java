package ch08.binding.ex01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/binding/second1")
public class secondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String address = (String)req.getAttribute("address");
        out.println("<html><body>");
        out.println("주소"+address);
        out.println("<br>");
        out.println("redirect를 이용한 바인딩 실습입니다.");
        out.println("</body></html>");
    }
}
