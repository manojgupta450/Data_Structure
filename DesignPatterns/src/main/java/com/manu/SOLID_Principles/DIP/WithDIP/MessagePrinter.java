package com.manu.SOLID_Principles.DIP.WithDIP;

import java.io.PrintWriter;

public class MessagePrinter {

	//Writes message to a file
	public void writeMessage(Message msg, Formatter formatter, PrintWriter writer) throws FormatException {

		writer.println(formatter.format(msg)); //formats and writes message
		writer.flush();

		
	}
}
