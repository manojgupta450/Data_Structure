package com.manu.solid.ISP.GoodCode;

// Credit Card supports online payments and refunds
class CreditCardPayment implements OnlinePayment, RefundablePayment {
    @Override
    public void payOnline(double amount) {
        System.out.println("Processing online payment of $" + amount + " via Credit Card.");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Processing refund of $" + amount + " to Credit Card.");
    }
}
