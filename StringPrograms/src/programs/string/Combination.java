package programs.string;

import java.util.HashSet;
import java.util.Set;

public class Combination {
	
	public static void main(String args[]) {
		Combination c=new Combination();
		Set<String> s=c.getCombinations("abc", new StringBuffer(), 0);
		for(String str:s) {
			System.out.println(s);
		}
	}
	
	Set<String> getCombinations(String instr, StringBuffer outstr, int index)
	{
		Set<String> combinations = new HashSet<String>();
	for (int i = index; i < instr.length(); i++)
	{
	outstr.append(instr.charAt(i));
	combinations.add(outstr.toString());
	combinations.addAll(getCombinations(instr, outstr, i + 1));
	outstr.deleteCharAt(outstr.length() - 1);
	}
	return combinations;
	}

}
