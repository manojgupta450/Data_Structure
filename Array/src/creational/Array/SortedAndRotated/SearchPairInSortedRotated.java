package creational.Array.SortedAndRotated;

public class SearchPairInSortedRotated {
	//Complexity o(log n)
	public static void main(String[] args) {
		int arr[] = {7,8,9,10,11,1,2,3,4,5,6};
		
		System.out.println(pairInSortedRotated(arr,0, arr.length-1 ,16));
	}

	private static boolean pairInSortedRotated(int[] arr, int low, int high,int sum) {
		int n=arr.length;
		int pivot=findPivot(arr,low,high);
		low=pivot+1;//minimum element 
		high=pivot; //maximum element
		
		
		while(low!=high) {
			if (arr[low] + arr[high] == sum) {
				return true;
			}
			if (arr[low] + arr[high] < sum) {
				low = (low + 1) % n;
			} else {
				high = (n + high - 1) % n;
			}
		}
		return false;
		
	}
	private static int findPivot(int[] arr, int low, int high) {
		int mid = (low+high)/2;
		if(arr[mid]>arr[mid+1]) {
			return mid;
		}
		
		if(arr[mid]<arr[mid-1]) {
			return mid-1;
		}
		
		if(arr[low] > arr[mid]) {
			high=mid-1;
			return findPivot(arr, low, high);
		}else {
			low=mid+1;
			return findPivot(arr, low, high);
		}
	}
	

}
