**Singleton Pattern**
Singleton Pattern says that just define a class that has only one instance 
and provides a global point of access to it.

**Types**
There are two forms of singleton design pattern
Early Instantiation: creation of instance at load time.
Lazy Instantiation: creation of instance when required.

**Use Case:**
Singleton pattern is mostly used in multi-threaded and database applications. 
It is used in logging, caching, thread pools, configuration settings etc.

**Advantage**
Saves memory because object is not created at each request. Only single instance is reused again and again.

**How to create Singleton design pattern**
To create the singleton class, we need to have static member of class, private constructor and static factory method.
Static member: It gets memory only once because of static, it contains the instance of the Singleton class.
Private constructor: It will prevent to instantiate the Singleton class from outside the class.
Static factory method: This provides the global point of access to the Singleton object and returns the instance to the caller.

**Significance of Classloader in Singleton Pattern**
If singleton class is loaded by two classloaders, two instance of singleton class will be created, one for each classloader.

**Significance of Serialization in Singleton Pattern**
If singleton class is Serializable, you can serialize the singleton instance. 
Once it is serialized, you can deserialize it but it will not return the singleton object.

To resolve this issue, you need to override the readResolve() method that enforces the singleton. 
It is called just after the object is deserialized. It returns the singleton object.

