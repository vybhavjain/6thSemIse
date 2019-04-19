package Singleton;

public class Singleton {
	public static Singleton uniqueInstance;
	private Singleton() {
		System.out.println("i am the only instance");
	}
	public static  Singleton getInstance() {
		if(uniqueInstance==null) {
			System.out.println(Thread.currentThread());
			uniqueInstance = new Singleton();

		}
		//System.out.println("returing the instance");
		return uniqueInstance;
	}
	
}
