package com.test;

import java.util.HashMap;
import java.util.Scanner;

public class GFG {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
	//	System.out.println("Enter number of Test Cases: ");
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++){
		//	System.out.println("Enter the Number: ");
			int num = sc.nextInt();
		String convertedString = convertToString(num);
				if(palidrome(convertedString))
					System.out.println("YES");
				else
					System.out.println("NO");
		
	
		}
		sc.close();
	}

	private static String convertToString(int num) {
		String generatedString="";
		int l=(int)(Math.log10(num)+1);
		int copyNum=num;
		int sumNum=0;
		String substr = "";
		for(int i=0; i<l; i++){
			int temp=copyNum%10;
			sumNum=sumNum+temp;
			substr=substr+getValue(temp);
			copyNum=copyNum/10;
		}
		substr= reverse(substr);
		while(generatedString.length()!=sumNum){
			int diff= sumNum-generatedString.length();
			
				if(diff<substr.length()){
					generatedString=generatedString+substr.substring(0, diff); 
				}
				else
			generatedString=generatedString+substr;
		}
		return generatedString;
	}
	
	public static String getValue(int n){
	
		HashMap<Integer, String> hs = new HashMap<Integer, String>();
		char alphabet = 'a';
		
		for(int j=0;j<10;j++){
		hs.put(j, String.valueOf(alphabet++));
		}
		return hs.get(n);
	}
	
 public static boolean palidrome(String OriginalString) {

		char ch[] = OriginalString.toCharArray();
		int l = OriginalString.length();
		for(int i=0;i<l;i++){
			if(!(ch[i]==ch[l-(i+1)]))
				return false;
		}
		
		return true;
 }
 private static String reverse(String generatedString) {
		 if (generatedString.isEmpty())
	            return generatedString;
	        //Calling Function Recursively
	        return reverse(generatedString.substring(1)) + generatedString.charAt(0);
	   
	}
}
