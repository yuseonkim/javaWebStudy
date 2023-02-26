package ch09.cookie.ex01;

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
@WebServlet("/ch09/set")
public class SetCookieValue extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Date d = new Date();
        Cookie c = new Cookie("cookieTest", URLEncoder.encode("JSP프로그래밍 입니다.","utf-8"));
        c.setMaxAge((24*60*60));
        resp.addCookie(c);
        out.print("현재시간 : "+d);
        out.print("현재시간을 cookie로 저장합니다");
    }
}
