package com.manu.solid.LSP.BadCode;

// Client Code
public class LSPViolationDemo {
    public static void main(String[] args) {
        File file = new ReadOnlyFile();
        file.read();  // Works fine
        file.write("Hello, World!");  // Throws exception, violating LSP
    }
}