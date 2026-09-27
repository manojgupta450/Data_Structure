package creational.collections.sortTest;

import java.util.Comparator;

public class SortEmployeeById implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.getEid() > o2.getEid())
			return 1;
		else if(o1.getEid() < o2.getEid())
			return -1;
		else
			return 0;
	}

}
