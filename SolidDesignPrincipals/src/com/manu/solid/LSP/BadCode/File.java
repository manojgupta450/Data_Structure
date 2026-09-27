package com.manu.solid.LSP.BadCode;

// Base class
class File {
    public void read() {
        System.out.println("Reading file...");
    }

    public void write(String data) {
        System.out.println("Writing data: " + data);
    }
}
