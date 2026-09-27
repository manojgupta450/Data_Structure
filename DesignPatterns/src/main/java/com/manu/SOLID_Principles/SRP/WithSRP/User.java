package com.manu.SOLID_Principles.SRP.WithSRP;

import lombok.Data;

//User
@Data
public class User {

    private String name;

    private String email;

    private String address;

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", address=" + address + "]";
	}

    
}