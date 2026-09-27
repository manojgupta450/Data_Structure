package creational.Array.Duplicate;

//The time complexity of above solution is O(n) and auxiliary space used by the program is O(1)
public class FindDuplicateUsingXOR
{
    // Function to find a duplicate element in a limited range array
    public static int findDuplicate(int[] A)
    {
        int xor = 0;

        // take xor of all array elements
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }

        // take xor of numbers from 1 to n-1
        for (int i = 1; i <= A.length - 1; i++) {
            xor ^= i;
        }

        // same elements will cancel out each other as a ^ a = 0,
        // 0 ^ 0 = 0 and a ^ 0 = a

        // xor will contain the missing number
        return xor;
    }

    // main function
    public static void main(String[] args)
    {
        // input array contains n numbers between [1 to n - 1]
        // with one duplicate, where n = A.length
        int[] A = { 1, 2, 3, 5, 3 };

        System.out.println("Duplicate element is " + findDuplicate(A));
    }
}
