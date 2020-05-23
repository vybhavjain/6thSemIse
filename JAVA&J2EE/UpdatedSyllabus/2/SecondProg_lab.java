import java.util.*;

class Book
{
	String title,author, publisher;
	double price;
	Book(String title,String author,String publisher,double price)
	{ this.title=title;
	  this.author=author;
	  this.publisher=publisher;
	  this.price = price;		
	}
	public String toString()
	{
		String str= "Book has "+title+"title "+"whose author is "+author;
		str+="\n Book is published by "+publisher;
		str+="\n Price is= "+price;
		return str;
	}
	
}
class BookCompare implements Comparator<Book>
{
	public int compare(Book b1,Book b2)
	{
		return (int) (b1.price-b2.price);
	}
}


public class SecondProg_lab {
	static HashMap<Integer,Book> hmbook = new HashMap<Integer,Book>();
	static Scanner sc = new Scanner(System.in);
	static void BookHashmap(ArrayList<Book> barr)
	{ int i=1;
		for(Book b1:barr)
		{
			hmbook.put(i,b1);
			i++;
					}
		
		
	}
	static void printHashMap()
	{
		//print hashmap
				Set<Map.Entry<Integer,Book>> set = hmbook.entrySet();
				for(Map.Entry<Integer, Book> s:set)
				{
					System.out.println(s.getKey());
					System.out.println(s.getValue());
				}
		
	}
	
	static void printBookData(Book b)
	{
		String str= "Book has "+b.title+"title "+"whose author is "+b.author;
		str+="\n Book is published by "+b.publisher;
		str+="\n Price is= "+b.price;
		System.out.println(str);
	}
	
	static void Read_data(ArrayList<Book> barr)
	{
		
		while(true)
		{
			System.out.println("Do u want to enter book details? Mention yes/no");
			String val = sc.nextLine();
			if(val.toUpperCase().equals("YES"))
			{
				System.out.println("Enter Book Details");
				System.out.println("Enter Title");
				String title =sc.nextLine();
				System.out.println("Enter Author");
				String author = sc.nextLine();
				System.out.println("Enter Publisher");
				String pub = sc.nextLine();
				System.out.println("Enter Price");
				double price = Double.parseDouble(sc.nextLine());
				Book b1 = new Book(title,author,pub,price);
				barr.add(b1);
				
						}
			else
			{
				break;
			}
		}
		
	}
	static boolean isSubString(String s1,String s2)
	{
		int M = s1.length(); 
        int N = s2.length(); 
      
        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++) { 
            int j; 
      
            /* For current index i, check for 
            pattern match */
            for (j = 0; j < M; j++) 
                if (s2.charAt(i + j) != s1.charAt(j)) 
                    break; 
      
            if (j == M) 
                return false; 
        } 
      
        return true; 
	}
	
	public static void main(String args[]){
		
		ArrayList<Book> arbook = new ArrayList<Book>();
		Read_data(arbook);
		BookHashmap(arbook);
		//Sort in ascending order
		ArrayList<Book> clone = (ArrayList<Book>) arbook.clone();
		ArrayList<Book> booklist = clone;
		booklist.sort(new BookCompare());
		System.out.println("Before sorting");
		System.out.println(arbook);
		System.out.println("After sorting");
		System.out.println(booklist);	
		//Prompt for an author name and list all the books with the same author name.
		System.out.println("Enter author name");
		String aut_name = sc.nextLine();
		Set<Map.Entry<Integer,Book>> set = hmbook.entrySet();
		for(Map.Entry<Integer, Book> s:set)
		{   Book b1=s.getValue();
			String s1 =b1.author;
			if(s1.equals(aut_name))
			{
				printBookData(s.getValue());
				
			}
				
		}
		//Create a new list holding all the book details with price greater than a user specified price. 
		LinkedList<Book> lbook = new LinkedList<Book>();
		System.out.println("To list all books with price greater than a value, enter a price");
		double pri = Double.parseDouble(sc.nextLine());
		set = hmbook.entrySet();
		for(Map.Entry<Integer, Book> s:set)
		{   Book b1=s.getValue();
			if(b1.price>pri)
			{
				lbook.add(b1);
				
			}
				
		}
		//print linkedlist
		System.out.println("Books with price > than "+pri);
		for(Book b:lbook)
		{
			System.out.println(b);
		}
		//For a given a value by the user, find all the books that match either the whole or a part of the book title. 
		System.out.println("enter a part of a publishers name");
		String p = sc.nextLine();
		set = hmbook.entrySet();
		for(Map.Entry<Integer, Book> s:set)
		{   Book b1=s.getValue();
			if(isSubString(b1.title,p))
			{
				printBookData(b1);
				
			}
				
		}
		//Identify a publisher and print books from a particular publisher. 
		System.out.println("enter a  publishers name to print book details");
		p = sc.nextLine();
		set = hmbook.entrySet();
		for(Map.Entry<Integer, Book> s:set)
		{   Book b1=s.getValue();
			if(b1.publisher.equals(p))
			{
				printBookData(b1);
				
			}
				
		}
		//Update the publisher details based on a title.
		System.out.println("enter a title whose publisher is to be updated");
		String t = sc.nextLine();
		System.out.println("enter the updated publishers name");
		p = sc.nextLine();
		set = hmbook.entrySet();
		for(Map.Entry<Integer, Book> s:set)
		{   Book b1=s.getValue();
			if(b1.title.equals(t))
			{
				b1.publisher=p;
				hmbook.put(s.getKey(), b1);
				//printBookData(b1);
					}
				
		}
		printHashMap();
	}
	

}
