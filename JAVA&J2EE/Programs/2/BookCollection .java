import java.util.*;

public class BookCollection {

	public static void main(String[] args) {
        List<CreateBook> cb= new ArrayList<CreateBook>();
        List<CreateBook> cb2= new ArrayList<CreateBook>();

		cb.add(new CreateBook("a1","t1","p1",45));
		cb.add(new CreateBook("a5","t2","p3",15));
		cb.add(new CreateBook("a5","t2","p3",1));
		cb.add(new CreateBook("a9","t2","p3",80));
		cb.add(new CreateBook("a7","t2","p3",2));

		cb2.addAll(cb);
		
		Collections.sort(cb,new Comparator<CreateBook>() {
		public int compare(CreateBook o1,CreateBook o2) 
		{return Double.compare(o1.price ,o2.price);}
		});
		
		System.out.println("unsorted list is \n "+cb2);
		System.out.println("sorted list is \n "+cb);
		}
	}
