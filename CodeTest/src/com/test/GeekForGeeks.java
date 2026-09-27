package com.test;

import java.util.Scanner;
import java.io.*;


/*3
5 5
5 3 2 6 8
6 4
2 6 4 8 1 6
4 3
2 2 2 2
*/


//in test cases given use scanner
public class GeekForGeeks {
	
	public static void main (String[] args) throws IOException {
		Scanner br=new Scanner(System.in);
		int t=br.nextInt();
		for(int i=0;i<t;i++){
		    int n=br.nextInt();
		    int k=br.nextInt();
		    int count=0;
		    int a[]=new int[n];
		    for(int j=0;j<n;j++){
		        a[j]=br.nextInt();
		    }
		    for(int j=0;j<n;j++){
		        while(a[j]>k){
		            a[j]=a[j]-k;
		            count++;
		        }
		    }
		    System.out.println(count);
	  }
	}
}