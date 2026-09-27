package Test;

import java.io.IOException;
import java.util.Scanner;

import java.io.*;
public class Solution {
	static int m;static int n;
	static String arrS[][];
	static String cName[];
	static int i, j; 
	 static Scanner input = new Scanner(System.in);
	 public int solution(int N, String S) {
		 m=N;  n=10;
		     arrS= new String[N][10];
		     cName= S.split("\\S");
		     
		        String inData = new String("");
		        for (i=0; i<m; ++i) {                                   
		            for (j=0; j<n; ++j) {
		                arrS[i][j] = new String((i+1) + cName[j]);
		            }
		        }

		        do {                                                   
		            dispData();
		            if (chkFull())
		            {
		                System.out.println("Reservation is FULL");
		                inData="X";
		            }
		            else 
		            {
		                System.out.print("Enter Seat Reservation: ");
		                inData = input.next();
		                if (chkData(inData))
		                    System.out.println("Reservation Successful!");
		                else
		                    System.out.println("Occupied Seat!");
		            }       
		        } while (!inData.equalsIgnoreCase("X"));

		    
		 return N;
	 
	 }
	
   

    static void dispData() {   
        for (i=0; i<m; ++i) {
            for (j=0; j<n; ++j) {
                System.out.print(arrS[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean chkData(String vData) {  
        for (i=0; i<m; ++i) {
            for (j=0; j<n; ++j) {
                if ((arrS[i][j]).equalsIgnoreCase(vData)) {
                    arrS[i][j]="X";
                    return true;
                }
            }
        }
        return false;
    }

    static boolean chkFull() {  // Method that will check if all reservations were occupied
        for (i=0; i<m; ++i) {
            for (j=0; j<n; ++j) {
                if (!(arrS[i][j]).equals("X")) {
                    return false;
                }
            }
        }
        return true;
    }

   
}
