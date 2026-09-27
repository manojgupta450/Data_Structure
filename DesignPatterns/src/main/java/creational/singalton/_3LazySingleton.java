package creational.singalton;

public class _3LazySingleton {

    //1. Static member
    private static _3LazySingleton instance;

    //2. Private constructor
    private _3LazySingleton() {
    }

    //3. Static Factory method
    public static _3LazySingleton getInstance() {
        if (instance == null) {
            instance = new _3LazySingleton();
        }
        return instance;
    }

}
