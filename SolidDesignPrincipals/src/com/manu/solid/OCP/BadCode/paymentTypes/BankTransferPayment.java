package com.manu.solid.OCP.BadCode.paymentTypes;

public class BankTransferPayment {
    public void processPayment(double amount) {
        System.out.println("Processing bank transfer payment of " + amount);
    }
}
