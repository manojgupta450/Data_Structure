package com.manu.solid.ISP.GoodCode;

// Cash only supports offline payments
class CashPayment implements OfflinePayment {
    @Override
    public void payOffline(double amount) {
        System.out.println("Processing offline cash payment of $" + amount + ".");
    }
}
