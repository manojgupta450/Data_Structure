package creational.singalton;


/*
Prior to Java 5, java memory model had a lot of issues and the above approaches used to fail in certain scenarios
where too many threads try to get the instance of the Singleton class simultaneously.
So Bill Pugh came up with a different approach to create the Singleton class using an inner static helper class.
The Bill Pugh Singleton implementation goes like this;
*/

/*
Notice the private inner static class that contains the instance of the singleton class. When the singleton class is loaded,
SingletonHelper class is not loaded into memory and only when someone calls the getInstance method,
this class gets loaded and creates the Singleton class instance.
This is the most widely used approach for Singleton class as it doesn’t require synchronization.
*/

public class _5BillPughSingleton {

    private _5BillPughSingleton() {}

    private static class SingletonHelper {
        private static final _5BillPughSingleton INSTANCE = new _5BillPughSingleton();
    }

    public static _5BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
