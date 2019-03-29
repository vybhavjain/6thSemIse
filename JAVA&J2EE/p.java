package lab2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;  

import javax.swing.*;

public class mainsol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/abhijeet","root","msrit");  
			//here sonoo is database name, root is username and password  
			java.sql.Statement stmt= con.createStatement();  
			
			ResultSet rs= stmt.executeQuery("select * from emp");  
			ResultSet s=stmt.executeQuery("insert into emp values"); 
			
			stmt.executeUpdate("INSERT INTO emp " + 
	                "VALUES (1004, 'Cramden'");
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
		
		
		
		JFrame f=new JFrame("This is Panel");
		 final JTextField tf=new JTextField();  
		    tf.setBounds(50,50, 150,20);  
		JButton b=new JButton("Submit");
		b.setBounds(130,100,100, 40);
		
		b.addActionListener(new ActionListener(){  
			    public void actionPerformed(ActionEvent e){  
			            tf.setText("Welcome to Javatpoint.");  
			            
			  }});

		
		f.add(b);
		f.add(tf);
		f.setLayout(null);
		f.setSize(500,500);
		f.setVisible(true);
	}

}
