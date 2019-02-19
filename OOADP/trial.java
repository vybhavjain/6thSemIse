package prog1;
import java.util.*;


public class run {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
        int n;
        String[] acc= new String[20];
        int[] arr = new int[10];
        System.out.println("Enter number of items u wanna buy");
        int k = sc.nextInt();
        for (int i = 1; i <= k; ++i)
        {   
        	System.out.println("enter item number");
        	n = sc.nextInt();
            System.out.println("and enter the content of " + n);
            acc[i] = sc.next();
            arr[i] = n;
        }
        for (int i = 1; i <= k; ++i)
            System.out.println("ITEM NUMBER" + arr[i] + "is " + acc[i]);
        
    }
}
