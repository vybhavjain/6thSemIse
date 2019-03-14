package Decorator;

public class BillingApp {
	public static void main(String[] args) 
	{
		Beverage myBeverage = new Espresso();
		
		System.out.println(myBeverage.getDescription());
		Beverage beverage2 = new Mocha(myBeverage);
	}
}
