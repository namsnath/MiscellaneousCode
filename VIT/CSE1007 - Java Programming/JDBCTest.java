import java.sql.*;

public class JDBCTest {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    // Load the JDBC driver
    Class.forName("org.mariadb.jdbc.Driver");
    System.out.println("Driver loaded");

    // Try to connect
    Connection connection = DriverManager.getConnection
      ("jdbc:mysql://localhost/test", "namsnath", "namsnath");

    System.out.println("It works!");

    connection.close();
  }
} 
