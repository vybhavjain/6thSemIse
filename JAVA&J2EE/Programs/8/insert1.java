
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/ins" })
public class insert1 extends HttpServlet {

    static Connection getConn() throws Exception {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/onlinedirectory";
        String username = "root";
        String password = "msrit";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
    
    Connection conn1 = null;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        boolean flag = false;
        Connection conn = null;
        Statement stmt = null;
        java.sql.ResultSet rs = null;

        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/onlinedirectory";
            String username = "root";
            String password = "msrit";
            Class.forName(driver);
            conn1 = DriverManager.getConnection(url, username,
                    password);
            if (conn1 != null)
                System.out.println("Successful");
            stmt = conn1.createStatement();
            out.print("Working");
            String name = request.getParameter("nam");
            long contact = Long.parseLong(request.getParameter("cnt"));
            String address = request.getParameter("address");
            String company = request.getParameter("company");
            int pin = Integer.parseInt(request.getParameter("pin"));

            out.println("name" + name);
            out.println("contact:" + contact);
            out.println("address:" + address);
            out.println("company:" + company);
            out.println("pin:" + pin);

            stmt.executeUpdate("insert into tele_dir values('" + name + "'," + contact + ",'" + address + "','" + company + "'," + pin + ");");
            out.println("updated the records");

        } catch (ClassNotFoundException e) {
            System.out.println("Error: failed to load MySQL driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: failed to create a connection object.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error: unknown");
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn1.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
