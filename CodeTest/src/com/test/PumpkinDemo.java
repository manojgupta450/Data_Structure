package com.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PumpkinDemo {
	 
	public static void main(String[] args) {
		Hello h=new Hello();
		h.get(1);
		Map<Integer,Character> map=new HashMap<Integer,Character>();
		Set<Entry<Integer, Character>> e=map.entrySet();
		Set<Character> e2=(Set<Character>) map.values();
		Iterator<Entry<Integer,Character>> it=e.iterator();
		while (it.hasNext()) {
			Entry<Integer, Character> e1=it.next();
			e1.getKey();
			e1.getValue();
			
		}
		
    }
     
   
    
}

class Hello{
	String h;
	String n;
	
	void get(int i) {
		String s=1 + " ";
		String s1=i + " ";
		System.out.println();
	}
}