package ch08.context.ex03;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.StringTokenizer;

@WebServlet("/cfile")
public class ContextFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ServletContext context = getServletContext();
        InputStream is = context.getResourceAsStream("/WEB-INF/bin/init.txt");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(is));

        String menu = null;
        String menu_member = null;
        String menu_order = null;
        String menu_goods = null;
        while((menu=buffer.readLine()) != null){
            StringTokenizer tokens = new StringTokenizer(menu, ",");
            menu_member = tokens.nextToken();;
            menu_order = tokens.nextToken();
            menu_goods = tokens.nextToken();
        }

        out.print(menu_member+"<br>");
        out.print(menu_order+"<br>");
        out.print(menu_goods+"<br>");

    }
}
