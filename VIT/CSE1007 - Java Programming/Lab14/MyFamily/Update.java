import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class Update extends HttpServlet {
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

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String name = request.getParameter("name");
        String relationship = request.getParameter("relationship");
        String dob = request.getParameter("dob");
        String place = request.getParameter("place");
        String color = request.getParameter("color");
        String phone = request.getParameter("phone");
        int id = Integer.parseInt(request.getParameter("id"));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            java.util.Date d = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
            Date sqlDate = new Date(d.getTime());

            updateData(id, name, relationship, color, place, phone, sqlDate);
            
            out.println("<html><body>");
            out.println("<p>Namit Nathwani - 17BCI0113</p>");
            out.println("<h3>Data Updated Successfully</h3>");
            out.println("<b>Name: </b>" + name);
            out.println("<br><b>Relationship: </b>" + relationship);
            out.println("<br><b>Date of Birth: </b>" + dob);
            out.println("<br><b>Favorite Place: </b>" + place);
            out.println("<br><b>Favorite Color: </b>" + color);
            out.println("<br><b>Phone Number: </b>" + phone);
            out.println("<br><a href=\"/MyFamilyDB/details\">See Details</a>");
            out.println("</body></html>");
        } catch (Exception e) {
            out.println("<h1>Some Error Occurred</h1>");
            out.println(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            String query = "SELECT * FROM Family WHERE id=?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            rs.next();

            out.println("<html><body>");
            out.println("<h2>Update Details: " + id + "</h2>");
            out.println("<form method=\"POST\" action=\"/MyFamilyDB/update\">");
            out.println("<table>");

            out.println("<tr><td></td><td><input type=\"hidden\" name=\"id\" value=\"" + id + "\"</td></tr>");
            out.println("<tr><td>Name</td><td><input name=\"name\" value=\"" + rs.getString("Name") + "\"</td></tr>");
            out.println("<tr><td>Relationship</td><td><input name=\"relationship\" value=\"" + rs.getString("Relationship") + "\"</td></tr>");
            out.println("<tr><td>Color</td><td><input name=\"color\" value=\"" + rs.getString("FavoriteColor") + "\"</td></tr>");
            out.println("<tr><td>Place</td><td><input name=\"place\" value=\"" + rs.getString("FavoritePlace") + "\"</td></tr>");
            out.println("<tr><td>Phone</td><td><input name=\"phone\" value=\"" + rs.getString("PhNo") + "\"</td></tr>");
            out.println("<tr><td>DoB</td><td><input name=\"dob\" type=\"date\" value=\"" + rs.getDate("DoB") + "\"</td></tr>");
            out.println("<tr><td colspan=\"2\"><input type=\"submit\"></td></tr>");
            out.println("</table>");

            out.println("<br><a href=\"/MyFamilyDB/details\">See Details</a>");
            out.println("</html></body>");
        } catch(Exception e) {
            out.println("<h3>Error Occurred</h3>");
            out.println(e);
            out.println("<br><a href=\"/MyFamilyDB/details\">See Details</a>");
        }

        out.println("Update page for: " + id);
    }

    public void updateData(int id, String name, String relationship, String color, 
        String place, String phone, Date date) throws Exception {
        String query = "UPDATE Family SET Name=?, Relationship=?, FavoriteColor=?, FavoritePlace=?, PhNo=?, DoB=? WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, name);
        stmt.setString(2, relationship);
        stmt.setString(3, color);
        stmt.setString(4, place);
        stmt.setString(5, phone);
        stmt.setDate(6, date);
        stmt.setInt(7, id);

        stmt.execute();
    }

    public void destroy() {
        try {
            conn.close();
        } catch (Exception e) {} 
    }
}