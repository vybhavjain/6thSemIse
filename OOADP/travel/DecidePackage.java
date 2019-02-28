package travelAgency;
import java.util.*;

public class DecidePackage {

	public static void main(String[] args) {
		int ch;
		String a1,a2,a3,a4,a5,a6;
		Scanner sc = new Scanner(System.in);
		International in = new International(); 
		Domestic dome = new Domestic(); 
		ResortStay rs = new ResortStay(); 
		HotelStay hs = new HotelStay(); 
		DomesticFlight df = new DomesticFlight(); 
		Taxi tax= new Taxi(); 
		OwnArrangement oa = new OwnArrangement();
		MakePackage mp = new MakePackage();
		System.out.println("Package 1 is International flight + resort + domestic ");
		System.out.println("Package 2 is domestic + hotel + taxi");
		System.out.println("Enter 1 for package 1 . \n Enter 2 for package 2 . Enter 3 for new package \n");
		ch = sc.nextInt();
		//sc.close();
		switch(ch)
		{
		case 1:a1=in.success();
			   a2=rs.success2();
			   a3=df.success3();
			   System.out.println(a1 +"\n"+ a2 +"\n"+a3);
			break;
		case 2:a4=dome.success();
			   a5=hs.success2();
			   a6=tax.success3();
			   System.out.println(a4 +"\n"+ a5+"\n"+ a6);
			   break;
		case 3:mp.newone();
		   break;
		default: 
			System.out.println("Please try again with a valid number");
		}
		
	}

}
