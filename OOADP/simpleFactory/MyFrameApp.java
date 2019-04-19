package simpleFactory;

import javax.swing.SwingUtilities;

public class MyFrameApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new SimpleFrame("Name Divider App");
			}
		});

	}

}
