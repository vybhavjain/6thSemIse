package travelAgency;

import java.util.Scanner;

public class Taxi implements LocalTransportation {

	@Override
	public String success3() {
		{
			String s1;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the date of booking taxi");
			s1 = sc.nextLine();
			//sc.close();
			s1 = "you have booked a taxi at date : " + s1;
			return s1;
		}
	}

}
