package com.manu.solid.OCP.GoodCode.paymentTypes;

import com.manu.solid.OCP.GoodCode.PaymentMethod;

public class BankTransferPayment implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Processing bank transfer payment of " + amount);
    }
}
