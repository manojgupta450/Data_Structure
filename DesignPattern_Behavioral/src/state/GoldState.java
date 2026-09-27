package state;

public class GoldState implements State {
	
    private Account account;
    private double balance;
    private double interest;
    private double lowerLimit;
	
    public GoldState(State state){
    	this(state.getAccount(), state.getBalance());
    }
	 
    public GoldState(Account account, double balance) {
    	super();
    	this.account = account;
    	this.balance = balance;
    	this.interest = 0.05;
    	this.lowerLimit = 1000.0;
    }
	 
	@Override
	public void deposit(double amount) {
		balance += amount;
		stateChangeCheck();
	}

	@Override
	public void withdraw(double amount) {
		balance -= amount;
		stateChangeCheck();
	}

	private void stateChangeCheck() {
		if (balance < 0.0){
			account.setState(new RedState(this));
		}else if (balance < lowerLimit){
			account.setState(new SilverState(this));
		}
	}

	@Override
	public void payInterest() {
		balance += interest * balance;
		stateChangeCheck();
	}

	@Override
	public Account getAccount() {
		return this.account;
	}

	@Override
	public double getBalance() {
		return this.balance;
	}

}

