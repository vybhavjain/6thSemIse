package travelAgency;

import java.util.Scanner;

public class OwnArrangement implements LocalTransportation  {
	public String success3() {
		{
			String s1;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your means of transportation");
			s1 = sc.nextLine();
			//sc.close();
			s1 = "your means of transportation is " + s1;
			return s1;
		}	
	}
}
