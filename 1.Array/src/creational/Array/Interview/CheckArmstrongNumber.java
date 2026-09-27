package creational.Array.Interview;

public class CheckArmstrongNumber
{
    static void checkArmstrongNumber(int num)
    {
        int number = num;
        int count=String.valueOf(number).length();
        double sum=0;
        double r;
        
        for(int i=0;i<count;i++)  {
        r=number%10;
        sum=sum+(Math.pow(r,count));
        number=number/10;
        }
        System.out.println("Given number:"+num);
        if(num==sum)
        {
        System.out.println(num+" is an ArmStrong number");
        }
        else
        {
        System.out.println(num+" is not an ArmStrong number");
        }
        
    }
 
    public static void main(String[] args)
    {
        checkArmstrongNumber(153);
 
        checkArmstrongNumber(371);
 
        checkArmstrongNumber(9474);
 
        checkArmstrongNumber(54748);
 
        checkArmstrongNumber(407);
 
        checkArmstrongNumber(1674);
    }
}
