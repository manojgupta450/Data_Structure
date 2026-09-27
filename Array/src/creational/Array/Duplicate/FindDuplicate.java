package creational.Array.Duplicate;

public class FindDuplicate
{
    // Function to find a duplicate element in a limited range array
    public static int findDuplicate(int[] A)
    {
        int duplicate = -1;
 
        // do for each element in the array
        for (int i = 0; i < A.length; i++)
        {
            // get absolute value of current element
            int absVal = (A[i] < 0) ? -A[i] : A[i];
 
            // make element at index abs(arr[i]) - 1 negative 
            // if it is positive
            if (A[absVal - 1] >= 0) {
                A[absVal - 1] = -A[absVal - 1];
            }
            else
            {
                // if element is already negative, it is repeated
                duplicate = absVal;
                break;
            }
        }
 
        System.out.println(duplicate);
        // restore original array before returning
        for (int i = 0; i < A.length; i++) {
            // make negative elements positive
            if (A[i] < 0) {
                A[i] = -A[i];
            }
        }
 
        // return duplicate element
        return duplicate;
    }
 
    // main function
    public static void main (String[] args)
    {
        // input array contains n numbers between [1 to n - 1]
        // with one duplicate, where n = A.length
        int[] A = { 1, 3, 2, 2, 4 };
 
        System.out.println("Duplicate element is " + findDuplicate(A));
    }
}