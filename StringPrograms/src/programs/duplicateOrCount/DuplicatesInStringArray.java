package programs.duplicateOrCount;

import java.util.HashSet;

public class DuplicatesInStringArray {
	
    public static void main(String[] args) {
        String[] strArray = {"abc", "def", "mno", "xyz", "pqr", "xyz", "def"};
 
        HashSet<String> set = new HashSet<String>();
        for (String str : strArray){
            if(!set.add(str)){
                System.out.println("Duplicate Element is : "+str);
            }
        }
    }    
}
