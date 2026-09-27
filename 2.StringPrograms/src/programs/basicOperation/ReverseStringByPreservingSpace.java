package programs.basicOperation;

public class ReverseStringByPreservingSpace
{
	public static void reverseString(String str) {
		char[] chars = str.toCharArray();
		int p = chars.length - 1;
		int i = 0;
		
		while(i < p) {
		if(chars[i] == ' ')
		i++;
		if(chars[p] == ' ')
		p--;
		
		char tmp = chars[i]; // swap (i, p)
		chars[i] = chars[p];
		chars[p] = tmp;
		
		i++;
		p--;
		}
		
		System.out.println(chars);
}
    public static void main(String[] args)
    {
        reverseString("I Am Not String");
         
        reverseString("JAVA JSP ANDROID");
         
        reverseString("1 22 333 4444 55555");
    }
}
