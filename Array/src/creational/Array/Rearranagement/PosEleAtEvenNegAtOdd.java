package creational.Array.Rearranagement;

public class PosEleAtEvenNegAtOdd {

	public static void main(String[] args) {
		int arr[] = { 1, -3, 5, 6, -3, 6, 7, -4, 9, 10 };
		rearrange(arr);

	}

	//o(n)
	private static void rearrange(int[] arr) {
		int even=0;
		int odd=1;
		int temp;
		int n=arr.length;
		for(int i=0;i<n;i++) {
			while (even < n && arr[even] >= 0)
				even += 2;
			while (odd < n && arr[odd] <= 0)
				odd += 2;
			if(even < n && odd < n) {
				temp=arr[even];
				arr[even]=arr[odd];
				arr[odd]=temp;
			}else
		        break;
		}
		
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
		
	}

}