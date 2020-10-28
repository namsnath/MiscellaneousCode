import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class Delete extends HttpServlet {
    Connection conn;
    
    public void init() throws ServletException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Driver loaded");

            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/MyFamily_17BCI0113",
                "namsnath",
                "namsnath"
            );
        } catch(Exception e) {
            System.err.println("Exception");
            System.err.println(e);
            System.err.println(e.getMessage());
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Deleting " + id + "</h2>");

        try {
            String query = "DELETE FROM Family WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.execute();
            out.println("<h3>Successful</h3>");
            out.println("<br><a href=\"/MyFamilyDB/details\">See Details</a>");
        } catch(Exception e) {
            out.println("<h3>Error Occurred</h3>");
            out.println(e);
            out.println("<br><a href=\"/MyFamilyDB/details\">See Details</a>");
        }
    }

    public void destroy() {
        try {
            conn.close();
        } catch (Exception e) {} 
    }
}