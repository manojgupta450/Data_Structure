package creational.singalton;

public class EagerSingletonTest {
    public static void main(String[] args) {
        _0EagerSingleton object = _0EagerSingleton.getInstance();
        System.out.println(object);

        _0EagerSingleton object1 = _0EagerSingleton.getInstance();
        System.out.println(object1);

        System.out.println(object.equals(object1));
    }
}
