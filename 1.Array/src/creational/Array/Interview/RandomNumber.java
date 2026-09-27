package creational.Array.Interview;

import java.util.Random;

public class RandomNumber
{
    public static void main(String[] args)
    {
        Random random = new Random();
 
        for(int i = 0; i < 5; i++)
        {
            System.out.println("Random Integers : "+random.nextInt());
        }
 
        System.out.println("-----------------------------");
 
        //Generating random doubles using Random class
 
        for(int i = 0; i < 5; i++)
        {
            System.out.println("Random Doubles : "+random.nextDouble());
        }
 
        System.out.println("-----------------------------");
 
        //Generating random booleans using Random class
 
        for(int i = 0; i < 5; i++)
        {
            System.out.println("Random booleans : "+random.nextBoolean());
        }
    }
}
