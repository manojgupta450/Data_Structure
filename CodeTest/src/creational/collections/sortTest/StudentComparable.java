package creational.collections.sortTest;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class StudentComparable {

	public static void main(String[] args) {
		Student s1=new Student(2, "Tanu", 10);
		Student s2=new Student(1, "Manu", 5);
		Student s3=new Student(50, "Ajay", 20);
		Student s4=new Student(20, "Vijay", 12);
		
		List<Student> lst=new LinkedList<Student>();
		lst.add(s1);
		lst.add(s2);
		lst.add(s3);
		lst.add(s4);
		
		Collections.sort(lst);
		
		for(Student s:lst) {
			System.out.println(s.sname + "  "+ s.sid);
		}

	}

}
