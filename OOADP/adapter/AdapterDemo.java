package adapter;

public class AdapterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalcTax ct = new SGST();
		Product pro1 = new Product("Btwin Rockride 340", 13999.0,ct);
		pro1.setQty(3);
		pro1.printPrice();
		System.out.println("------new tax------");
		pro1.setCt(new CGST());
		pro1.printPrice();
		System.out.println("------new tax------");
		pro1.setCt(new MyNdaVersion());
		pro1.printPrice();

	}

}
