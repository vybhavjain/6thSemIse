package tryBridge;

public class BridgeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer c1=new RCCustomer("Modi", 72, new Discount1());
		c1.showBill(500);
		
		c1.setDiscount(new Discount2());
		c1.showBill(500);
		
		c1.setDiscount(new Discount3());
		c1.showBill(500);
		
		c1.setDiscount(new Discount4());
		c1.showBill(500);
		
		Customer c2=new FTCCustomer("Raga", 8, new Discount1());
		c2.showBill(500);
		
		c2.setDiscount(new Discount2());
		c2.showBill(500);
		
		c2.setDiscount(new Discount3());
		c2.showBill(500);
		
		c2.setDiscount(new Discount4());
		c2.showBill(500);
		
		Customer c3=new SSCustomer("Anjaneya", 25, new Discount1());
		c3.showBill(500);
		
		c3.setDiscount(new Discount2());
		c3.showBill(500);
		
		c3.setDiscount(new Discount3());
		c3.showBill(500);
		
		c3.setDiscount(new Discount4());
		c3.showBill(500);
		

	}

}
