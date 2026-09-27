package creational.Array.Rotation;

public class LeftArrayRotationByDElements {
	
	int temp[] ;
	public LeftArrayRotationByDElements(int d) {
		temp=new int[d];
	}
	public static void main(String[] args) {
		LeftArrayRotationByDElements ar=new LeftArrayRotationByDElements(2);
		//int arr[]= {10,2,5,1,8,6};
		int arr[]= {1,2,3,4,5,6,7,8,9,10,11,12};
		
		//ar.rotateUsingTempArray(arr,2);
		
		//ar.rotateOneByOne(arr,2);
		
		ar.rotateUsingGCD(arr,3);
		
		//ar.rotateUsingReverse(arr, 3);
		
		
		
		for(int i:arr) {
			System.out.println(i);
		}
		
	}
	
	/*Time complexity : O(n)
	Auxiliary Space : O(d)*/
	public void rotateUsingTempArray(int []arr,int d) {
		int count=0;
		for(int i=0;i< arr.length;i++) {
			if(i<d) {
				temp[i]=arr[i];
			}
			if(i<arr.length-d) {
				arr[i]=arr[i+d];
			}else {
				arr[i]=temp[count];
				count++;
			}
		}
	}
	
	/*Time complexity : O(n * d)
	Auxiliary Space : O(1)*/
	public void rotateOneByOne(int []arr,int d) {
		int temp;
		for(int i=0;i<d ;i++) {
			temp=arr[0];
			int j;
			for(j=1;j<arr.length;j++) {
				arr[j-1]=arr[j];
			}
			arr[j-1]=temp;
		}
			
	}
	
	/*
	Time complexity : O(n)
	Auxiliary Space : O(1)*/
	public void rotateUsingGCD(int []arr,int d) {
		//j is previous
		//k next set
		int len=arr.length,i,j,k,temp;
		for(i=0;i<GCD(d,len);i++) {
			temp=arr[i];
			j=i;
			while(true) {
				k=j+d;
				if(k>=len) 
					k=k-len;
				if(k==i)
					break;
				arr[j]=arr[k];
				j=k;
			}
			arr[j]=temp;
		}	
		
	}
	public int GCD(int a,int b) {
		if(b==0)
		return a;
		else {
			return GCD(b,a%b);
		}
	}
		
	/*
	Time complexity : O(n)
	Auxiliary Space : O(1)*/
	public void rotateUsingReverse(int []arr,int d) {
		reverse(arr, 0, d-1);
		reverse(arr, d, arr.length-1);
		reverse(arr, 0, arr.length-1);
	}
	
	public static void reverse(int arr[],int min,int max) {
		int temp;
		while(max > min ) {
			temp=arr[min];
			arr[min]=arr[max];
			arr[max]=temp;
			min++;
			max--;
		}
	}
	
	
}
