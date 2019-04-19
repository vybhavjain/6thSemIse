package adapter;

public class MyNdaVersion implements CalcTax {
	NDATax mndatax = new NDATax();
	@Override
	public double taxAmount(double price, int qty) {
		// TODO Auto-generated method stub
		double tax = mndatax.newTax(price);
		return tax*qty;
	}

}
