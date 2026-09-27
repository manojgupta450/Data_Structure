package creational.Array.Rearranagement;

public class Segregate0and1 {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 1, 0,0,1, 1 };
		seggregate(arr);

	}

	private static void seggregate(int[] arr) {
		int count=0;
		int temp;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				temp=arr[count];
				arr[count]=arr[i];
				arr[i]=temp;
				count++;
			}
		}
		
		for(int i:arr) {
			System.out.println(i);
		}
		
	}

}
