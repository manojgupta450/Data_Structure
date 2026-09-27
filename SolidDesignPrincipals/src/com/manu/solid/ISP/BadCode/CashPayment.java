package com.manu.solid.ISP.BadCode;

// Cash supports only offline payments, but no online payments or refunds
class CashPayment implements Payment {
    @Override
    public void payOnline(double amount) {
        throw new UnsupportedOperationException("Cash payment does not support online payments.");
    }

    @Override
    public void payOffline(double amount) {
        System.out.println("Processing offline cash payment of $" + amount + ".");
    }

    @Override
    public void refund(double amount) {
        throw new UnsupportedOperationException("Cash payment does not support refunds.");
    }
}
