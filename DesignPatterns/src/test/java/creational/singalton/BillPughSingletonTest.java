package creational.singalton;

public class BillPughSingletonTest {
    public static void main(String[] args) {
        _5BillPughSingleton object = _5BillPughSingleton.getInstance();
        System.out.println(object);

        _5BillPughSingleton object1 = _5BillPughSingleton.getInstance();
        System.out.println(object1);

        System.out.println(object.equals(object1));
    }
}
