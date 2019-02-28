package travelAgency;

import java.util.Scanner;

public class ResortStay implements BookStay {
	public String success2()
	{
		String s1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the resort to stay in");
		s1 = sc.nextLine();
		//sc.close();
		s1 = "you have booked the resort " + s1; 
		return s1;
	}
}
