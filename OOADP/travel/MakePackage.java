package travelAgency;
import java.util.*;

public class MakePackage {
void newone()
{
	String s1,s2,s3;
	International in = new International(); 
	Domestic dome = new Domestic(); 
	ResortStay rs = new ResortStay(); 
	HotelStay hs = new HotelStay(); 
	DomesticFlight df = new DomesticFlight(); 
	Taxi tax= new Taxi(); 
	OwnArrangement oa = new OwnArrangement();
	Scanner sc = new Scanner(System.in);
	int ch;
	System.out.println("enter 1 for International flight. enter 2 for domestic flight");
	ch = sc.nextInt();
	if (ch ==1)
	{
		 s1 = in.success();
	}
	else
	{
		 s1 = dome.success();
	}
	System.out.println("enter 1 for resort . enter 2 for hotel");
	ch = sc.nextInt();
	if (ch ==1)
	{
		 s2 = rs.success2();
	}
	else
	{
		 s2 = hs.success2();
	}
	System.out.println("enter 1 for taxi . enter 2 for domestic flight. Enter 3 for own arrangement");
	ch = sc.nextInt();
	if (ch ==1)
	{
		 s3 = tax.success3();
	}
	else if (ch ==2)
	{
		 s3 = df.success3();
	}
	else
	{
		 s3 = oa.success3();
	}
	System.out.print("Customised package is " + s1 + "\n" + s2 + "\n" + s3);
}
}
