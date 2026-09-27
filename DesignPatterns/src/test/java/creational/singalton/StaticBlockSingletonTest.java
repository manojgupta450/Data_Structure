package creational.singalton;

public class StaticBlockSingletonTest {

    public static void main(String[] args) {
        _1StaticBlockSingleton object = _1StaticBlockSingleton.getInstance();
        System.out.println(object);

        _1StaticBlockSingleton object1 = _1StaticBlockSingleton.getInstance();
        System.out.println(object1);

        System.out.println(object.equals(object1));

    }


}
