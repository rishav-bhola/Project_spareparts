import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by bholar on 7/17/2017.
 */
@WebServlet(name = "logout")
public class logout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession ssn = request.getSession(false);
        PrintWriter pw =   response.getWriter();
        pw.println("\n" +
                "<html>\n" +
                "<head>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" +
                "</head>\n" +
                "</html>");
        ssn.removeAttribute("uname");
        ssn.invalidate();
        HttpSession ssn1 = request.getSession(false);
        pw.print("Congratulations!! You successfully logged out");
        //pw.print(ssn.getAttribute("uname"));
        pw.print(ssn1);

        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
