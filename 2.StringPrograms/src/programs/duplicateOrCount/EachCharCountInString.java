package programs.duplicateOrCount;

import java.util.HashMap;

public class EachCharCountInString
{
    static void characterCount(String inputString)
    {
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
 
        //String str =inputString.replaceAll("\\s", "");
        
        char[] strArray = inputString.toCharArray();

        for (char c : strArray)
        {
            if(charCountMap.containsKey(c))
            {
                charCountMap.put(c, charCountMap.get(c)+1);
            }
            else
            {
                charCountMap.put(c, 1);
            }
        }
 
        System.out.println(charCountMap);
    }
 
    public static void main(String[] args)
    {
       characterCount("Java J2EE Java JSP J2EE");
 
       characterCount("All Is Well");
 
       characterCount("Done And Gone");
    }
}
