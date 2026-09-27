package creational.array.MergeSortedArray;

public class MergeSortedArray {

	public static void main(String[] args) {
		int arr1[]= {1,4,7,9,14};
		int arr2[]= {2,5,6,8};
		int arr3[]=new int[arr1.length+arr2.length];
		int i=0,j=0,k=0;
		while(i <arr1.length && j <arr2.length) {
			if(arr1[i] <arr2[j]) {
				arr3[k]=arr1[i];
				i++;
			}else {
				arr3[k]=arr2[j];
				j++;
			}
			k++;
		}
		
		if(i <arr1.length) {
			for(int l=i;l<arr1.length;l++) {
				arr3[k]=arr1[l];
				k++;
			}
		}
		
		if(j <arr2.length) {
			for(int l=j;l<arr2.length;l++) {
				arr3[k]=arr2[l];
				k++;
			}
		}
		for (int n : arr3) {
			System.out.println(n);
		}
	}

}
