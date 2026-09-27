package com.manu.solid.OCP.GoodCode.paymentTypes;

import com.manu.solid.OCP.GoodCode.PaymentMethod;

public class PayPalPayment implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of " + amount);
    }
}
