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
 * Created by bholar on 7/22/2017.
 */
@WebServlet(name = "List_Spare_Servlet")
public class List_Spare_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        if (session == null && !request.isRequestedSessionIdValid()) {

            out.print("Session not created  <br>  Please login to continue  " + "<br><br>");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");

            rd.include(request, response);

        } else {

            //out.println("Welcome  "+session.getAttribute("uname") +"  <br> <br>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/vehicle_db", "root", "CDKcdk11");
                Statement st = cn.createStatement();

                ResultSet rs = st.executeQuery("select * from spareparts");
                out.println("\n" +
                        "<html>\n" +
                        "<head>\n" +
                        "    <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" +
                        "</head>\n" +
                        "</html>");

                out.print("<style>\n" +
                        "table, th, td {\n" +
                        "    border: 1px solid black;\n" +
                        "}\n" +
                        "</style>");

                out.print("\n" +
                        "  <table>\n" +
                        "    <tr>\n" +
                        "      <th>ID</th>\n" +
                        "      <th>MODEL NUMBER</th>\n" +
                        "      <th>NAME</th>\n" +
                        "      <th>BRAND</th>\n" +
                        "      <th>PRICE</th>\n" +
                        "      <th>UNITS</th>\n" +
                        "      <th>VEHICLE ID</th>\n" +
                        "      <th>TAX</th>\n" + "<tr>");
                int id;
                String model_no;
                String name;
                String brand;
                double price;
                int units;
                int veh_id;
                double tax;

                while (rs.next()) {
                    id = rs.getInt("id");
                    model_no = rs.getString("model_no");
                    name = rs.getString("name");
                    brand = rs.getString("brand");
                    price = rs.getDouble("price");
                    units = rs.getInt("units");
                    veh_id = rs.getInt("vehicle_id");
                    tax = rs.getDouble("tax");

                    out.println("<tr>\n" +
                            "      <td>" + id + "</td>\n" +
                            "      <td>" + model_no + "</td>\n" +
                            "      <td>" + name + "</td>\n" +
                            "      <td>" + brand + "</td>\n" +
                            "      <td>" + price + "</td>\n" +
                            "      <td>" + units + "</td>\n" +
                            "      <td>" + veh_id + "</td>\n" +
                            "      <td>" + tax + "</td>\n" +
                            "    </tr>"
                    );

           /* pw.println("<br>Id:"+jid);
            pw.println("<br>Name:"+jnam);*/


                }
                //out.println("Do you want to delete more records  :      ");

                out.print("</table>");
                out.println(" <button><a href=\"Login_Servlet\">Click to go to Main Menu</a></button>");
                out.println("<br><br><br>");

                out.println("<form action=\"/logout\" method=\"post\">\n" +
                        "    <input type=\"submit\" value = \"Logout\">\n" +
                        "</form>");


                rs.close();
                st.close();
                cn.close();


            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //Statement st = cn.createStatement();

        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        if (session == null && !request.isRequestedSessionIdValid()) {

            out.print("Session not created  <br>  Please login to continue  " + "<br><br>");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");

            rd.include(request, response);

        } else {

            //out.println("Welcome  "+session.getAttribute("uname") +"  <br> <br>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/vehicle_db", "root", "CDKcdk11");
                Statement st = cn.createStatement();

                ResultSet rs = st.executeQuery("select * from spareparts");
                out.println("\n" +
                        "<html>\n" +
                        "<head>\n" +
                        "    <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" +
                        "</head>\n" +
                        "</html>");
                out.print("<style>\n" +
                        "table, th, td {\n" +
                        "    border: 1px solid black;\n" +
                        "}\n" +
                        "</style>");

                out.print("\n" +
                        "  <table>\n" +
                        "    <tr>\n" +
                        "      <th>ID</th>\n" +
                        "      <th>MODEL NUMBER</th>\n" +
                        "      <th>NAME</th>\n" +
                        "      <th>BRAND</th>\n" +
                        "      <th>PRICE</th>\n" +
                        "      <th>UNITS</th>\n" +
                        "      <th>VEHICLE ID</th>\n" +
                        "      <th>TAX</th>\n" + "<tr>");
                int id;
                String model_no;
                String name;
                String brand;
                double price;
                int units;
                int veh_id;
                double tax;

                while (rs.next()) {
                    id = rs.getInt("id");
                    model_no = rs.getString("model_no");
                    name = rs.getString("name");
                    brand = rs.getString("brand");
                    price = rs.getDouble("price");
                    units = rs.getInt("units");
                    veh_id = rs.getInt("vehicle_id");
                    tax = rs.getDouble("tax");

                    out.println("<tr>\n" +
                            "      <td>" + id + "</td>\n" +
                            "      <td>" + model_no + "</td>\n" +
                            "      <td>" + name + "</td>\n" +
                            "      <td>" + brand + "</td>\n" +
                            "      <td>" + price + "</td>\n" +
                            "      <td>" + units + "</td>\n" +
                            "      <td>" + veh_id + "</td>\n" +
                            "      <td>" + tax + "</td>\n" +
                            "    </tr>"
                    );

           /* pw.println("<br>Id:"+jid);
            pw.println("<br>Name:"+jnam);*/


                }
                //out.println("Do you want to delete more records  :      ");

                out.print("</table>");
                out.println(" <button><a href=\"Login_Servlet\">Click to go to Main Menu</a></button>");
                out.println("<br><br><br>");

                out.println("<form action=\"/logout\" method=\"post\">\n" +
                        "    <input type=\"submit\" value = \"Logout\">\n" +
                        "</form>");


                rs.close();
                st.close();
                cn.close();


            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //Statement st = cn.createStatement();

        }
    }
}
