package com.manu.solid.ISP.BadCode;

// Large interface forcing all payment types to implement unnecessary methods
interface Payment {
    void payOnline(double amount);

    void payOffline(double amount);

    void refund(double amount);
}
