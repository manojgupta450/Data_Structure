package programs.basicOperation;

public class ReverseEachWord {

public static void main(String[] args) {
	reverseEachWordOfString("Java Concept Of The Day");
	reverseWordByWord("Java Concept Of The Day");
}


public static void reverseEachWordOfString(String inputStr) {

	String[] strArray = inputStr.split("\\s");
	String output = "";
	for (String str : strArray) {
	String reverse = new String(new StringBuffer(str).reverse());
	output =output+ reverse + " ";
	}
	System.out.println(output);

	}

public static void reverseWordByWord(String str){
	 String[] words = str.split(" ");
     String reverse = "";
     for (int i = 0; i < words.length; i++) {
         for (int j = words[i].length() - 1; j >= 0; j--) {
             reverse += words[i].charAt(j);
         }
         System.out.print(reverse + " ");
         reverse = "";
     }
}


}