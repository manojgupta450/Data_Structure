package com.manu.Array;

public abstract class A {

    abstract String getDescription();
    public final String getName() {
        System.out.println(this.getDescription());
        return "Hello";
    }


}

class B extends A {
    @Override
    String getDescription() {
        return "A";
    }
}

class C extends A {
    @Override
    String getDescription() {
        return "B";
    }
}
