package simpleFactory;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SimpleFrame extends JFrame {
	JLabel label;
	JTextField textfield;
	JButton btn;
	
	public SimpleFrame(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Enter Your Name");
		textfield = new JTextField(20);
		btn = new JButton("Submit");
		setLayout(new FlowLayout());
		add(label);
		add(textfield);
		add(btn);
		pack();
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = textfield.getText();
				NameFactory factory = new NameFactory();
				NameDivider nd = factory.getInstance(name);
				String fName = nd.getFirstName();
				String lName = nd.getLastName();
				JOptionPane.showMessageDialog(null, "First Name = "+fName+"\nLast Name= "+lName);
				
			}
		});
	}
	
}
