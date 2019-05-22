import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.GridLayout;
import java.sql.*;

public class Database extends JFrame {
JLabel jlb1 = new JLabel("Enter customer number ");
JLabel jlb2 = new JLabel("Enter customer name");
JLabel jlb3 = new JLabel("Enter state");
JLabel jlb4 = new JLabel("Enter credit limit");
JLabel jlb5 = new JLabel("Enter representative number");
JTextField txt1 = new JTextField(10);
JTextField txt2 = new JTextField(10);
JTextField txt3 = new JTextField(10);
JTextField txt4 = new JTextField(10);
JTextField txt5 = new JTextField(10);
JButton insertbtn = new JButton("insert");
public Database(String title)
{
    super(title);
    setLayout(new FlowLayout());
    add(jlb1);add(txt1);
    add(jlb2);add(txt2);
    add(jlb3);add(txt3);
    add(jlb4);add(txt4);
    add(jlb5);add(txt5);
    add(insertbtn);
    insertbtn.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent evt)
    {
        Statement stmt;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","msrit");
            stmt = conn.createStatement();
            
            String query2 = "insert into cust values("+Integer.parseInt(txt1.getText())+", '"+txt2.getText()+"','"+txt3.getText()+"','"+Integer.parseInt(txt4.getText())+"',"+Integer.parseInt(txt5.getText())+");";
            stmt.executeUpdate(query2);
            ResultSet rs= stmt.executeQuery("select * from rep where repno in (select repno from cust where c_limit > 16000 );");
            while(rs.next())
            {
                System.out.println("Customer number is "+rs.getInt(1));
                System.out.println("Customer name is "+rs.getString(2));
                System.out.println("State is "+rs.getString(3));
                System.out.println("Credit limit is "+rs.getInt(4));
                
            }
           
        }
        catch(Exception e)
        {
            System.out.println("Exception occurred is"+ e);
        }
        
    }
    
    });
}
    public static void main(String args[])
    {
        Database emps = new Database("Details");
        emps.setSize(400,400);
        emps.setVisible(true);
    }
}
