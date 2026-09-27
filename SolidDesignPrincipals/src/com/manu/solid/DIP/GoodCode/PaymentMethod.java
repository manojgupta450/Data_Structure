
package com.manu.solid.DIP.GoodCode;

// High-level module depends on an abstraction (PaymentMethod), not concrete classes
interface PaymentMethod {
    void processPayment(int amount);
}