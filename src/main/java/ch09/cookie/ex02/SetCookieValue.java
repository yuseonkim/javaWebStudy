package ch09.cookie.ex02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

@WebServlet("/ch09/set2")
public class SetCookieValue extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Date d = new Date();
        Cookie c= new Cookie("cookieTest", URLEncoder.encode("JSP어쩌고","utf-8"));
        c.setMaxAge(-1);
        out.println("쿠키로 저장");
    }
}
