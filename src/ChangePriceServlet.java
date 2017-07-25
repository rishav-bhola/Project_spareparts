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
@WebServlet(name = "ChangePriceServlet")
public class ChangePriceServlet extends HttpServlet {
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


            String id_change = request.getParameter("id_change");
            request.setAttribute("id_change2", id_change);
            int id_change1 = Integer.parseInt(id_change);
            out.println("Welcome  " + session.getAttribute("uname") + "  <br> <br>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/vehicle_db", "root", "CDKcdk11");
                PreparedStatement stm = cn.prepareStatement("select * from spareparts where id=?");
                stm.setInt(1, id_change1);
                ResultSet rs = stm.executeQuery();
                //int i = stm.executeUpdate();
                if (!rs.next()) {
                    out.println("The record does not exist<br><br>");
                } else {
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

                    do {
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


                    } while (rs.next());
                    out.print("</table><br><br>");
                    out.println("<form action=\"/ChangePriceServlet1\" method=\"post\">\n" +
                            "    ID  : <input type=\"hidden\" name=\"id_change\" value = '" + request.getParameter("id_change") + "'><br>\n" +
                            "    Enter the new price  : <input type=\"number\" name=\"price_change\">\n" +
                            "    <input type=\"submit\" value=\"Click to Change the price\">\n" +
                            "</form>");

                }


                out.println(" <a href=\"Login_Servlet\">Click to go to Main Menu</a>");
                out.println("<br><br><br>");

                out.println("<form action=\"/logout\" method=\"post\">\n" +
                        "    <input type=\"submit\" value = \"Logout\">\n" +
                        "</form>");


                rs.close();
                stm.close();
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


            String id_change = request.getParameter("id_change");
            request.setAttribute("id_change2", id_change);
            int id_change1 = Integer.parseInt(id_change);
            out.println("Welcome  " + session.getAttribute("uname") + "  <br> <br>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/vehicle_db", "root", "CDKcdk11");
                PreparedStatement stm = cn.prepareStatement("select * from spareparts where id=?");
                stm.setInt(1, id_change1);
                ResultSet rs = stm.executeQuery();
                //int i = stm.executeUpdate();
                if (!rs.next()) {
                    out.println("The record does not exist<br><br>");
                } else {
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

                    do {
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


                    } while (rs.next());
                    out.print("</table><br><br>");
                    out.println("<form action=\"/ChangePriceServlet1\" method=\"post\">\n" +
                            "    ID  : <input type=\"hidden\" name=\"id_change\" value = '" + request.getParameter("id_change") + "'><br>\n" +
                            "    Enter the new price  : <input type=\"number\" name=\"price_change\">\n" +
                            "    <input type=\"submit\" value=\"Click to Change the price\">\n" +
                            "</form>");

                }


                out.println(" <a href=\"Login_Servlet\">Click to go to Main Menu</a>");
                out.println("<br><br><br>");

                out.println("<form action=\"/logout\" method=\"post\">\n" +
                        "    <input type=\"submit\" value = \"Logout\">\n" +
                        "</form>");


                rs.close();
                stm.close();
                cn.close();


            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
