package creational.singalton;

public class LazySingletonTest {
    public static void main(String[] args) {
        _3LazySingleton object = _3LazySingleton.getInstance();
        System.out.println(object);

        _3LazySingleton object1 = _3LazySingleton.getInstance();
        System.out.println(object1);

        System.out.println(object.equals(object1));
    }

}
