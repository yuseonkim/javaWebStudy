package ch09.cookie.ex01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
@WebServlet("/ch09/get")
public class GetCookieValue extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Cookie[] allValues = req.getCookies();
        for (Cookie c : allValues) {
            if(c.getName().equals("cookieTest")){
                out.println("<h2>Cookie 값 가져오기 : "+ URLDecoder.decode(c.getValue(),"utf-8"));
            }
        }
    }
}
