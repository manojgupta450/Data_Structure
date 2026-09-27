package com.manu.solid.DIP.GoodCode;

// Different payment methods implementing the common abstraction
class CreditCardPayment implements PaymentMethod {
    @Override
    public void processPayment(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

