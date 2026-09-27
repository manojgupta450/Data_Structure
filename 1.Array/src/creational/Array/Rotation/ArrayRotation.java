package creational.Array.Rotation;

public class ArrayRotation {
	int arr[]= {10,2,5,1,8,6};
	final int len=arr.length;
	int arr1[]=new int [len];
	int temp;
	public static void main(String[] args) {
		ArrayRotation ar=new ArrayRotation();
		for(int i :ar.arrayRotation1()) {
		System.out.println(i);
		}
		
		for(int i :ar.arryRotation2()) {
			System.out.println(i);
			}
		
	}
	
	//Time complexity o(n)
	//Space complexity n
	public int[] arrayRotation1() {
		for (int i = 0; i < len; i++) {
			arr1[i]=arr[len-i-1];
		}
		return arr1;
	}
	

	//Time complexity o(log n)
	//Space complexity 1
	public int[] arryRotation2() {
		for (int i = 0; i < len/2; i++) {
			temp= arr[i];
			arr[i]=arr[len-i-1];
			arr[len-i-1]=temp;
		}
		return arr;
	}
	
	

}
