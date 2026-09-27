package state;

public class Account {
	
	private State state;
    private String owner;
    
 // New accounts are 'Silver' by default
	public Account(String owner) {
		super();
		this.state = new SilverState(this, 0.0);
		this.owner = owner;
	}
	
	public void deposit(double amount) {
		state.deposit(amount);
		System.out.println("Deposited --- "+amount);
		System.out.println("Balance --- "+this.state.getBalance());
		System.out.println("Status --- "+this.state.getClass().getSimpleName());
		System.out.println("--------------------------------");
	}
	public void withdraw(double amount){
		state.withdraw(amount);
		System.out.println("Withdrew --- "+amount);
		System.out.println("Balance --- "+this.state.getBalance());
		System.out.println("Status --- "+this.state.getClass().getSimpleName());
		System.out.println("--------------------------------");
	}
	public void payInterest(){
		state.payInterest();
		System.out.println("Interest Paid --- ");
		System.out.println("Balance --- "+this.state.getBalance());
		System.out.println("Status --- "+this.state.getClass().getSimpleName());
		System.out.println("--------------------------------");
	}
	public void setState(State state) {
		this.state = state;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public State getState() {
		return state;
	}

	public String getOwner() {
		return owner;
	}
	
}