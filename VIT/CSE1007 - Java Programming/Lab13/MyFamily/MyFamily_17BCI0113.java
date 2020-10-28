import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyFamily_17BCI0113 extends HttpServlet {
    public void init() throws ServletException {
       
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String name = request.getParameter("name");
        String relationship = request.getParameter("relationship");
        String dob = request.getParameter("dob");
        String place = request.getParameter("place");
        String color = request.getParameter("color");
        String phone = request.getParameter("phone");

        // Set response content type
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<p>Namit Nathwani - 17BCI0113</p>");
        out.println("<b>Name: </b>" + name);
        out.println("<br><b>Relationship: </b>" + relationship);
        out.println("<br><b>Date of Birth: </b>" + dob);
        out.println("<br><b>Favorite Place: </b>" + place);
        out.println("<br><b>Favorite Color: </b>" + color);
        out.println("<br><b>Phone Number: </b>" + phone);
        out.println("</body></html>");
    }
    
    public void destroy() {
        // do nothing.
    }
}