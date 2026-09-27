package com.manu.java8.Lambda;

import java.util.Comparator;

public class comparePersons implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		return p1.compareTo(p2) ;
	}

}
