package com.manu.solid.LSP.GoodCode;

// Concrete class for a read-only file (only read)
class ReadOnlyFile implements ReadableFile {
    @Override
    public void read() {
        System.out.println("Reading read-only file...");
    }
}
