package com.manu.java5.generics;

//T – Type
//E – Element (used extensively by the Java Collections Framework, for example ArrayList<E>, Set etc.)
//K – Key (Used in Map) -- Map<K,V>
//V – Value (Used in Map) -- Map<K,V>
//N – Number
//S,U,V etc. – 2nd, 3rd, 4th types
public class GenericsClassTest<T> {

    private T t;

    public GenericsClassTest(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        genericsClassTest();
    }

    private static void genericsClassTest() {
        GenericsClassTest<Integer> genericsClassTest = new GenericsClassTest<>(10);
        System.out.println(genericsClassTest.get());
        GenericsClassTest<String> genericsClassTest1 = new GenericsClassTest<>("Hello");
        System.out.println(genericsClassTest1.get());
        GenericsClassTest<Double> genericsClassTest2 = new GenericsClassTest<>(10.3949343445556632235777);
        System.out.println(genericsClassTest2.get());
        GenericsClassTest<Float> genericsClassTest3 = new GenericsClassTest<>(10.3949343445556632235777f);
        System.out.println(genericsClassTest3.get());
        GenericsClassTest<Byte> genericsClassTest4 = new GenericsClassTest<>((byte) 127); // Max = 127, Min = -128
        System.out.println(genericsClassTest4.get());
        GenericsClassTest<Short> genericsClassTest5 = new GenericsClassTest<>((short) 32767); // Max = 32767 , Min = -32768
        System.out.println(genericsClassTest5.get());
    }
}
