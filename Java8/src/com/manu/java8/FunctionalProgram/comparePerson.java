package com.manu.java8.FunctionalProgram;

import java.util.Comparator;

public class comparePerson implements Comparator<Person>{
	public int compare(Person p1,Person p2) {
		return p1.compareTo(p2);
	}
}
