package decorator;

public abstract class CondimentDecorator extends Beverage {
	
	Beverage beverage;
	

	@Override
	abstract double cost(); 

}
