package creational.Array.Rearranagement;


public class SeggregateEvenAndOdd {
	
	//o(n)
	public static void seggregate(int arr[]) {
		int count=0;
		int temp;
		for(int i=0;i< arr.length;i++) {
			if(arr[i]%2==0) {
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
	
	//o(n/2)
	static void arrayEvenAndOdd(int arr[], int n) 
    {
        // To store result
        int b[] = new int[n]; 
        int k = 0, l = n - 1, i, j;
        for (i = 0, j = n - 1; i < j; i++, j--) 
        {
         
            if (arr[i] % 2 == 0) 
            {
                b[k] = arr[i];
                k++;
            } 
            else
            {
                b[l] = arr[i];
                l--;
            }
         
            if (arr[j] % 2 == 0)
            {
                b[k] = arr[j];
                k++;
            } 
            else
            {
                b[l] = arr[j];
                l--;
            }
        }
     
        // for i == j in case of odd length
        b[i] = arr[i];
         
        // Printing segregated array
        for (i = 0; i < n; i++) 
        {
            System.out.print(b[i] + " ");
        }
    }
     
	
	public static void main(String args[]) {
		int arr[] = { 1, 3, 2, 4, 7, 6, 9, 10 };
		seggregate(arr);
	}
}
