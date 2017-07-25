import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by bholar on 7/22/2017.
 */
@WebServlet(name = "Login_Servlet")
public class Login_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session=request.getSession();

        if(session==null){
            String str = (String)session.getAttribute("uname");
            System.out.println(str);
            System.out.println(session);
            System.out.println("INSIDE IF");
            String n=request.getParameter("username");
            HttpSession session1 = request.getSession();
            session1.setAttribute("uname",n);
           out.print("1Welcome "+n +"<br><br><br>");
            System.out.println(session1);
        }
        else{
            System.out.println(session);
            out.println("2Welcome  "+session.getAttribute("uname") +"  <br> <br>");

        }


        out.println("\n" +
                "<html>\n" +
                "<head>\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n"+
                "    <title></title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<img src=\"CDKGlobal1.png\" alt=\"CDK Logo\" >\n"+
                "<form action=\"/spareparts_Servlet\" method=\"post\">\n" +
                "  <fieldset>\n" +
                        "    <legend>Details to be added:</legend>\n"+

                "    <div>Model Number  :</div>  <input type=\"text\" name=\"model\" required><br><br>\n" +
                "    <div>Name  :</div>  <input type=\"text\" name=\"name\" required><br><br>\n" +
                "    <div>Brand  :</div>  <input type=\"text\" name=\"brand\" required><br><br>\n" +
                "    <div>Price  :</div>  <input type=\"number\" name=\"price\" required><br><br>\n" +
                "    <div>Number of units  :</div>  <input type=\"number\" name=\"units\" required><br><br>\n" +
                "    <div>Vehicle ID  :</div>  <input type=\"number\" name=\"veh_id\" required><br><br>\n" +
                "    <div>TAX  :</div>  <input type=\"number\" name=\"tax\" required><br><br>\n" +
                "    <input type=\"submit\" value=\"Click to add details\"><br><br>\n" +
                "\n" +
                " </fieldset>\n"+
                "</form>\n" +
                "<br><br><br>\n" +
                "<form action=\"/deletespareparts_servlet\" method=\"post\">\n" +
                "  <fieldset>\n" +
                "    <legend>Delete the Sparepart:</legend>\n"+
                "    <div>Enter the ID you want to be deleted  :</div>  <input type=\"text\" name=\"id_del\"><br>\n" +
                "    <input type=\"submit\" value=\"Click to delete the record\">\n" +
                "\n" +
                " </fieldset>\n"+
                "</form>\n" +
                "\n" +
                "\n" +
                "</form>\n" +
                "<br><br><br>\n" +
                "<form action=\"/ChangePriceServlet\" method=\"post\">\n" +
                "  <fieldset>\n" +
                "    <legend>Change the price of Sparepart the Sparepart:</legend>\n"+
                "    <div>Enter the ID for which you want to change the price  :</div>  <input type=\"text\" name=\"id_change\"><br>\n" +
                "    <input type=\"submit\" value=\"Click to change the price\">\n" +
                "\n" +
                " </fieldset>\n"+
                "</form>\n" +
                "\n" +
                "</form>\n" +
                "<br><br><br>\n" +
                "<form action=\"/List_Spare_Servlet\" method=\"post\">\n" +
                "  <fieldset>\n" +
                "    <legend>View the Spareparts list:</legend>\n"+
                "    <input type=\"submit\" value=\"Click to show Spare Parts List\">\n" +
                "\n" +
                " </fieldset>\n"+
                "</form>\n" +
                "</body>\n" +
                "</html>");
out.println("<br><br>");
        out.println("<form action=\"/logout\" method=\"post\">\n" +
                "  <fieldset>\n" +
                "    <legend>Logout:</legend>\n"+
                "    <input type=\"submit\" value = \"Logout\">\n" +
                " </fieldset>\n"+
                "</form>");

    }
}
