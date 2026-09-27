package Tes;

public class PumpkinDemo {
	 
    public static void main(String[] args){
        Parent p = new Child();
        p.testMethod(0);
    }
}
 
class Parent{
    public void testMethod(Number n)
    {
        System.out.println("Parent");
    }
}
 
class Child extends Parent{
    public void testMethod(Integer n) 
    {
        System.out.println("Child");
    }
}
