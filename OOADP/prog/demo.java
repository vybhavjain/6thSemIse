package ooadplab;

public class demo {

public static void main(String[] args) {
	CaclTax ct = new sgst();
	product pro1 = new product("btwin 340",5000,ct);
	pro1.setqty(3);
	pro1.printprice();
	System.out.println("-------------New tax is ------------");
	pro1.setCt(new cgst());
	pro1.printprice();
	System.out.println("-------------New tax is ------------");
	pro1.setCt(new ndatax());
	pro1.printprice();
}

}
