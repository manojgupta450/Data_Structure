package programs.basicOperation;

import java.util.HashSet;

public class CommonElements
{
    public static void main(String[] args)
    {
        String[] s1 = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "FOUR"};
 
        String[] s2 = {"THREE", "FOUR", "FIVE", "SIX", "SEVEN", "FOUR"};
 
        HashSet<String> set = new HashSet<String>();
 
        for (int i = 0; i < s1.length; i++)
        {
        	int l =0, h=s2.length-1;
        	
        	while(l < h) {
        		if(s1[i].equals(s2[l])) {
        			set.add(s1[i]);
        		}
        		if(s1[i].equals(s2[h])) {
        			set.add(s1[i]);
        		}
        		l++;h--;
        	}
        }
 
        System.out.println(set);     //OUTPUT : [THREE, FOUR, FIVE]
    }
}
