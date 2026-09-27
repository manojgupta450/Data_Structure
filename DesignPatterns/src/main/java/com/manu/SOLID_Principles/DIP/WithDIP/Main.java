package com.manu.SOLID_Principles.DIP.WithDIP;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws FormatException, FileNotFoundException {
		
		Message msg = new Message("This is a message again");
		MessagePrinter printer = new MessagePrinter();


		//DIP :- Here high level module doesn't depend on low level (JSONFormatter) module to be modified, if need
		// different formatter we can write a new one without modifying existing formatter
		try(PrintWriter writer = new PrintWriter(System.out)) {
			printer.writeMessage(msg, new JSONFormatter(), writer);
		}

		try(PrintWriter stringWriter = new PrintWriter("/Users/manojgupta/Desktop/encodedfile.txt")) {
			printer.writeMessage(msg, new TextFormatter(), stringWriter);
		}

	}

}
