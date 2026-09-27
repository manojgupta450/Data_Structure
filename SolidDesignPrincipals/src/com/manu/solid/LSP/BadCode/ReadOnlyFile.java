package com.manu.solid.LSP.BadCode;

// Subclass - Violates LSP because it disables write functionality
class ReadOnlyFile extends File {
    @Override
    public void write(String data) {
        throw new UnsupportedOperationException("Cannot write to a read-only file!");
    }
}
