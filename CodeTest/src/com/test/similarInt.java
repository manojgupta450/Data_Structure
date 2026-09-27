package com.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;
public class similarInt {

    public static void main(String[] args) throws IOException {
      
        int[] p = {1};

        int res = getUmbrellas(4, p);

    }
        // Complete the getUmbrellas function below.
        static int getUmbrellas(int n, int[] p) {
            int min=0;
            int max=0;
            int count=0;
            n=1;
            PriorityQueue<Integer> q=new PriorityQueue<>();
            
            for(int i=0;i<p.length;i++){
            	int temp=n;
                while(temp!=1){
                    if(temp%p[i]==0){
                    	temp=temp/p[i];
                        count++;
                    }
                  
                }
                
                if(n==1 && p[i]==1) {
                	q.add(1);
                }else
                	q.add(count);
                count=0;
            }
            int num=q.peek();
            if(num >0) {
            	return num;
            }
            
            return -1;

        }


}
