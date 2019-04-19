package decorator;

public abstract class Beverage {
	String description = "not known";
	String getDescription() {
		return description;
	}
	
	abstract double cost();

}
