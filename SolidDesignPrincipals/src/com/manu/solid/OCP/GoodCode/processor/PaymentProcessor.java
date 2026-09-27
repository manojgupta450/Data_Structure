package com.manu.solid.OCP.GoodCode.processor;

import com.manu.solid.OCP.GoodCode.PaymentMethod;

public class PaymentProcessor {
    PaymentMethod paymentMethod;

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(double amount) {
        paymentMethod.processPayment(amount);
    }
}