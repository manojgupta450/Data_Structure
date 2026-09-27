package creational.autobox;

public class AutoBoxOverRidingOverLoading {
    public static void main(String[] args) {

        System.out.println("1..=================");
        //This is not a case of overriding since method doesn't have similar arguments,
        // hence based on reference type method will be called, in this case reference type of object B1 is A1
        //Conclusion if there is overriding then reference type will be used to method call.
        A1 a = new B1();
        a.method(new Integer(10));
        a.method(10);

        System.out.println("2..=================");

        //Case of overloading, A1 method will be overridden in B1 class
        B1 b = new B1();
        b.method(new Integer(10));
        b.method(10);

        System.out.println("3..=================");
        //1st case +
        //Case of overloading, Note: Number will be called if there io no int or Integer
        B1 a1 = new C1();
        a1.method(new Integer(10));
        a1.method(10);

        System.out.println("4..=================");
        //This is pure case of overriding, hence Object type method will be called
        //In this case Object type is E1 hence E1's method will be called
        A1 e1 = new E1();
        e1.method(new Integer(10));
        e1.method(10);

        System.out.println("5..=================");

        //Specialisation test
        //Case of Specialisation order of execution is (int, long, float, double, Integer, Number)
        D1 d = new D1();
        d.intMethod(10);
        d.intMethod(new Integer(10));
    }

}

class A1 {
    public void method(int i) {
        System.out.println("A1 int");
    }
}

class B1 extends A1 {
    public void method(Integer i) {
        System.out.println("B1 Integer");
    }
}

class C1 extends B1 {
    public void method(Number i) {
        System.out.println("C1 Number");
    }
}

class E1 extends A1 {
    public void method(int i) {
        System.out.println("E1 int");
    }
}

class D1 {

    public void intMethod(Number i) {
        System.out.println("D1 Number");
    }

    public void intMethod(Integer i) {
        System.out.println("D1 Integer");
    }

    public void intMethod(int i) {
        System.out.println("D1 int");
    }

    public void intMethod(Long i) {
        System.out.println("D1 Long");
    }

    public void intMethod(long i) {
        System.out.println("D1 long");
    }

    public void intMethod(Double i) {
        System.out.println("D1 Double");
    }

    public void intMethod(double i) {
        System.out.println("D1 double");
    }

    public void intMethod(short i) {
        System.out.println("D1 short");
    }

    public void intMethod(Short i) {
        System.out.println("D1 Short");
    }

    public void intMethod(float i) {
        System.out.println("D1 float");
    }

    public void intMethod(Float i) {
        System.out.println("D1 float");
    }

}

        //Result

        /*1..=================
        A1 int
        A1 int
        2..=================
        B1 Integer
        A1 int
        3..=================
        B1 Integer
        A1 int
        4..=================
        E1 int
        E1 int
        5..=================
        D1 int
        D1 Integer*/

