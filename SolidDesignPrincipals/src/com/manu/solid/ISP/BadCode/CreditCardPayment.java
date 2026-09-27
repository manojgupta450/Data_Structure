package com.manu.solid.ISP.BadCode;

// Credit card supports online payment and refund, but not offline payment
class CreditCardPayment implements Payment {
    @Override
    public void payOnline(double amount) {
        System.out.println("Processing online payment of $" + amount + " via Credit Card.");
    }

    @Override
    public void payOffline(double amount) {
        throw new UnsupportedOperationException("Credit Card does not support offline payments.");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Processing refund of $" + amount + " to Credit Card.");
    }
}
