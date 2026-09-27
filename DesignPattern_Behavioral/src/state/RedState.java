package state;

public class RedState implements State {
	
    private Account account;
    private double balance;
    private double upperLimit;
    private double serviceFee;

    public RedState(State state){
    	this(state.getAccount(), state.getBalance());
    }
    
	public RedState(Account account, double balance) {
		super();
		this.account = account;
		this.balance = balance;
		this.upperLimit = 0.0;
		this.serviceFee = 15.00;
	}

	@Override
	public void deposit(double amount) {
		balance += amount;
		stateChangeCheck();
	}

	@Override
	public void withdraw(double amount) {
		balance = balance - serviceFee;
		System.out.println("No funds available for withdrawal!");
	}

	@Override
	public void payInterest() {
		//No interest in this state of account
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	private void stateChangeCheck() {
		if (balance > upperLimit){
	        account.setState(new SilverState(this));
		}
	}
}

