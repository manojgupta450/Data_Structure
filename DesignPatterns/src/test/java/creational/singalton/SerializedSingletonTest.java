package creational.singalton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

//The problem with serialized singleton class is that whenever we deserialize it,
// it will create a new instance of the class. Let’s see it with a simple program.
public class SerializedSingletonTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        _7SerializedSingleton instanceOne = _7SerializedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
        out.writeObject(instanceOne);
        out.close();

        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        _7SerializedSingleton instanceTwo = (_7SerializedSingleton) in.readObject();
        in.close();

        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());

    }
}
