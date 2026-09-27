package com.manu.solid.ISP.BadCode;

// Client Code
public class ISPViolationDemo {
    public static void main(String[] args) {
        Payment cardPayment = new CreditCardPayment();
        cardPayment.payOnline(100);
        // cardPayment.payOffline(50); // Throws Exception!

        Payment creditCardPayment = new CreditCardPayment();
        creditCardPayment.refund(100);
        // cardPayment.payOffline(50); // Throws Exception!

        Payment cashPayment = new CashPayment();
        cashPayment.payOffline(50);
        // cashPayment.payOnline(30); // Throws Exception!
    }
}
