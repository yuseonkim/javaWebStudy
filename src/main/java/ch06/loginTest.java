package ch06;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ch06/loginTest")
public class loginTest extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("init 메소드 호출");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();

        String id = req.getParameter("user_id");
        String pw = req.getParameter("user_pw");
        System.out.println("아이디:" + id );
        System.out.println("패스워드:" + pw);

        if(id != null && (id.length()!=0)){
            out.print("<html>");
            out.print("<body>");
            out.print(id+"님!! 로그인 하셨씁니다");
            out.print("</html>");
            out.print("</body>");
        }
    }
}
