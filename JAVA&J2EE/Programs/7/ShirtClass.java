import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/ShirtClass")
public class ShirtClass extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Running");
		
		String acc[]=req.getParameterValues("acc");
		String accList="";
		for(String s:acc)
			accList=accList+s+"/";
		String tagline=req.getParameter("tag");
		String pocket=req.getParameter("opt");
		String color=req.getParameter("col");
		
		System.out.println(tagline+pocket);
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		int i =102;
		try{
			System.out.println(i+"printed");
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "msrit");
			Statement stmt=conn.createStatement();
			
			stmt.executeUpdate("insert into TShirts values ("+i+",'"+accList.substring(0,10)+"','"+tagline+"','"+pocket+"','"+color+"');");
			
			ResultSet rs=stmt.executeQuery("select * from TShirts;");
			
			out.println("<html><head><title>TShirts Data</title></head><body><h1>TShirt Orders</h1>");
			out.println("<table border=1px><tr><th>OrderNo</th><th>Accessories</th><th>Tagline</th><th>ChestPocket</th><th>Color</th></tr>");
			while(rs.next()) {
				out.println("<tr>"
						+ "<td>"+rs.getInt(1)+"</td>"
						+ "<td>"+rs.getString(2)+"</td>"
						+ "<td>"+rs.getString(3)+"</td>"
						+ "<td>"+rs.getString(4)+"</td>"
						+ "<td>"+rs.getString(5)+"</td>"		
						+ "</tr>");
			}
			out.println("</table></body></html>");
			out.close();
		}
		catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
