package com.manu.SOLID_Principles.DIP.WithDIP;

import java.io.IOException;

public class FormatException extends IOException {
	
	public FormatException(Exception cause) {
		super(cause);
	}
}
