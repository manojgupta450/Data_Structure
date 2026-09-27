package decorator1;

/**
 * Test class to demonstrate How Decorator Pattern in Java work together. This class
 * first creates a Sandwich and decorates it with extra cheese. This is nice example
 * of how to provide new functionalities to an object at runtime using Decorator Pattern.
 *
 * @author Javain Paul
 */
public class SandwichMaker {
   
    public static void main(String args[]){
       
        Sandwich mySandwich = new WhiteBreadSandWich("White bread Sandwich");
        System.out.printf("Price of %s is $%.2f %n", mySandwich.getDescription(), 

                                                     mySandwich.price());
       
        //adding extra cheese using Decorator Pattter
        mySandwich = new CheeseDecorator(mySandwich);
        System.out.printf("Price of %s is $%.2f %n", mySandwich.getDescription(), 

                                                     mySandwich.price());
    }
}

