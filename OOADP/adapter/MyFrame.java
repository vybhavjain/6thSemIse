package adapter;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	
	JLabel lab1;
	JTextField text1;
	JButton bt1;
	MyFrame(String name){
		super(name);
		setSize(200,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//setLayout(new FlowLayout());
		lab1 = new JLabel("Name");
		text1 = new JTextField(20);
		bt1 = new JButton("Submit");
		add(text1);
		add(lab1, BorderLayout.NORTH);
		add(bt1,BorderLayout.SOUTH);
		
		
	}
	

}
