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
 * Created by bholar on 7/23/2017.
 */
@WebServlet(name = "ChangePriceServlet1")
public class ChangePriceServlet1 extends HttpServlet {
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
        if (session == null && !request.isRequestedSessionIdValid()) {

            out.print("Session not created  <br>  Please login to continue  " + "<br><br>");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");

            rd.include(request, response);

        } else {

            String price_change = request.getParameter("price_change");
            double price_change1 = Double.parseDouble(price_change);
            String id_change = request.getParameter("id_change");
            out.println("Welcome  " + session.getAttribute("uname") + "  <br> <br>");
            try {
                // String id_change2 = (String) request.getAttribute("id_change2");
                out.print("The new price is  :  " + price_change + " or " + price_change1 + " of ID  = " + id_change);
                int id_change3 = Integer.parseInt(id_change);
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/vehicle_db", "root", "CDKcdk11");
                PreparedStatement stm = cn.prepareStatement("UPDATE spareparts SET price = ? WHERE id=?");
                stm.setDouble(1, price_change1);
                stm.setInt(2, id_change3);
                int i = stm.executeUpdate();
                if (i > 0) {
                    out.println("The price was changed successfully");
                } else {
                    out.println("There was an error in changing the price");
                }


                out.print("<br><br>");
                //out.println("Do you want to delete more records  :      ");
                out.println(" <button><a href=\"./Login_Servlet\">Click to go to Main Menu</a></button><br><br>");
                out.println("<form action=\"/logout\" method=\"post\">\n" +
                        "    <input type=\"submit\" value = \"Logout\">\n" +
                        "</form>");
                cn.close();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

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
        if (session == null && !request.isRequestedSessionIdValid()) {

            out.print("Session not created  <br>  Please login to continue  " + "<br><br>");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");

            rd.include(request, response);

        } else {

            String price_change = request.getParameter("price_change");
            double price_change1 = Double.parseDouble(price_change);
            String id_change = request.getParameter("id_change");
            out.println("Welcome  " + session.getAttribute("uname") + "  <br> <br>");
            try {
                // String id_change2 = (String) request.getAttribute("id_change2");
                out.print("The new price is  :  " + price_change + " or " + price_change1 + " of ID  = " + id_change);
                int id_change3 = Integer.parseInt(id_change);
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/vehicle_db", "root", "CDKcdk11");
                PreparedStatement stm = cn.prepareStatement("UPDATE spareparts SET price = ? WHERE id=?");
                stm.setDouble(1, price_change1);
                stm.setInt(2, id_change3);
                int i = stm.executeUpdate();
                if (i > 0) {
                    out.println("The price was changed successfully");
                } else {
                    out.println("There was an error in changing the price");
                }


                out.print("<br><br>");
                //out.println("Do you want to delete more records  :      ");
                out.println(" <button><a href=\"./Login_Servlet\">Click to go to Main Menu</a></button><br><br>");
                out.println("<form action=\"/logout\" method=\"post\">\n" +
                        "    <input type=\"submit\" value = \"Logout\">\n" +
                        "</form>");
                cn.close();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
