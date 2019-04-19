package decorator;

public class WhippedCream extends CondimentDecorator {
	public WhippedCream(Beverage beverage) {
		// TODO Auto-generated constructor stub
		this.beverage = beverage;
		
	}
	
	@Override
	String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription()+", Whipped Cream";
	}
	@Override
	double cost() {
		// TODO Auto-generated method stub
		return 30.00+beverage.cost();
	}

}
