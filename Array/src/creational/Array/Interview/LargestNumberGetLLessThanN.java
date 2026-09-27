package creational.Array.Interview;

public class LargestNumberGetLLessThanN
{
    static int getLLessThanN(int number, int digit)
    {
        char c = Integer.toString(digit).charAt(0);
 
        for (int i = number; i > 0; --i)
        {
            if(Integer.toString(i).indexOf(c) == -1)
            {
                return i;
            }
        }
 
        return -1;
    }
 
    public static void main(String[] args)
    {
        System.out.println(getLLessThanN(123, 2));
 
        System.out.println(getLLessThanN(4582, 5));
 
        System.out.println(getLLessThanN(98512, 5));
 
        System.out.println(getLLessThanN(548624, 8));
    }
}
