package Test;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
   static Set<String> set=new HashSet<String>();
    public static void main(String args[]) {
    	System.out.println(solution(100));
    }
    public static int solution(int N) {
        return permute("",Integer.toString(N));
    }
    
    static int permute(String prefix, String s)
  {
    int N = s.length();

    if(!s.equals("") && Integer.parseInt(s)%100==0) {
    	return 1;
    }
    if (N == 0) {
    	set.add(prefix);}

    for (int i = 0 ; i < N ; i++)
      permute(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
      
     return set.size(); 
  }
}