import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Insert")
public class Insert extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public Insert() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new RunQuery().update("insert into info values(" + request.getParameter("id") + ",'" + request.getParameter("name") + "'," + request.getParameter("age") + ",'" + request.getParameter("doa") + "','"+ request.getParameter("coa") + "','" + request.getParameter("diag") + "','" + request.getParameter("treat") + "');");
        response.getWriter().println("Successfully Inserted!");
    }
}



