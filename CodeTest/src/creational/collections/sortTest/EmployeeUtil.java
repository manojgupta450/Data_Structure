package creational.collections.sortTest;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EmployeeUtil {

	public static void main(String[] args) {
		Employee e1=new Employee(3, "Manu", 6000L); 
		Employee e2=new Employee(2, "Tanu", 7000L);
		Employee e3=new Employee(4, "Saanu", 4000L);
		
		List<Employee> list=new LinkedList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		Iterator<Employee> it =list.iterator();
		while (it.hasNext()) {
			Employee e=it.next();
			System.out.println(e.getSname() + " "+ e.getEid());
		}
		
		Collections.sort(list ,new SortEmployeeByName());

		//After sorting by name
		Iterator<Employee> it1 =list.iterator();
		while (it1.hasNext()) {
			Employee e=it1.next();
			System.out.println(e.getSname() + " "+ e.getEid());
		}
		

		Collections.sort(list ,new SortEmployeeById());

		//After sorting by ID
		Iterator<Employee> it2=list.iterator();
		while (it2.hasNext()) {
			Employee e=it2.next();
			System.out.println(e.getEid() + " "+ e.getSname());
		}
		
	}

}
