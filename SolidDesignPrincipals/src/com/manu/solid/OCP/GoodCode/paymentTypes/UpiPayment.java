package com.manu.solid.OCP.GoodCode.paymentTypes;

import com.manu.solid.OCP.GoodCode.PaymentMethod;

public class UpiPayment implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("UPI payment of " + amount);
    }
}
