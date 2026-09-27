package creational.Array.Interview;

import java.util.Arrays;

public class LeadersInArray
{
    static void findTheLeaders(int inputArray[])
    {
        int inputArrayLength = inputArray.length;
 
        int max = inputArray[inputArrayLength-1];
 
        System.out.println("The leaders in "+Arrays.toString(inputArray)+" are : ");
 
        System.out.println(inputArray[inputArrayLength-1]);
        
        for (int i = inputArray.length-2; i >= 0; i--)
        {
            if(inputArray[i] > max)
            {
                System.out.println(inputArray[i]);
 
                max = inputArray[i];
            }
        }
    }
 
    public static void main(String[] args)
    {
        findTheLeaders(new int[] {12, 9, 7, 14, 8, 6, 3});
 
        findTheLeaders(new int[] {8, 23, 19, 21, 15, 6, 11});
 
        findTheLeaders(new int[] {55, 67, 71, 57, 51, 63, 38});
 
        findTheLeaders(new int[] {21, 58, 44, 14, 51, 36, 23});
    }
}
