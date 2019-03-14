package Decorator;

public abstract class Beverage {
	String description = "Not known";
	String getDescription() 
	{
		return description;
	}
	abstract double cost();
}
