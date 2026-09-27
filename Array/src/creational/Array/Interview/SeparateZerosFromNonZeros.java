package creational.Array.Interview;

import java.util.Arrays;

public class SeparateZerosFromNonZeros
{
    static void moveZerosToEnd(int arr[])
    {
    	int i=0, j=arr.length-1,temp;
    	while(i<j) {
    		while (arr[j] ==0) {
				j--;
			}
    		while (arr[i] !=0) {
				i++;
			}
    		temp=arr[j];
    		arr[j]=arr[i];
    		arr[i]=temp;
    		i++;
    		j--;
    	}
    	
    	System.out.println(Arrays.toString(arr));
    }
 
    public static void main(String[] args)
    {
        moveZerosToEnd(new int[] {12, 0, 7, 0, 8, 0, 3});
 
        moveZerosToEnd(new int[] {1, -5, 0, 0, 8, 0, 1});
 
        moveZerosToEnd(new int[] {0, 1, 0, 1, -5, 0, 4});
 
        moveZerosToEnd(new int[] {-4, 1, 0, 0, 2, 21, 4});
    }
}
