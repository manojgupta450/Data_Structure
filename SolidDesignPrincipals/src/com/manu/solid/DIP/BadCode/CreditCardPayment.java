package com.manu.solid.DIP.BadCode;

// Concrete payment classes
class CreditCardPayment {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}
