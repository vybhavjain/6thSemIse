import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.io.*;

@WebServlet("/telephone")
public class telephone extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Connection conn;
    public telephone() {
        super();
         try{
                Class.forName("com.mysql.jdbc.Driver"); 
                this.conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineDirectory", "root", "");
            }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    String find(String query){
         try{
          if (this.conn != null){
            String ans=""; 
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
                ans+=rs.getString("phno")+" "+rs.getString("name")+" "+rs.getString("addr")+" "+rs.getString("com")+" "+rs.getString("pin")+"\n";
                return ans;
          }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String name = request.getParameter("name");
                String phno = request.getParameter("phno");
                if(name!=null)
                response.getWriter().println(find("select * from Telephone_Directory where name = '" + name + "';"));
                else
                response.getWriter().println(find("select * from Telephone_Directory where phno = '" + phno + "';"));
    }
}
