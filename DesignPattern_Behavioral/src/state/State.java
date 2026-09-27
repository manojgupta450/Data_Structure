package state;

public interface State {
	
    void deposit(double amount);

    void withdraw(double amount);

    void payInterest();
    
    Account getAccount();
    
    double getBalance();
}
