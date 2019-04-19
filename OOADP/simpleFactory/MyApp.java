package simpleFactory;

import java.util.Scanner;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter name");
		String name = sc.nextLine();
		NameFactory myFactory = new NameFactory();
		NameDivider nd = myFactory.getInstance(name);
		System.out.println("First Name = "+nd.getFirstName());
		System.out.println("Last Name = "+nd.getLastName());

	}

}
