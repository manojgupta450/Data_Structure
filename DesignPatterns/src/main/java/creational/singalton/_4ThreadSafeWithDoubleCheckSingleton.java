package creational.singalton;

public class _4ThreadSafeWithDoubleCheckSingleton {

    private static volatile _4ThreadSafeWithDoubleCheckSingleton instance = null;

    private _4ThreadSafeWithDoubleCheckSingleton() {
    }

    public static _4ThreadSafeWithDoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (_4ThreadSafeWithDoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new _4ThreadSafeWithDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

}
