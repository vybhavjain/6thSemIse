package Decorator;

public class Espresso extends Beverage {
	public Espresso()
	{
		this.description = "espresso";
	}
	double cost()
	{
		return 99.00;
	}
}
