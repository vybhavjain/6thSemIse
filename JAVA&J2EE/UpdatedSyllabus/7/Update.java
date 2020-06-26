import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Update")
public class Update extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public Update() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new RunQuery().update("update info set name = '" + request.getParameter("name") + "', age = " + request.getParameter("age") + ",doa = '" + request.getParameter("doa") + "',coa = '"+ request.getParameter("coa") + "',doc = '" + request.getParameter("doc") + "',diag = '" + request.getParameter("diag") + "',treat = '" + request.getParameter("treat") + "' where id = " + request.getParameter("id") + ";");
        response.getWriter().println("Successfully Updated!"); 
    }
}
