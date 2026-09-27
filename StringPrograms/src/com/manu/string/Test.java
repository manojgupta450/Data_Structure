package com.manu.string;

public class Test {


    public static void main(String[] args) {

        System.out.println("********equals*********");
        String sstr1 = "Hello";
        String sstr2 = "Hello";
        String sstr3 = new String("Good bye");
        String sstr4 = new String("Hello");

        System.out.println(sstr1.equals(sstr2)); //true
        System.out.println(sstr1.equals(sstr3)); //false

        System.out.println(sstr1.equals(sstr4)); //true
        System.out.println(sstr1.equals(args)); //false
        System.out.println(sstr1.equals(null)); //false

        String ss1 = "GOOD BYE";
        String ss2 = new String("Good bye");

        System.out.println(ss1.equals(ss2)); //false
        System.out.println(ss1.equalsIgnoreCase(ss2)); //true

        System.out.println("*********==********");
        String s1 = "Cricket";
        String s2 = "Cricket";
        String s3 = new String("Cricket");

        System.out.println(s1==s2); //true
        System.out.println(s1==s3); //false

        System.out.println("*********CompareTo********");
        String str1 = "Nanoj";
        String str2 = "Manoj12";
        System.out.println(str1.compareTo(str2)); //1

        String st1 = "Ivaan";
        String st2 = "Hilery";
        String st3 = "Ivaan";
        String st4 = new String("Ivaan");
        System.out.println(st1.compareTo(st2)); //1
        System.out.println(st1.compareTo(st3)); //0
        System.out.println(st3.compareTo(st1)); //0
        System.out.println(st2.compareTo(st4)); //-1
    }
}
