package com.manu.string;

public class StringConTest {
    public static void main(String[] args)
    {
        String s1 = "Java";
        s1.concat("Programming");
        System.out.println(s1);

        String s2 = "Java";
        s2 = s2.concat("Programming");
        System.out.println(s2);

        String s21 = 25 + 25 + " Text " + 1 + 4;
        String s22 = new String("Text2");
        System.out.println(s21); //50 Text 14
        System.out.println(s21.concat(s22)); //50 Text 14Text2
    }
}
