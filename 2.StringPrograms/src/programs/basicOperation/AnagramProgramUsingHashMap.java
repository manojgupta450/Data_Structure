package programs.basicOperation;

import java.util.HashMap;

public class AnagramProgramUsingHashMap
{
    static void isAnagram(String s1, String s2){
        String str1 = s1.replaceAll("\\s", "").toLowerCase();
        String str2 = s2.replaceAll("\\s", "").toLowerCase();
 
        boolean status = true;
 
        if(str1.length() != str2.length()){
            status = false;
        }
        else{
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
 
            for (int i = 0; i < str1.length(); i++){
                char charAsKey = str1.charAt(i);
 
                int charCount= 0;
 
                if(map.containsKey(charAsKey)){
                	charCount = map.get(charAsKey);
                }
                map.put(charAsKey, ++charCount);
 
                charAsKey = str2.charAt(i);
                charCount = 0;
 
                if(map.containsKey(charAsKey)){
                	charCount = map.get(charAsKey);
                }
                map.put(charAsKey, --charCount);
            }
            
            for (int value : map.values()){
                if(value != 0)
                {
                    status = false;
                }
            }
 
        }
        if(status)
        {
            System.out.println(s1+" and "+s2+" are anagrams");
        }
        else
        {
            System.out.println(s1+" and "+s2+" are not anagrams");
        }
    }
 
    public static void main(String[] args)
    {
        isAnagram("Mother In Law", "Hitler Woman");
 
        isAnagram("keEp", "peeK");
 
        isAnagram("SiLeNt CAT", "LisTen AcT");
 
        isAnagram("Debit Card", "Bad Credit");
 
        isAnagram("School MASTER", "The ClassROOM");
 
        isAnagram("DORMITORY", "Dirty Room");
 
        isAnagram("ASTRONOMERS", "NO MORE STARS");
 
        isAnagram("Toss", "Shot");
 
        isAnagram("joy", "enjoy");
    }
}
