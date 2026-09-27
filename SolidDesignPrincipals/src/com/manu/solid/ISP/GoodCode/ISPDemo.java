package com.manu.solid.ISP.GoodCode;

// Client Code
public class ISPDemo {
    public static void main(String[] args) {
        OnlinePayment cardPayment = new CreditCardPayment();
        cardPayment.payOnline(100);

        RefundablePayment refundable = new CreditCardPayment();
        refundable.refund(50);

        OfflinePayment cashPayment = new CashPayment();
        cashPayment.payOffline(50);
    }
}