package ooadplab;

public class product {
String name;
int qty;
double price;
CaclTax ct;
public product(String name,double price,CaclTax ct) {
	this.name = name;
	this.price = price;
	this.ct = ct;
}
void setqty(int qty) {
	this.qty = qty;
}

void setCt(CaclTax ct) {
	this.ct = ct;
}

void printprice() {
	double tax = ct.taxAmount(price,qty);
	System.out.println("Thanks for buying " +name);
	System.out.println("tax amount is  = " +tax);
	System.out.println(" amount is  = " +price*qty + "for  a quantity of " +qty);
	double total = price*qty +tax;
	System.out.println("Billed amount with tax is  = " +total);
}
}
