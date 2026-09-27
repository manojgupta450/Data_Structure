package creational.Array.SortedAndRotated;

public class RotationCount {

	public static void main(String[] args) {
		int arr[]= {10,11,12,1,2,3,4};
		int pivot=findPivot(arr,0,arr.length-1);
		System.out.println("Rotation count of the given array is "+ (pivot+1));//location of min element is the rotation count

	}

	private static int findPivot(int[] arr, int low, int high) {
		int mid=(low+high)/2;
		if(arr[mid] > arr[mid+1])
			return mid;
		if(arr[mid] < arr[mid-1])
			return mid-1;
		if(arr[low] > arr[mid])
			return findPivot(arr, low, mid-1);
		else
			return findPivot(arr, mid+1, high);
	}

}
