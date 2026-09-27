package com.manu.exceptionHandling;

//By default Unchecked Exceptions are forwarded in calling chain (propagated).
//Exception can be handled in any method in call stack either in the main() method, p() method, n() method or m() method.
class TestExceptionPropagation1{
    void m() {
        int data=50/0;
    }
    void n() {
        m();
    }
    void p() {
        try{
            n();
        } catch(Exception e) {
            System.out.println("exception handled");
        }
    }

    public static void main(String args[]) {
        TestExceptionPropagation1 obj=new TestExceptionPropagation1();
        obj.p();
        System.out.println("normal flow...");
    }
}
