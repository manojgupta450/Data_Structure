package creational.Array.Rearranagement;

//https://www.geeksforgeeks.org/maximum-product-subarray/
public class MaximumProductSubarray {

	public static void main(String[] args) {
		int arr[] = {1, -2, -3, 0, 7, -8, -2};
        System.out.println(maxProductSubArray(arr));
	}

	//o(n)
	private static int maxProductSubArray(int[] arr) {
		int max_so_far =Integer.MIN_VALUE;
		int max_end =1;
		
		for(int i=0;i<arr.length;i++) {
			max_end =max_end * arr[i];
			if(max_so_far < max_end)
				max_so_far=max_end;
			if(max_end ==0)
				max_end=1;
		}
		
		return max_so_far;
		
	}

}
