package com.manu.java8.FunctionalProgram;

public class Person implements Comparable<Person>{
	int id;
	String firstName;
	String lastName;
	int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Person() {
	}
	public Person(int id, String firstName, String lastName, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	@Override
	public int compareTo(Person o) {
		return age;
		
	}
	
	/*public static void main(String args[]) {
		Person p1=new Person(1, "Manu", "Gupta", 20);
		Person p2=new Person(2, "Tanu", "upta", 30);
		ArrayList<Person> ap=new ArrayList<Person>();
		ap.add(p1);
		ap.add(p2);
		Arrays.sort(ap);
	}*/
	
}
