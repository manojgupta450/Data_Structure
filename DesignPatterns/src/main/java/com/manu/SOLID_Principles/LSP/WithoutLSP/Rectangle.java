package com.manu.SOLID_Principles.LSP.WithoutLSP;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Rectangle {

	private int width;
	
	private int height;

	public int computeArea() {
		return width * height;
	}
}
