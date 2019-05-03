package trial;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class progressbar extends JFrame implements Runnable,ActionListener {

	JPanel jp;
	JProgressBar jpb;
	JLabel fromLabel,toLabel;
	JTextField fromName,toName;
	JButton copyButton,stopButton;
	BufferedInputStream inBuffer;
	BufferedOutputStream outBuffer;
	public progressbar() {
		setLayout(new GridLayout(0,1));
		
		jp=new JPanel();
		add(jp);
		jpb=new JProgressBar(0, 100);
		jpb.setStringPainted(true);
		jp.add(jpb);
		
		fromLabel=new JLabel("Source File:");
		fromName =new JTextField();
		toLabel=new JLabel("Destination File:");
		toName =new JTextField();
		
		copyButton=new JButton("START");
		stopButton=new JButton("STOP");
		
		copyButton.addActionListener(this);
		stopButton.addActionListener(this);
		
		add(fromLabel);add(fromName);
		add(toLabel);add(toName);
		add(copyButton);add(stopButton);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==copyButton) {
			run();
		}
		else if(e.getSource()==stopButton) {
			try {
			
				if(inBuffer!=null)
					inBuffer.close();
				if(outBuffer!=null)
					outBuffer.close();
				inBuffer=new BufferedInputStream(new FileInputStream(toName.getText()));
				Scanner content=new Scanner(inBuffer);
				while(content.hasNextLine()) {
					System.out.println(content.nextLine());
				}
			}catch (IOException except) {
				except.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		String inFile=fromName.getText();
		String outFile=toName.getText();
		
		File in=new File(inFile);
		File out=new File(outFile);
		byte input[]=new byte[10];
		
		int total=0,rcount=0,tcount=0;
		try {
			out.createNewFile();
			inBuffer=new BufferedInputStream(new FileInputStream(in));
			outBuffer=new BufferedOutputStream(new FileOutputStream(out));
			total=inBuffer.available();
			while((rcount=inBuffer.read(input))!=-1) {
				outBuffer.write(input);
				tcount+=rcount;
				jpb.setValue((int)(tcount*100)/total);
			}
			
			inBuffer.close();
			outBuffer.close();
					
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		
		progressbar fp=new progressbar();
		fp.setSize(200, 200);
		fp.setVisible(true);
	}
}
