package com.manu.solid.DIP.BadCode;

// Client Code
public class DIPViolationExample {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.checkout("credit", 100); // Hardcoded dependency
    }
}