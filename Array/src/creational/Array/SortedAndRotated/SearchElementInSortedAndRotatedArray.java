package creational.Array.SortedAndRotated;

//https://www.youtube.com/watch?v=5BI0Rdm9Yhk
public class SearchElementInSortedAndRotatedArray {

	public static void main(String[] args) {
		int arr[]= {5,6,7,8,9,1,2,3,4};
		int indexOfEle =searchElementInSortedAndRotatedArray(arr, 0,arr.length-1,2);
		System.out.println("Index of element is "+indexOfEle);
	}
	
	//Complexity o(log n)
	public  static int searchElementInSortedAndRotatedArray(int arr[],int low,int high,int num) {
		int pivot= findPivot(arr,low,high);
		System.out.println("pivot "+pivot);
		
		if(num==arr[pivot]) {
			return pivot;
		}
		
		if(num >arr[pivot]) {
			return -1;
		}
		
		if(num >= arr[low] && num <= arr[pivot-1]) {
			 return binarySearch(arr, low, pivot-1, num);
		}else {
			return binarySearch(arr, pivot+1, high, num);
		}
		
	}

	private static int binarySearch(int[] arr, int low, int high, int num) {
		int mid=(low+high)/2;
		if(num==arr[mid])
			return mid;
		if(num >= arr[low] && num <= arr[mid-1])
			return binarySearch(arr, low, mid-1, num);
		else 
			return binarySearch(arr, mid+1, high, num);
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
