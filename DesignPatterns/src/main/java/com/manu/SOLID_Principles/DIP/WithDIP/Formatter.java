package com.manu.SOLID_Principles.DIP.WithDIP;

import java.io.IOException;

public interface Formatter {
	
	public String format(Message message) throws FormatException;
	
}
