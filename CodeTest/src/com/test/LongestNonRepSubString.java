package com.test;

public class LongestNonRepSubString
{
     
    static final int NO_OF_CHARS = 256;
     
    static int longestNonRepSubstr(String str)
    {
    	int curLen = 1;   
        int maxLen = 1;  
        int preIndex;
    	int n = str.length();
             
        int i;
        int visited[] = new int[NO_OF_CHARS];
        for (i = 0; i < NO_OF_CHARS; i++) {
            visited[i] = -1;
        }
        visited[str.charAt(0)] = 0;
        for(i = 1; i < n; i++)
        {
        	preIndex = visited[str.charAt(i)];
            if(preIndex == -1 || i - curLen > preIndex)
            	curLen++;
            else
            {
                if(curLen > maxLen)
                	maxLen = curLen;
                 
                curLen = i - preIndex;
            }
            visited[str.charAt(i)] = i;
        }
        if(curLen > maxLen)
        	maxLen = curLen;
         
        return maxLen;
    }
    
    public static void main(String[] args) 
    {
        String str = "Java_Java_Java_Java";
        System.out.println("The input string is "+str);
        int len = longestNonRepSubstr(str);
        System.out.println("The length of "
                + "the longest non repeating character is "+len);
    }
}

