package creational.Array.Rotation;


/*Find element at given index after a number of rotations
 * Input : arr[] : {1, 2, 3, 4, 5}
        ranges[] = { {0, 2}, {0, 3} }
        index : 1
	Output : 3
	Explanation : After first given rotation {0, 2}
                arr[] = {3, 1, 2, 4, 5}
              After second rotation {0, 3} 
                arr[] = {4, 3, 1, 2, 5}
	After all rotations we have element 3 at given
	index 1. 
 * */
public class FindElementAfterANumberOfRotation
{
    // Function to compute the element at
    // given index
    static int findElement(int[] arr, int[][] ranges,
                            int rotations, int index)
    {
        for (int i = rotations - 1; i >= 0; i--) {
 
            // Range[left...right]
            int left = ranges[i][0];
            int right = ranges[i][1];
 
            // Rotation will not have any effect
            if (left <= index && right >= index) {
                if (index == left)
                    index = right;
                else
                    index--;
            }
        }
 
        // Returning new element
        return arr[index];
    }
 
    // Driver
    public static void main (String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
 
        // No. of rotations
        int rotations = 2;
     
        // Ranges according to 0-based indexing
        int[][] ranges = { { 0, 2 }, { 0, 3 } };
 
        int index = 1;
        System.out.println(findElement(arr, ranges,
                                 rotations, index));
    }
}