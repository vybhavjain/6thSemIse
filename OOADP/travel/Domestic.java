package travelAgency;

import java.util.Scanner;

public class Domestic implements BookFlight {
	public String success()
	{
		String s1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the city you wish to book a flight to");
		s1 = sc.nextLine();
		//sc.close();
		s1 = "you have booked a domestic flight to " + s1; 
		return s1;
	}
}
