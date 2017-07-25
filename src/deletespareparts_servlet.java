import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by bholar on 7/21/2017.
 */
@WebServlet(name = "deletespareparts_servlet")
public class deletespareparts_servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        out.println("\n" +
                "<html>\n" +
                "<head>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" +
                "</head>\n" +
                "</html>");
        //out.println("Welcome  "+session.getAttribute("uname") +"  <br> <br>");
        if (session == null && !request.isRequestedSessionIdValid()) {

            out.print("Session not created  <br>  Please login to continue  " + "<br><br>");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");

            rd.include(request, response);

        } else {

            String n = request.getParameter("id_del");
            int id = Integer.parseInt(n);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/vehicle_db", "root", "CDKcdk11");
                //Statement st = con.createStatement();
                PreparedStatement stm = con.prepareStatement("delete from spareparts where id=?");
                stm.setInt(1, id);
                int i = stm.executeUpdate();
                if (i > 0) {
                    out.println("The record is deleted successfully");
                } else {
                    out.println("The record could not be deleted");

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            out.print("<br><br><br>");
            //out.println("Do you want to delete more records  :      ");
            out.println(" <button><a href=\"./Login_Servlet\">Click to go to Main Menu</a></button><br><br><br>");


            out.println("<form action=\"/logout\" method=\"post\">\n" +
                    "    <input type=\"submit\" value = \"Logout\">\n" +
                    "</form>");

        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        out.println("\n" +
                "<html>\n" +
                "<head>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" +
                "</head>\n" +
                "</html>");
        //out.println("Welcome  "+session.getAttribute("uname") +"  <br> <br>");
        if (session == null && !request.isRequestedSessionIdValid()) {

            out.print("Session not created  <br>  Please login to continue  " + "<br><br>");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");

            rd.include(request, response);

        } else {

            String n = request.getParameter("id_del");
            int id = Integer.parseInt(n);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/vehicle_db", "root", "CDKcdk11");
                //Statement st = con.createStatement();
                PreparedStatement stm = con.prepareStatement("delete from spareparts where id=?");
                stm.setInt(1, id);
                int i = stm.executeUpdate();
                if (i > 0) {
                    out.println("The record is deleted successfully");
                } else {
                    out.println("The record could not be deleted");

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            out.print("<br><br><br>");

            //out.println("Do you want to delete more records  :      ");
            out.println(" <button><a href=\"./Login_Servlet\">Click to go to Main Menu</a></button><br><br><br>");


            out.println("<form action=\"/logout\" method=\"post\">\n" +
                    "    <input type=\"submit\" value = \"Logout\">\n" +
                    "</form>");

        }

    }
}
