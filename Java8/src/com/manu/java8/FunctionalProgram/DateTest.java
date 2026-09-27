package com.manu.java8.FunctionalProgram;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class DateTest {

	public static void main(String[] args) {
		LocalDateTimes();

	}
	
	private static void LocalDateTimes() {
		LocalDate today = LocalDate.now();
		System.out.println("TOday's date is : "+ today);
		LocalDate valentinesday=LocalDate.of(2016, Month.FEBRUARY, 14);
		System.out.println("valentinesday is on :" + valentinesday);
		
		LocalTime currTime= LocalTime.now();
		System.out.println("Current time is : "+ currTime);
		System.out.println("End of day Process at : "+ LocalTime.of(22, 30));
		long hours=6;
		long minutes=30;
		long secs=40;
		long nanos=12345233L;
		currTime =LocalTime.now();
		System.out.println("Meeting at" + currTime.plusHours(hours).plusMinutes(minutes).plusSeconds(secs).plusNanos(nanos));
		System.out.println();
	}

}
