package com.manu.solid.OCP.BadCode.processor;

import com.manu.solid.OCP.BadCode.paymentTypes.BankTransferPayment;
import com.manu.solid.OCP.BadCode.paymentTypes.CreditCardPayment;
import com.manu.solid.OCP.BadCode.paymentTypes.PayPalPayment;

public class PaymentProcessor {
    public void processPayment(String paymentType, double amount) {
        if (paymentType.equals("CreditCard")) {
            CreditCardPayment creditCardPayment = new CreditCardPayment();
            creditCardPayment.processPayment(amount);
        } else if (paymentType.equals("PayPal")) {
            PayPalPayment payPalPayment = new PayPalPayment();
            payPalPayment.processPayment(amount);
        } else if (paymentType.equals("BankTransfer")) {
            BankTransferPayment bankTransferPayment = new BankTransferPayment();
            bankTransferPayment.processPayment(amount);
        } else {
            System.out.println("Unsupported payment method");
        }
    }
}