package com.manu.solid.LSP.GoodCode;

// Concrete class for a normal file (read & write)
class RegularFile implements WritableFile {
    @Override
    public void read() {
        System.out.println("Reading file...");
    }

    @Override
    public void write(String data) {
        System.out.println("Writing data: " + data);
    }
}
