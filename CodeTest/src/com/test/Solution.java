package com.test;

import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int sum=0;
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            sum=a;
            for(int j=0;j<n;j++){
            sum=sum+((int)Math.pow(2,j)*b);
            System.out.print(sum+ " ");
        }
            System.out.println();
            sum=0;
        }
        
        in.close();
    }
}