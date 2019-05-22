import javax.swing.*;

import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.GridLayout;
import java.sql.*;

public class DemoJDBC extends JFrame{
JLabel jlb1 = new JLabel("Enter emp id");
JLabel jlb2 = new JLabel("Enter Emp Name");
JTextField txtu = new JTextField(10);
JTextField txtp = new JTextField(10);
JButton insertbtn = new JButton("insert");
public DemoJDBC(String title)
{
	super(title);
	setLayout(new GridLayout(0,2));
	add(jlb1);add(txtu);
	add(jlb2);add(txtp);
	add(insertbtn);
	insertbtn.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent evt)
	{
		Statement stmt;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","mysql");
			stmt = conn.createStatement();
			
			String query = "insert into emp(emp_id,emp_name) values("+Integer.parseInt(txtu.getText())+", '"+txtp.getText()+"');";
			stmt.executeUpdate(query);
			ResultSet rs= stmt.executeQuery("select * from emp");
			while(rs.next())
			{
				System.out.println("Employee id is "+rs.getInt(1));
				System.out.println("Employee name is "+rs.getString(2)+"\n");
				
			}
					
		}
		catch(Exception e)
		{
			System.out.println("Exception occurred is"+ e);
		}
		
	}
	
	}
	);
}
	public static void main(String args[])
	{
		DemoJDBC emps = new DemoJDBC("Employee Details");
		emps.setSize(400,400);
		emps.setVisible(true);
	}
}
