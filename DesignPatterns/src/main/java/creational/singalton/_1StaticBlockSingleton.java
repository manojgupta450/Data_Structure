package creational.singalton;

public class _1StaticBlockSingleton {

    private static _1StaticBlockSingleton instance = null;

    private _1StaticBlockSingleton() {
    }

    static {
        if (instance == null) {
            instance = new _1StaticBlockSingleton();
        }
    }

    public static _1StaticBlockSingleton getInstance() {
        return instance;
    }
}
