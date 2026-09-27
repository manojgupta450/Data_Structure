package state;

public class StatePatternDemo {

	public static void main(String[] args) {
              // Open a new account
	      Account account = new Account("Dinesh Rajput");
	      // Apply financial transactions
	      account.deposit(500.0);
	      account.deposit(300.0);
	      account.deposit(550.0);
	      account.payInterest();
	      account.withdraw(2000.00);
	      account.withdraw(1100.00);
	}

}
