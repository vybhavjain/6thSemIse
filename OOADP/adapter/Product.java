package adapter;

public class Product {
	String name;
	int qty;
	double price;
	CalcTax ct;
	public Product(String name, double price, CalcTax ct) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.price = price;
		this.ct = ct;
	}
	
	void setQty(int qty) {
		this.qty = qty;
	}
	void setCt(CalcTax ct) {
		this.ct = ct;
	}
	void printPrice() {
		double tax = ct.taxAmount(price, qty);
		System.out.println("Thanks for buying "+name);
		System.out.println("Billed amount = "+price*qty);
		System.out.println("Tax = "+tax);
		System.out.println("Final Amount = "+ (price*qty+tax));
	}
}
