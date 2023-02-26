package ch08.binding.ex01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/binding/first1")
public class firstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("address","광주광역시 북구");
        resp.sendRedirect("second1");
        //null이 뜨는것은 정상
        //클라이언트가 요청하는
    }
}
