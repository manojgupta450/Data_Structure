
package singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Singleton implements Serializable {
 
   private static Singleton singleInstance=null;
   
   private Singleton() throws Exception {
	  // throw new Exception("You can not create more than one object(Using Reflection)");
   }
  
   public static Singleton getInstance() throws Exception {
      if (singleInstance == null) {
    	  synchronized (Singleton.class) {
    		  if (singleInstance == null) {
    				singleInstance = new Singleton();
    		  	}
    		 }
		}
      return singleInstance; 
      }
    
   public void doSomething() {
	   System.out.println("doSomething...");
   }
   
   protected Singleton readResolve() throws ObjectStreamException {
	   return singleInstance;
   }
 
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
   
    protected static Class getClass(String classname) throws ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if(classLoader == null) 
            classLoader = Singleton.class.getClassLoader();
        return (classLoader.loadClass(classname));
    }
}
class SingletonTest {

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws Exception {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = null;
        try {
            Constructor[] constructors = Singleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instance2 = (Singleton) constructor.newInstance();
                break;
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("instance1.hashCode():- " + instance1.hashCode());
        System.out.println("instance2.hashCode():- " + instance2.hashCode());

        //breaking singleton using class loaders
        URL url1 = SingletonTest.class.getClassLoader().getResource("DesignPattern_Creational.jar");
        //URL url2 = SingletonTest.class.getClassLoader().getResource("classpath:com.manu.singleton");
        URL url2 = SingletonTest.class.getClassLoader().getResource("DesignPattern_Creational.jar");

        ClassLoader cl1 = new URLClassLoader(new URL[]{url1}, null);
        ClassLoader cl2 = new URLClassLoader(new URL[]{url2}, null);
        Class<?> singClass1 = cl1.loadClass("singleton.Singleton");
        Class<?> singClass2 = cl2.loadClass("singleton.Singleton");
        //...
        Method getInstance1 = singClass1.getDeclaredMethod("getInstance");
        Method getInstance2 = singClass2.getDeclaredMethod("getInstance");
        //...
        Object singleton1 = getInstance1.invoke(null);
        Object singleton2 = getInstance2.invoke(null);

        singleton1.getClass().getMethod("doSomething").invoke(singleton1);
        singleton2.getClass().getMethod("doSomething").invoke(singleton2);
        System.out.println("instance.hashCode() singleton1:- " + singleton1.hashCode());
        System.out.println("instance.hashCode() singleton1:- " + singleton2.hashCode());

        Object instance = null;
        try {
            instance = Singleton.getClass("singleton.Singleton").getMethod("getInstance").invoke(null);
            instance.getClass().getMethod("doSomething").invoke(instance);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

        System.out.println("instance.hashCode():- " + instance.hashCode());
    }

}