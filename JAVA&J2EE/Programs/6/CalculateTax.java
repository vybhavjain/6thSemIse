import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculateTax")
public class CalculateTax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CalculateTax() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String salary = request.getParameter("salary");
		String tax = request.getParameter("tax");
		double tax1less = Double.parseDouble(tax);
		double salary1 = Double.parseDouble(salary);
		double finaltax = (salary1-tax1less)*0.2;
		response.getWriter().append("your name is" + name + "\n")
		.append("your gender is" + gender + "\n")
		.append("your salary is" + salary+ "\n" )
		.append("your finaltax is" + finaltax+ "\n");

		String newFile = new File("data.txt").getAbsolutePath();
		System.out.println("your new file is "+newFile);
		PrintWriter pw = new PrintWriter("data.txt"); 
		
		pw.println("your name is " + name);
		pw.println("your gender is " + gender);
		pw.println("your salary is " + salary);
		pw.println("your finaltax is " + finaltax);
		pw.close();
	}
}
