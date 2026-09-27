package com.manu.java8.Lambda;

import java.time.LocalDate;
import java.time.LocalTime;

public class FluentInterfaceExample {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println("Today is: " + today);
	
		LocalDate futureDate1 = LocalDate.now()
				.plusYears(2)
				.minusMonths(1)
				.plusDays(3);
		System.out.println("New Date with fluent interface:  " + futureDate1);
		
		LocalTime curTime = LocalTime.now();
		LocalTime breakTime = curTime.plusMinutes(90);
		System.out.printf("Cur time is - %s Break is at - %s ", curTime, breakTime);
		

	}

}
