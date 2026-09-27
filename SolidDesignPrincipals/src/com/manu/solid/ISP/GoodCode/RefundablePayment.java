package com.manu.solid.ISP.GoodCode;

// Interface for payments that support refunds
interface RefundablePayment {
    void refund(double amount);
}
