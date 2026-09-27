package creational.Array.Rearranagement;


//https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
public class LargestSumContiguousSubarray {

	public static void main(String[] args) {
		int arr[] = {10, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(largestSum(arr));
	}

	private static int largestSum(int[] arr) {
		int max_so_far=Integer.MIN_VALUE;
		int maxDiff=0;
		for(int i=0;i<arr.length;i++) {
			maxDiff=maxDiff+arr[i];
			if(max_so_far < maxDiff) {
				max_so_far=maxDiff;
			}
			if (maxDiff < 0) {
				maxDiff=0;
			}
		}
		return max_so_far;
	}
	
	//o(n)
	static int maxSubArraySum(int a[])
    {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
 
        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

}
