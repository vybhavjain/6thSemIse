package adapter;

import javax.swing.SwingUtilities;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new MyFrame("My First Frame");
			}
		});

	}

}
