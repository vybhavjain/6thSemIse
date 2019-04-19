package Singleton;

public class MyThread extends Thread {
	public void run() {
		Singleton.getInstance();
	}
}
