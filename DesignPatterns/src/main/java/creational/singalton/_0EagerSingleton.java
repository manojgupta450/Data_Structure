package creational.singalton;

public class _0EagerSingleton {

    //1. static member
    private static final _0EagerSingleton instance = new _0EagerSingleton();

    //2. private constructor to avoid client applications to use constructor
    private _0EagerSingleton() {
    }

    //3. public static Factory method for global access point.
    public static _0EagerSingleton getInstance() {
        return instance;
    }

}
