public class CreateBook {
	String title,author,publisher;
	float price;
	CreateBook(String t,String a,String p,float pr){

		this.title=t;
		this.author=a;
		this.publisher=p;
		this.price=pr;
	}
	public String toString() {
		  return "\n\n title=" + title + "\n auther= " + author + "\n publisher = " + publisher + "\n price = " +price;
		}
}
