package creational.Array.Duplicate;

public class FindDuplicateWithSpace {

	public static void main(String[] args) {
		int arr[]= {1,2,3,3,3,2,5,4,2,6};
		int[] tempA=new int[arr.length];
		
		for(int i=0;i<arr.length;i++) {
			tempA[arr[i]]++;
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("Number "+ i +" appered "+ tempA[i] +" times" );
		}
	}

}
