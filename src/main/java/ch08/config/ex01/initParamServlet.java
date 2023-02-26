package ch08.config.ex01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="initParamServlet",
            urlPatterns = {"/sInit","/sInit2"},
            initParams = {@WebInitParam(name="email",value="admin@jweb.com"),
                            @WebInitParam(name="tel",value="010-1111-2222")})
public class initParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String email = getInitParameter("email");
        String tel = getInitParameter("tel");
        out.print("email : "+email);
        out.print("tel : "+tel);
    }
}
