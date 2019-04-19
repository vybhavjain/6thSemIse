package decorator;

public class Espresso extends Beverage {
	public Espresso() {
		// TODO Auto-generated constructor stub
		this.description = "Espresso";
	}

	@Override
	double cost() {
		// TODO Auto-generated method stub
		return 99.00;
	}

}
