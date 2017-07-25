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
@WebServlet(name = "spareparts_Servlet")
public class spareparts_Servlet extends HttpServlet {
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
        // out.println("Welcome  "+session.getAttribute("uname") +"  <br> <br>");
        if (session == null && !request.isRequestedSessionIdValid()) {

            out.print("Session not created  <br>  Please login to continue  " + "<br><br>");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");

            rd.include(request, response);

        } else {

            String n1 = request.getParameter("model");
            String n2 = request.getParameter("name");
            String n3 = request.getParameter("brand");
            String n4 = request.getParameter("price");
            double price = Double.parseDouble(n4);
            String n5 = request.getParameter("units");
            int units = Integer.parseInt(n5);
            String n6 = request.getParameter("veh_id");
            int veh_id = Integer.parseInt(n6);
            String n7 = request.getParameter("tax");
            double tax = Double.parseDouble(n7);
            out.print("WELCOME TO THE SPAREPARTS MODULE<br><br>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/vehicle_db", "root", "CDKcdk11");
                //Statement st = cn.createStatement();
                PreparedStatement st = cn.prepareStatement("insert into spareparts(model_no, name, brand, price, units,vehicle_id, tax) values(?,?,?,?,?,?,?)");
                st.setString(1, n1);
                st.setString(2, n2);
                st.setString(3, n3);
                st.setDouble(4, price);
                st.setInt(5, units);
                st.setInt(6, veh_id);
                st.setDouble(7, tax);
                int i = st.executeUpdate();
                if (i > 0) {
                    out.print("The details are updated successfully<br><br>");
                    out.print("The added details are  :  <br><br>  MODEL NUMBER  :  " + n1 + "<br><br> NAME  :  " + n2 + "<br><br> BRAND : " + n3 + "<br><br> PRICE  :  " + n4 + "<br><br> UNITS  :  " + n5 + "<br><br> VEHICLE ID " + n6 + "<br><br> TAX " + n7);

                } else {
                    out.println("Error in inserting the details");
                }
                //  System.out.println("insert into spareparts(model_no, name, brand, price, units,vehicle_id, tax) values(?,?,?,?,?,?,?)");
                //out.println("The details are added successfully");

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
        // out.println("Welcome  "+session.getAttribute("uname") +"  <br> <br>");
        if (session == null && !request.isRequestedSessionIdValid()) {

            out.print("Session not created  <br>  Please login to continue  " + "<br><br>");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");

            rd.include(request, response);

        } else {

            String n1 = request.getParameter("model");
            String n2 = request.getParameter("name");
            String n3 = request.getParameter("brand");
            String n4 = request.getParameter("price");
            double price = Double.parseDouble(n4);
            String n5 = request.getParameter("units");
            int units = Integer.parseInt(n5);
            String n6 = request.getParameter("veh_id");
            int veh_id = Integer.parseInt(n6);
            String n7 = request.getParameter("tax");
            double tax = Double.parseDouble(n7);
            out.print("WELCOME TO THE SPAREPARTS MODULE<br><br>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/vehicle_db", "root", "CDKcdk11");
                //Statement st = cn.createStatement();
                PreparedStatement st = cn.prepareStatement("insert into spareparts(model_no, name, brand, price, units,vehicle_id, tax) values(?,?,?,?,?,?,?)");
                st.setString(1, n1);
                st.setString(2, n2);
                st.setString(3, n3);
                st.setDouble(4, price);
                st.setInt(5, units);
                st.setInt(6, veh_id);
                st.setDouble(7, tax);
                int i = st.executeUpdate();
                if (i > 0) {
                    out.print("The details are updated successfully<br><br>");
                    out.print("The added details are  :  <br><br>  MODEL NUMBER  :  " + n1 + "<br><br> NAME  :  " + n2 + "<br><br> BRAND : " + n3 + "<br><br> PRICE  :  " + n4 + "<br><br> UNITS  :  " + n5 + "<br><br> VEHICLE ID " + n6 + "<br><br> TAX " + n7);

                } else {
                    out.println("Error in inserting the details");
                }
                //  System.out.println("insert into spareparts(model_no, name, brand, price, units,vehicle_id, tax) values(?,?,?,?,?,?,?)");
                //out.println("The details are added successfully");

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
