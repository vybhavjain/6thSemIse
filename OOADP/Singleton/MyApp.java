package Singleton;

public class MyApp{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MyThread t = new MyThread();
		t.start();
		t.join();
		Singleton.getInstance();
		

	}

}
