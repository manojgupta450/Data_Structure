package state;

public class SilverState implements State {
	
    private Account account;
    private double balance;
    private double interest;
    private double lowerLimit;
    private double upperLimit;
    
    public SilverState(State state){
    	this(state.getAccount(), state.getBalance());
    }
    
	public SilverState(Account account, double balance) {
		super();
		this.account = account;
		this.balance = balance;
		this.interest = 0.0;
		this.lowerLimit = 0.0;
		this.upperLimit = 1000.0;
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
		if (balance < lowerLimit){ 
			account.setState(new RedState(this)); 
			}else if (balance > upperLimit){
			account.setState(new GoldState(this));
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
