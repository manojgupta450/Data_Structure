package creational.Array.Duplicate;

public class FindDuplicateMultipleRepeatedEle
{
    void printRepeating(int arr[], int size)
    {
        int i;  
        System.out.println("The repeating elements are : ");
    
        for (i = 0; i < size; i++)
        {
            if (arr[Math.abs(arr[i])] >= 0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else {
                System.out.print(Math.abs(arr[i]) + " ");
            }
        }         
    } 
 
    // Driver program 
    public static void main(String[] args) 
    {
        FindDuplicateMultipleRepeatedEle duplicate = new FindDuplicateMultipleRepeatedEle();
        int arr[] = { 1, 2, 3, 5, 3 ,3,2};
        int arr_size = arr.length;
 
        duplicate.printRepeating(arr, arr_size);
    }
}
 
// This code has been contributed by Mayank Jaiswal