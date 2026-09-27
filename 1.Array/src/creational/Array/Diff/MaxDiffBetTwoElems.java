package creational.Array.Diff;

public class MaxDiffBetTwoElems {

	//complexity is o(n)
	public static void main(String[] args) {
		 int[] numArray = {2,6,1,5,10,7};
		    int max = numArray[0];
		    int min = numArray[0];
		    for( int i : numArray){ 
		      if( max < i )
		        max = i;
		      if( min > i )
		        min = i;
		    }
		System.out.println("Maximum Difference of an Array is "+(max - min ));
	}

}
