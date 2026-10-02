import java.io.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;

public class FirstServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>My Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Hello form Servlet!</h1>");
        out.println("</body></html>");
    }
}