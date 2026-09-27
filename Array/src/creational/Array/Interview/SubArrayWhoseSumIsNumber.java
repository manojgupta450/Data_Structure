package creational.Array.Interview;

import java.util.Arrays;

public class SubArrayWhoseSumIsNumber
{
    static void findSubArray(int[] arr, int inputNumber)
    {
    	int sum = arr[0];
    	int start = 0;
 
    	for (int i = 1; i < arr.length; i++)
        {
            sum = sum + arr[i];
 
            if(sum > inputNumber && start <= i-1)
            {
                sum = sum - arr[start];
 
                start++;
            }
 
            if(sum == inputNumber)
            {
                System.out.println("Continuous sub array of "+Arrays.toString(arr)+" whose sum is "+inputNumber+" is ");
 
                for (int j = start; j <= i; j++)
                {
                    System.out.print(arr[j]+" ");
                }
 
                System.out.println();
            }
        }
    }
 
    public static void main(String[] args)
    {
        findSubArray(new int[]{42, 15, 12, 8, 6, 32}, 26);
 
        findSubArray(new int[]{12, 5, 31, 13, 21, 8}, 49);
 
        findSubArray(new int[]{15, 51, 7, 81, 5, 11, 25}, 41);
    }
}
