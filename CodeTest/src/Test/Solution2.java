package Test;

import java.io.IOException;
import java.util.Scanner;

import java.io.*;
public class Solution2 {

	
    static Scanner input = new Scanner(System.in);
    static int m=1;static int n=10;
    static String arrS[][] = new String[m][n];
    static String cName[] = {"A","B","C","D"};
    static int sum = 0;

    static int i, j;            // Loop Control Variables

    static boolean chkData(String vData) {  // Method that will check for reservation availability
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

    public static void main(String eds[]) throws IOException {  // the MAIN method program
        String inData = new String("");
       int len= cName.length;
        for (i=0; i<m; ++i) {                                   // Initialized array with constant data
            for (j=0; j<n; ++j) {
            	if(len > 0) {
                arrS[i][j] = new String((i+1) + cName[j]);
                len--;
                }
            }
        }

        
        if (chkFull())
        {
            System.out.println("Reservation is FULL");
            inData="X";
        }
        else 
        {
         int c=0;
         boolean flag=false;
         
        	for (i=0; i<m; ++i) {                                   // Initialized array with constant data
                for (j=0; j<n; ++j) {
                	if(arrS[i][j] ==null) {
             
                    		c++;
                    	
                    	
                    }
                    if(c !=0 && c%3==0)
                    	sum=sum+1;
                    
                    
                }
                c=0;
            }
        }       
    
System.out.println(sum);
    }   
}
