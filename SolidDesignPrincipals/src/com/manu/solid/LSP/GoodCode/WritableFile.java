package com.manu.solid.LSP.GoodCode;

// Interface for writable files
interface WritableFile extends ReadableFile {
    void write(String data);
}
