package creational.singalton;

import java.io.Serializable;


//If singleton class is Serializable, you can serialize the singleton instance. Once it is serialized,
// you can deserialize it but it will not return the singleton object.
//
//To resolve this issue, you need to override the readResolve() method that enforces the singleton.
// It is called just after the object is deserialized. It returns the singleton object.
public class _7SerializedSingleton implements Serializable {
    private static final long serialVersionUID = -7604766932017737115L;

    //2. Private constructor
    private _7SerializedSingleton(){}

    //So it destroys the singleton pattern, to overcome this scenario all we need to do it provide the implementation of readResolve() method.
    protected Object readResolve() {
        return getInstance();
    }

    private static class SingletonHelper{

        ////1. Static member
        private static final _7SerializedSingleton instance = new _7SerializedSingleton();
    }

    //3. Static Factory method
    public static _7SerializedSingleton getInstance(){
        return SingletonHelper.instance;
    }

}
