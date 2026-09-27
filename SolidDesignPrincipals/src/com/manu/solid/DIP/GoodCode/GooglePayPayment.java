package com.manu.solid.DIP.GoodCode;

class GooglePayPayment implements PaymentMethod {
    @Override
    public void processPayment(int amount) {
        System.out.println("Paid " + amount + " using Google Pay.");
    }
}
