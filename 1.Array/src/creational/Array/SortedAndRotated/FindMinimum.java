package creational.Array.SortedAndRotated;

public class FindMinimum {

	public static void main(String[] args) {
		int arr[]= {10,11,12,1,2,3,4};
		int minIndex=findMinIndex(arr,0,arr.length-1);
		System.out.println("Minimum element in the given array is "+ arr[minIndex]);//location of min element is the rotation count
	}

	private static int findMinIndex(int[] arr, int low, int high) {
		if(low > high)
			return 0;
		if(low==high) {
			return low;
		}
		int mid=(low+high)/2;
		if(arr[mid] > arr[mid+1])
			return mid+1;
		if(arr[mid] < arr[mid-1])
			return mid;
		if(arr[low] > arr[mid])
			return findMinIndex(arr, low, mid-1);
		else
			return findMinIndex(arr, mid+1, high);
	}
}
