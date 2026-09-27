package com.manu.SOLID_Principles.ISP.WithISP.entity;

import java.time.LocalDateTime;

import lombok.Data;

//Order entity class
@Data
public class Order extends Entity {

	private LocalDateTime orderPlacedOn;
	
	private double totalValue;
	
}
