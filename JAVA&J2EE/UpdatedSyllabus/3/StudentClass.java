import java.awt.*;
import java.awt.event.*;
//import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.*;

class Student {
String name,usn,address,category;
int age;
//float sgpa1,sgpa2,sgpa3,sgpa4,sgpa5,sgpa6,sgpa7,sgpa8;
float cgpa;
public Student(String name,String usn,String address,String cat,int age, float cgpa)
{
this.name=name; this.usn=usn;
this.address=address; this.category=cat;
this.age=age;
this.cgpa=cgpa;
}
public String toString()
{
	String stud= name + " "+usn+" residing in "+address+" belonging to category "+category+" of age "+age;
	stud+= "has cgpa "+cgpa;
	return stud;
}

}

public class StudentClass implements ActionListener{
	LinkedList<Student> stud_list = new LinkedList<Student>();
	JLabel jl1 = new JLabel("Enter Name");
	JLabel jl13 = new JLabel("Enter usn");
	JLabel jl2 = new JLabel("Enter Age");
	JLabel jl3 = new JLabel("Enter Address");
	JLabel jl4 = new JLabel("Select category");
	JLabel jl5 = new JLabel("Enter sgpa of I sem");
	JLabel jl6 = new JLabel("Enter sgpa of II sem");
	JLabel jl7 = new JLabel("Enter sgpa of III sem");
	JLabel jl8 = new JLabel("Enter sgpa of IV sem");
	JLabel jl9 = new JLabel("Enter sgpa of V sem");
	JLabel jl0 = new JLabel("Enter sgpa of VI sem");
	JLabel jl11 = new JLabel("Enter sgpa of VII sem");
	JLabel jl12 = new JLabel("Enter sgpa of VIII sem");
	JLabel jcgpa = new JLabel("CGPA obtained");
	JTextField name=new JTextField(20) ;
	JTextField usn=new JTextField(20) ;
	JTextField age=new JTextField(3) ;
	JTextArea address=new JTextArea(3,4) ;
	JComboBox cat=new JComboBox() ;
	JTextField cgpa =new JTextField(10); 
	JTextField sgpa1 = new JTextField(5);
	JTextField sgpa2 = new JTextField(5);
	JTextField sgpa3 = new JTextField(5);
	JTextField sgpa4 = new JTextField(5);
	JTextField sgpa5 = new JTextField(5);
	JTextField sgpa6 = new JTextField(5);
	JTextField sgpa7 = new JTextField(5);
	JTextField sgpa8 = new JTextField(5);
	JButton submit = new JButton("compute");
	JButton done = new JButton("done");
	JButton display = new JButton("display");
	JTextArea stud_list_display = new JTextArea(20,20);
	JFrame f1=new JFrame("Student Information");
	JFrame f2=new JFrame("Student Collection Display");
StudentClass()
{
	//JFrame f1=new JFrame("Student Information");
	jl1.setBounds(10,10,10,10);
	cat.addItem("GM");
	cat.addItem("SC/ST");
	cat.addItem("Cat1");
	cat.addItem("Cat2");
	f1.add(jl1);f1.add(name);
	f1.add(jl13);f1.add(usn);
	f1.add(jl2);f1.add(age);f1.add(jl3);f1.add(address);
	f1.add(jl4);f1.add(cat);
	f1.add(jl5);f1.add(sgpa1);f1.add(jl6);f1.add(sgpa2);f1.add(jl7);f1.add(sgpa3);f1.add(jl8);f1.add(sgpa4);
	f1.add(jl9);f1.add(sgpa5);f1.add(jl0);f1.add(sgpa6);f1.add(jl11);f1.add(sgpa7);f1.add(jl12);f1.add(sgpa8);
	f1.add(jcgpa);f1.add(cgpa);
	f1.add(submit);f1.add(done);f1.add(display);
	f2.add(stud_list_display);
	f1.setSize(900,800);
	f1.setLayout(new GridLayout(8,8));
	f1.setVisible(true);
	submit.addActionListener(this);
	done.addActionListener(this);
	display.addActionListener(this);
	}
public void actionPerformed(ActionEvent evt)
{
	if(evt.getSource()==submit)
	{
		//check for validations
		try
		{
			int v1=Integer.parseInt(age.getText());
			if(v1<18 || v1>35)
			{
				String age1=JOptionPane.showInputDialog(null,"Enter valid Age");
				age.setText(age1);
	
			}
			
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(f1, "Invalid entry");
			age.requestFocus();
					}
		
		checkSGPA_valid(1,sgpa1);
		checkSGPA_valid(2,sgpa2);
		checkSGPA_valid(3,sgpa3);
		checkSGPA_valid(4,sgpa4);
		checkSGPA_valid(5,sgpa5);
		checkSGPA_valid(6,sgpa6);
		checkSGPA_valid(7,sgpa7);
		checkSGPA_valid(8,sgpa8);
		float cal_cgpa = calculate_cgpa();
		cgpa.setText(Float.toString(cal_cgpa));
		
		}
	else if(evt.getSource()==done)//to submit into collection
	{
		Student s1 = new Student(name.getText(),usn.getText(),address.getText(),String.valueOf(cat.getSelectedItem()),Integer.parseInt(age.getText()),Float.parseFloat(cgpa.getText()));
		stud_list.add(s1);
	}
	else {
		f1.setVisible(false);
		f2.setVisible(true);
		f2.setSize(500,500);
		stud_list_display.setText(" ");
		for(Student s:stud_list)
		{
			stud_list_display.append(s.toString()+ "\n");
		}
	}
	
}
float calculate_cgpa()
{
	float v1 = Float.parseFloat(sgpa1.getText());
	float v2 = Float.parseFloat(sgpa2.getText());
	float v3 = Float.parseFloat(sgpa3.getText());
	float v4 = Float.parseFloat(sgpa4.getText());
	float v5 = Float.parseFloat(sgpa5.getText());
	float v6 = Float.parseFloat(sgpa6.getText());
	float v7 = Float.parseFloat(sgpa7.getText());
	float v8 = Float.parseFloat(sgpa8.getText());
	return (v1+v2+v3+v4+v5+v6+v7+v8)/8;
}
	

void checkSGPA_valid(int sem,JTextField sgpa)
{
	try {
		
	if(Float.parseFloat(sgpa.getText())>10)
	{
		String v1 = JOptionPane.showInputDialog(null,"Enter an SGPA less than or equal to 10 for sem "+sem);
		sgpa.setText(v1);
	}
	}
	catch(NumberFormatException e) {
		String v2=JOptionPane.showInputDialog(null, "Please enter SGPA for semester "+sem);
		sgpa.setText(v2);
		//sgpa.requestFocus();
		
	}
}
public static void main(String args[])
{
	StudentClass sc = new StudentClass();
}
}
