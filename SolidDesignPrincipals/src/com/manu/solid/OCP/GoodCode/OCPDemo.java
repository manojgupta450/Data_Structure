package com.manu.solid.OCP.GoodCode;

import com.manu.solid.OCP.GoodCode.paymentTypes.BankTransferPayment;
import com.manu.solid.OCP.GoodCode.paymentTypes.CreditCardPayment;
import com.manu.solid.OCP.GoodCode.paymentTypes.PayPalPayment;
import com.manu.solid.OCP.GoodCode.processor.PaymentProcessor;

public class OCPDemo {
    public static void main(String[] args) {
        PaymentProcessor creditCardProcessor = new PaymentProcessor(new CreditCardPayment());
        creditCardProcessor.processPayment( 100.0);

        PaymentProcessor paypalProcessor = new PaymentProcessor(new PayPalPayment());
        paypalProcessor.processPayment( 200.0);

        PaymentProcessor bankTxProcessor = new PaymentProcessor(new BankTransferPayment());
        bankTxProcessor.processPayment( 300.0);

        PaymentProcessor upiProcessor = new PaymentProcessor(new BankTransferPayment());
        upiProcessor.processPayment( 400.0);
    }
}