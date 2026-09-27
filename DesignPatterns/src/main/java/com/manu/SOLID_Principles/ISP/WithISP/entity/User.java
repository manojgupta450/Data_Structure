package com.manu.SOLID_Principles.ISP.WithISP.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class User extends Entity {
	
	private String name;
	
	private LocalDateTime lastLogin;
}
