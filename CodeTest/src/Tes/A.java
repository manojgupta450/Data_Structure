package Tes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class A extends B{
	
	public void b() {
		System.out.println("a--b()");
	}
	public void a() {
		System.out.println("a");
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list=new ArrayList<Integer>();
        B bon=new A();
        //bon.a();
        
        //list.removeAll(c);
        List<B> a=new ArrayList<B>();
        a.add(new A());
        a.add(new B());
        a.add(new B());
        
        
        ArrayList<? super B> b=new ArrayList<B>();
        b.add(new B());
        b.add(new B());
        b.add(new B());
        
        
        // Super use to add the elements in the collection 
        //extends use to iterate the elements from collection 
        List<? extends Number> foo3 = new ArrayList<Number>();  // Number "extends" Number (in this context)
        List<? extends Number> foo2 = new ArrayList<Integer>(); // Integer extends Number
        List<? extends Number> foo1 = new ArrayList<Double>();
        
        foo3.add(10, null);
        
	}

}

class B{
	public void b() {
		System.out.println("b");
	}
}
