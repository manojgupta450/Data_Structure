package com.manu.java5.generics;

import java.util.Arrays;
import java.util.List;


//List<? extends Integer> intList = new ArrayList<>();
//List<? extends Number>  numList = intList;  // OK. List<? extends Integer> is a subtype of List<? extends Number>

//The purpose of upper bounded wildcards is to decrease the restrictions on a variable.
// It restricts the unknown type to be a specific type(same type) or a subtype of that type.
public class GenericsUpperBoundWildCardTest {
    private static Number summation (List<? extends Number> numbers){
        double sum = 0.0;
        for (Number n : numbers)
            sum += n.doubleValue();
        return sum;
    }

    public static void main(String[] args)
    {
        //Number subtype : Integer
        List<Integer>int_list = Arrays.asList(1,3,5,7,9);
        System.out.println("Sum of the elements in int_list:" + summation(int_list));

        //Number subtype : Double
        List<Double> doubles_list = Arrays.asList(1.0,1.5,2.0,2.5,3.0,3.5);
        System.out.println("Sum of the elements in doubles_list:" + summation(doubles_list));

        //Number subtype : Float
        List<Float> float_list = Arrays.asList(1.50f,1.35f,21.0f,2.25f,3.220f,3.55f);
        System.out.println("Sum of the elements in float_list:" + summation(float_list));

    }
}
