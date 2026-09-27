package com.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 class HackerEarth {
	
	public static void main(String args[])  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     int n = 0;
		 try {
			n = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	     
	     int arr[]=new int[n];
	     
	     for (int i = 0; i < n; i++) {
	    	 try {
	 			arr[i]=Integer.parseInt(br.readLine());
	 		} catch (Exception e) {}
		}
	     
	    for (int i = arr.length-1; i >= 0; i--) {
			System.out.println(arr[i]);
		} 
	}
	
	/*public static void main(String args[])  {
		Scanner s = new Scanner(System.in);
	     int n = 0;
		 n = s.nextInt();
		
	     
	     int arr[]=new int[n];
	     
	     for (int i = 0; i < n; i++) {
	    	 try {
	 			arr[i]=s.nextInt();
	 		} catch (Exception e) {}
		}
	     
	    for (int i = arr.length-1; i >= 0; i--) {
			System.out.println(arr[i]);
		} 
	    s.close();
	}
*/
	         
}

