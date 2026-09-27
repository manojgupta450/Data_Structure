package com.manu.solid.LSP.GoodCode;

// Client Code
public class LSPDemo {
    public static void main(String[] args) {
        ReadableFile file1 = new RegularFile();
        ReadableFile file2 = new ReadOnlyFile();

        file1.read();  // Works fine
        file2.read();  // Works fine

        WritableFile writableFile = new RegularFile();
        writableFile.write("Hello, World!"); // Works fine
    }
}