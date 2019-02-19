package student;
import java.util.*;

public class student12 {
	
	String name;
	int[] m=new int[5];
student12(String name, int m1,int m2 ,int m3,int m4 ,int m5)
{this.name=name;
this.m[0]=m1;
this.m[1]=m2;
this.m[2]=m3;
this.m[3]=m4;
this.m[4]=m5;
}
	public void sgpa()
	{float sum=0;
	float grades;
	for(int j=0;j<5;j++)
		{
			if(m[j]>=90)
				{System.out.println("S+ grades in sub"+(j+1));
			    sum+=10*4;}
			if(m[j]>=80 && m[j]<90)
			{System.out.println("S grades in sub"+(j+1));
		    sum+=9*4;}
			if(m[j]>=70 && m[j]<80)
			{System.out.println("A grades in sub"+(j+1));
		    sum+=8*4;}
			if(m[j]>=60 && m[j]<70)
			{System.out.println("B grades in sub"+(j+1));
		    sum+=7*4;}
			if(m[j]>=50 && m[j]<60)
			{System.out.println("C grades in sub"+(j+1));
		    sum+=6*4;}
			if(m[j]>=40 && m[j]<50)
			{System.out.println("D grades in sub"+(j+1));
		    sum+=5*4;}
			if(m[j]<40)
			{System.out.println("FAILED:("+(j+1));
		    sum=0;}
		}
	if(sum==0)
		{System.out.println("Sorry!!!not passed in any subject");}
		else {
			grades=sum/20;
			System.out.println("Your sgpa is"+grades);
		}
	
	}
	

	public static void main(String[] args) {

		String name;
		
		int[] m=new int[5];
		Scanner scan =new Scanner(System.in);
		System.out.println("Enter name");
		name=scan.next();
		System.out.println("Enter the marks");
		for(int i=0;i<5;i++)
		{
			System.out.println("Enter the marks for subject"+(i+1));
		    m[i]=scan.nextInt();
			
		}
		student12 ob=new student12("Ram", m[0], m[1], m[2], m[3], m[4]);
		ob.sgpa();
		
	}

}
