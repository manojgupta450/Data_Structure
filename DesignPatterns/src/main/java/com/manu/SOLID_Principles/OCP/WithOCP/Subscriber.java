package com.manu.SOLID_Principles.OCP.WithOCP;

import lombok.Data;

//base class - closed for modification
@Data
public abstract class Subscriber {
	
	protected Long subscriberId;

	protected String address;

	protected Long phoneNumber;
	
	protected int baseRate;

	public abstract double calculateBill(); //extension
    
}
