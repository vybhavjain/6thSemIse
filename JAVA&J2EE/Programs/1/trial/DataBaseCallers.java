package trial;

import java.util.*;
import java.util.Map.*;

public class DataBaseCallers {
public static HashMap<Long,String> hm;
public static Scanner sc = new Scanner(System.in);
static void createEnteries(int n)
{ 
	hm = new HashMap<Long,String>();
	for(int i=0;i<n;i++)
	{
		System.out.println("Enter the phone number and Contact name");
		hm.put(sc.nextLong(), sc.next());
	}
}
public static void ForHoldingData() {
     System.out.println("Enter how many details do you require?");
     createEnteries(sc.nextInt());
}
public static void display()
{
Set<Entry<Long,String>> hashSet=hm.entrySet();
        for(Entry<Long,String> entry:hashSet ) {
            System.out.println("Key="+entry.getKey()+", Value="+entry.getValue());
        }
}
}
