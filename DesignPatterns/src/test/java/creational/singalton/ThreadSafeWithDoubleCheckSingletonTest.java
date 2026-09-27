package creational.singalton;

public class ThreadSafeWithDoubleCheckSingletonTest {

    public static void main(String[] args) {
        _4ThreadSafeWithDoubleCheckSingleton object = _4ThreadSafeWithDoubleCheckSingleton.getInstance();
        System.out.println(object);

        _4ThreadSafeWithDoubleCheckSingleton object1 = _4ThreadSafeWithDoubleCheckSingleton.getInstance();
        System.out.println(object1);

        System.out.println(object.equals(object1));
    }
}
