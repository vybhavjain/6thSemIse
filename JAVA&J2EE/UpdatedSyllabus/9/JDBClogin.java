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
@WebServlet(urlPatterns={"/javaConnection"})
public class JDBClogin extends HttpServlet {
    
    static Connection getConnection() throws Exception {
        
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/onlinedirectory";
        String username = "root";
        String password = "msrit";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        //out.print("Working");
        
        boolean flag = false;
        Connection conn = null;
        Statement stmt = null;
        java.sql.ResultSet rs = null;               
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            out.print("Working");            
                long inp;
                
            try
            {
             inp =Long.parseLong(request.getParameter("phone"));
            out.println(""+inp);
             rs = stmt.executeQuery("SELECT * FROM tele_dir where contact="+inp);
            }
            catch(Exception e)
            {
                String name=request.getParameter("phone");
                // out.println(""+name);
                rs = stmt.executeQuery("SELECT * FROM tele_dir where name='"+name+"'");
            
            }
            if(rs.next()) {
                String name = rs.getString(1);
                long contact = rs.getLong(2);
                String address = rs.getString(3);
                String company = rs.getString(4);
                int pin =rs.getInt(5);
                out.println("name"+name);
                out.println("contact:"+contact);
                out.println("address:"+address);
                out.println("company:"+company);
                out.println("pin:"+pin);
                
                
                } 
            else
            {
                out.println("no contact found");
            } 
            
            
        } catch (ClassNotFoundException e) {
            System.out.println("Error: failed to load MySQL driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: failed to create a connection object.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error: unknown");
            e.printStackTrace();
        } 
    
    finally {
        try {
            stmt.close();
            conn.close();        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    }
    
}
