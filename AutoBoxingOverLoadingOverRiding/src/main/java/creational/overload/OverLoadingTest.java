package creational.overload;

public class OverLoadingTest {

    public static void main(String[] args) {
        A a = new A();
        a.method();
        //Order of method calling 10 is (int, long, float, double, Integer, Number)
        a.method(10);
        //Order of method calling "Hello" String is (String, Object)
        a.method("Hello");

        System.out.println("powerOfDisposals.length" + a);

    }
}

class A {
    public void method() {
        System.out.println("No args");
    }

    public void method(int i) {
        System.out.println("int " + i);
    }

    public void method(long i) {
        System.out.println("long " + i);
    }

    public void method(float i) {
        System.out.println("float " + i);
    }

    public void method(double i) {
        System.out.println("double " + i);
    }

    public void method(Integer i) {
        System.out.println("Integer " + i);
    }

    public void method(Number i) {
        System.out.println("Number " + i);
    }

    public void method(String s) {
        System.out.println("String " + s);
    }

    public void method(Object s) {
        System.out.println("Object " + s);
    }
}