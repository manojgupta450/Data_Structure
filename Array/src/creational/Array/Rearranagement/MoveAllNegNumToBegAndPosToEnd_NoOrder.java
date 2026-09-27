package creational.Array.Rearranagement;

//Move all negative numbers to beginning and positive to end
//https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/
public class MoveAllNegNumToBegAndPosToEnd_NoOrder {

	public static void main(String[] args) {
		int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
		rearrange(arr);
	}

	private static void rearrange(int[] arr) {
		int temp;int count=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] < 0) {
				temp=arr[i];
				arr[i]=arr[count];
				arr[count]=temp;
				count++;
			}
		}
		
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
	}

}
