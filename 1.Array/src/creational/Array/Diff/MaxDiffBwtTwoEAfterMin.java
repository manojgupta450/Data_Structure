package creational.Array.Diff;

/*Maximum difference between two elements such that 
larger element appears after the smaller number
Time Complexity : O(n)
Auxiliary Space : O(1)*/
public class MaxDiffBwtTwoEAfterMin {

	public static void main(String[] args) {
		MaxDiffBwtTwoEAfterMin m=new MaxDiffBwtTwoEAfterMin();
		System.out.println("Max diff : "+ m.maxDiff());

	}
	
	public int maxDiff() {
		int arr[] = {2,4,9, 3,1,5};
		int max_diff=arr[1]-arr[0];
		int min_num=arr[0];
		
		for(int i=1;i< arr.length;i++){
			if(arr[i]-min_num > max_diff) {
				max_diff = arr[i]-min_num;
			}
			if(arr[i] < min_num) {
				min_num = arr[i];
			}
			
		}
		return max_diff;
	}

}
