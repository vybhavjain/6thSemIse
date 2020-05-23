package testprac;

public class client {

	public static void main(String[] args) {
		NumberThread thread1 = new NumberThread();
		VowelsThread thread2 = new VowelsThread();
		
		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread2);
		t1.start();
		t2.start();
	}

}
