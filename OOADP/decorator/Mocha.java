package decorator;

public class Mocha extends CondimentDecorator {
	
	Mocha(Beverage beverage){
		this.beverage = beverage;
	}
	
	String getDescription() {
		return beverage.getDescription()+", Mocha";
	}
	@Override
	double cost() {
		// TODO Auto-generated method stub
		return 20.00+beverage.cost();
	}

}
