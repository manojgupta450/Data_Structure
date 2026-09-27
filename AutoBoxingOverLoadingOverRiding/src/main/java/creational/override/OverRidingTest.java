package creational.override;

public class OverRidingTest {
    public static void main(String[] args) {
        //Case of overriding, hence Object type's method will be called
        // In this case Object type is B, hence B's method will be called.
        A a = new B();
        a.method();
        //Result -> B method

        //This is not a case of Overriding, since method signature is different, Hence reference type will be
        // used to call method, in this case reference type of Object C is A. Hence A's method will be called.
        //This is a case of reference call
        A a1 = new C();
        a1.method();
        //Result -> A method

        //This is a case of reference call + normal method call
        C c1 = new C();
        c1.method();
        c1.method(10);
        //Result ->
        // A method
        // C method

    }
}

class A {
    public void method() {
        System.out.println("A method");
    }

}

class B extends A {
    public void method() {
        System.out.println("B method");
    }
}

class C extends A {
    public void method(int i) {
        System.out.println("C method");
    }
}