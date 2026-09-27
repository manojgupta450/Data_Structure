package com.manu.regular.exp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String []args) {
        Pattern pattern = Pattern.compile(".s"); //. represents any single character and ending with s
        Matcher matcher = pattern.matcher("as"); //true
        Matcher matcher1 = pattern.matcher("ak"); //false
        System.out.println(matcher.matches());
        System.out.println(matcher1.matches());

        System.out.println(Pattern.matches(".s", "as"));//true (2nd char is s)
        System.out.println(Pattern.matches(".s", "mk"));//false (2nd char is not s)
        System.out.println(Pattern.matches(".s", "mst"));//false (has more than 2 char)
        System.out.println(Pattern.matches(".s", "amms"));//false (has more than 2 char)
        System.out.println(Pattern.matches("..s", "mas"));//true (3rd char is s)

        System.out.println("==================================");

        System.out.println(Pattern.matches("[amn]", "abcd"));//false (not a or m or n)
        System.out.println(Pattern.matches("[amn]", "a"));//true (among a or m or n)
        System.out.println(Pattern.matches("[amn]", "m"));//true (among a or m or n)
        System.out.println(Pattern.matches("[amn]", "am"));//false (among a or m or n)
        System.out.println(Pattern.matches("[amn]", "ammmna"));//false (m and a comes more than once)

        System.out.println("==================================");

        System.out.println(Pattern.matches("[abc]", "a"));//true a or b, or c (simple class)
        System.out.println(Pattern.matches("[^abc]", "f"));//true Any character except a, b, or c (negation)
        System.out.println(Pattern.matches("[a-zA-Z]", "B"));//true a through z or A through Z, inclusive (range)
        System.out.println(Pattern.matches("[a-d[m-p]]", "e"));//false a through d, or m through p: [a-dm-p] (union)
        System.out.println(Pattern.matches("[a-z&&[def]]", "b"));//false d, e, or f (intersection)
        System.out.println(Pattern.matches("[a-z&&[def]]", "e"));//true d, e, or f (intersection)
        System.out.println(Pattern.matches("[a-z&&[^bc]]", "e"));//true a through z, except for b and c: [ad-z] (subtraction)
        System.out.println(Pattern.matches("[a-z&&[^m-p]]", "q"));//true a through z, and not m through p: [a-lq-z](subtraction)


    }
}
