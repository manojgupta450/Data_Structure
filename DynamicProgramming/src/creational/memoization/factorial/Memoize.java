package creational.memoization.factorial;

public class Memoize {

	public static void main(String[] args) {
		Factorial fact=new Factorial();
		System.out.println("Factorial of 3");
		System.out.println(fact.calculate(3));
		System.out.println("*************");
		System.out.println("Factorial of 4");
		System.out.println(fact.calculate(4));
		System.out.println("*************");
		System.out.println("Factorial of 7");
		System.out.println(fact.calculate(7));
	}

}
