package creational.Array.Interview;

public class SumOfAllDigits
{
    static void sumOfAllDigits(int inputNumber)
    {
        int copyOfInputNumber = inputNumber;
 
        int sum = 0;
 
        while (copyOfInputNumber != 0)
        {
            int lastDigit = copyOfInputNumber%10;
 
            sum = sum + lastDigit;
 
            copyOfInputNumber = copyOfInputNumber/10;
        }
 
        System.out.println("Sum Of All Digits In "+inputNumber+" = "+sum);
    }
 
    public static void main(String[] args)
    {
        sumOfAllDigits(47862);
 
        sumOfAllDigits(416872);
 
        sumOfAllDigits(5674283);
 
        sumOfAllDigits(475496215);
    }
}
