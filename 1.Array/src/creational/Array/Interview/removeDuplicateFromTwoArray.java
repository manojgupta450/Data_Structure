package creational.Array.Interview;

public class removeDuplicateFromTwoArray {
	
	public static void main(String arr[]) {
	int arr1[] = {1,5,7,8};
	int arr2[] = {3,4,6,7,8,9};
	int res[] = merge(arr1,arr2);
	for(int i:res) {
		System.out.println(i);	
	}
	
	}
	
	public static int[] merge(int[] list1, int[] list2) {
	    int[] result = new int[list1.length + list2.length];

	    int i = 0;
	    int j = 0;

	    for (int k = 0; k < (list1.length + list2.length); k++) {
	        if (i >= list1.length) {
	            result[k] = list2[j];
	            j++;
	        } 
	        else if (j >= list2.length) {
	            result[k] = list1[i];
	            i++;
	        } 
	        else {
	            if (list1[i] < list2[j]) {
	                result[k] = list1[i];
	                i++;
	            } else {
	                result[k] = list2[j];
	                j++;
	            }
	        }
	    }
	    return result;
	}

}
