package creational.memoization.factorial;

import java.util.ArrayList;
import java.util.List;

public class Factorial {
	List<Integer> cache=new ArrayList<Integer>();
	
	public Integer calculate(int input) {
		if(input == 0)
			return 1;
		else {
			if(cache.size() >= input) {
				System.out.println("Received from cache "+input);
				return cache.get(input-1);
			}
			System.out.println("Calculated from input "+ input);
			int fact= input*calculate(input-1);
			cache.add(fact);
			return fact;
		}
		
	}
}
