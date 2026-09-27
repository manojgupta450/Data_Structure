package com.manu.solid.OCP.GoodCode.paymentTypes;

import com.manu.solid.OCP.GoodCode.PaymentMethod;

public class CreditCardPayment implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of " + amount);
    }
}

