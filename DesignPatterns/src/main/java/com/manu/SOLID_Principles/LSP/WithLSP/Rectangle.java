package com.manu.SOLID_Principles.LSP.WithLSP;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rectangle implements Shape {

	private int width;
	
	private int height;
	
	public int computeArea() {
		return width * height;
	}
}
