package factory;

public abstract class Plan {
	
	protected double rate;
	
	abstract public void getRate();
	public void calculateBill(int units) {
		System.out.println(rate * units);
	}

}
