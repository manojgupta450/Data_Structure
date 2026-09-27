package com.manu.SOLID_Principles.LSP.WithLSP;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Square implements Shape {
	
	private int side;

	@Override
	public int computeArea() {
		return side*side;
	}
}
