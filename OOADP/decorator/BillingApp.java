package decorator;

public class BillingApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Beverage myBeverage = new Espresso();
		
		System.out.println(myBeverage.getDescription()+"-"+myBeverage.cost());
		Beverage beverage2 = new Mocha(myBeverage);
		System.out.println(beverage2.getDescription()+"-"+beverage2.cost());
		beverage2 = new WhippedCream(beverage2);
		System.out.println(beverage2.getDescription()+"-"+beverage2.cost());
		beverage2 = new Mocha(beverage2);
		System.out.println(beverage2.getDescription()+"-"+beverage2.cost());

	}

}
