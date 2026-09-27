package creational.Array.Rearranagement;

// Replace every array element by multiplication of previous and next
public class ReplaceEleByMulOfPreAndNext {

	public static void main(String[] args) {
		int arr[] = {2, 3, 4, 5, 6};
		modify(arr);

	}

	private static void modify(int[] arr) {
		int pre=arr[0];int mul;
		for(int i=0; i<arr.length;i++) {
			if(i==0)
				arr[i]=arr[i]*arr[i+1];
			else if(i==arr.length-1)
				arr[i]=pre*arr[i];
			else {
				mul=pre*arr[i+1];
				pre=arr[i];
				arr[i]=mul;
				}
		}
		
		for(int i:arr) {
			System.out.println(i);
		}
		
	}

}
