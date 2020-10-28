import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class MyFamilyDB_17BCI0113 extends HttpServlet {
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

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            java.util.Date d = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
            Date sqlDate = new Date(d.getTime());

            submitData(name, relationship, color, place, phone, sqlDate);
            
            out.println("<html><body>");
            out.println("<p>Namit Nathwani - 17BCI0113</p>");
            out.println("<h3>Data Added Successfully</h3>");
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
        ResultSet rs;
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            rs = getData();

            out.println("<html><body>");
            out.println("<p>Namit Nathwani - 17BCI0113</p>");
            out.println("<h3>Details</h3>");
            out.println("<table><tr>");
            out.println("<th>id</th><th>Name</th><th>Relationship</th><th>Favorite Color</th>");
            out.println("<th>Favorite Place</th><th>Phone</th><th>Date</th>");
            out.println("<th colspan=\"2\">Actions</th></tr>");

            while(rs.next()) {
                int id = rs.getInt("id");
                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + rs.getString("Name") + "</td>");
                out.println("<td>" + rs.getString("Relationship") + "</td>");
                out.println("<td>" + rs.getString("FavoriteColor") + "</td>");
                out.println("<td>" + rs.getString("FavoritePlace") + "</td>");
                out.println("<td>" + rs.getString("PhNo") + "</td>");
                out.println("<td>" + rs.getDate("DoB") + "</td>");
                out.println("<td><a href=\"/MyFamilyDB/update?id=" + id + "\">Update</a></td>");
                out.println("<td><a href=\"/MyFamilyDB/delete?id=" + id + "\">Delete</a></td>");
                out.println("</tr>");
            }

            out.println("</body></html>");
        } catch(Exception e) {
            out.println("<h1>Some Error Occurred</h1>");
            out.println(e);
        }
    }

    public void submitData(String name, String relationship, String color, 
        String place, String phone, Date date) throws Exception {
        String query = "INSERT INTO Family (Name, Relationship, FavoriteColor, FavoritePlace, PhNo, DoB) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, name);
        stmt.setString(2, relationship);
        stmt.setString(3, color);
        stmt.setString(4, place);
        stmt.setString(5, phone);
        stmt.setDate(6, date);

        stmt.execute();
    }

    public ResultSet getData() throws Exception {
        Statement st = conn.createStatement();
        String queryString = "SELECT * FROM Family";
        ResultSet rs = st.executeQuery(queryString);

        return rs;
    }
    
    public void destroy() {
        try {
            conn.close();
        } catch (Exception e) {}
    }
}