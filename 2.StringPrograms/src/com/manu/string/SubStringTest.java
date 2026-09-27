package com.manu.string;

public class SubStringTest {
    public static void main(String[] args)
    {
        String s = new String("Java Technology");
        s.substring(5);
        System.out.println(s); //Java Technology
        String s2 = s.substring(6, 15);
        System.out.println(s2); //echnology
    }
}
