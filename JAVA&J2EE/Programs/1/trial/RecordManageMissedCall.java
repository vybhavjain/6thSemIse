package trial;

import java.util.*;

public class RecordManageMissedCall {
	static LinkedList<MissedCallDetails> amiss;
	static void HandleMissedCallActivities()
	{
		amiss = new LinkedList<MissedCallDetails>();
		while(true)
		{
			System.out.println("Enter a choice\n");
			System.out.println("");
			int choice = DataBaseCallers.sc.nextInt();
			switch(choice)
			{
			case 1: 
			System.out.println("Enter the missed call telephone number");
			Calendar cb = Calendar.getInstance();
			Long telnum= DataBaseCallers.sc.nextLong();
			String name; 
			if(DataBaseCallers.hm.containsKey(telnum))
				name = DataBaseCallers.hm.get(telnum);
			else
				name = "Private Caller";
			MissedCallDetails mcd = new MissedCallDetails(cb,telnum,name);
			if(amiss.size()==10)
			amiss.removeLast();
			amiss.addFirst(mcd);
			break;
			case 2: 
				ListIterator<MissedCallDetails> it = amiss.listIterator();
				LinkedList<MissedCallDetails> removeList = new LinkedList<MissedCallDetails>();
				int i=0;
				while(it.hasNext()){ 
				i++;
				System.out.println("Number is ");
				MissedCallDetails m1 = it.next();
				System.out.println(m1.tel_num+"\nDo you want to delete the details related to this number? Indicate by 1 : delete, 2: move next call , 3: display call details \n");
				int cho = DataBaseCallers.sc.nextInt();
				if(cho==1)
				removeList.add(m1);
				else if(cho==3)
				m1.display();
				}
if(i==0)
System.out.println("No missed calls");
amiss.removeAll(removeList);
break;

case 3: 
System.out.println("Delete based on the number given by user\nEnter the number");
Long num = DataBaseCallers.sc.nextLong();
ListIterator<MissedCallDetails> it1 = amiss.listIterator();
boolean flag = false;
i=0;
while(it1.hasNext())
{ 
	i++;
	MissedCallDetails m1 = it1.next();
	if(m1.tel_num==num)
	{
		flag =true;
		amiss.remove(m1);
		break;
	}
}
if(i!=0)
{
	if(flag)
	System.out.println("Phone number with details "+ num +"deleted");
	else
	System.out.println("No such number exists");
}
else
System.out.println("No missed Call");
break;

case 4:
ListIterator<MissedCallDetails> it2 = amiss.listIterator();
while(it2.hasNext())
{
	MissedCallDetails m1 = it2.next();
	m1.display();
}
break;

default: 
System.exit(0); 

}}}

public static void main(String[] args) {
DataBaseCallers.ForHoldingData();
System.out.println("Receive missed Calls");
HandleMissedCallActivities();
DataBaseCallers.display();
}}
