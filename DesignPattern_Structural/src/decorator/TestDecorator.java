package decorator;


//http://www.hubberspot.com/2013/06/decorator-design-pattern-in-java.html
public class TestDecorator {

   public static void main(String[] args) {
        
       Pizza pizza = new Pizza();
        
       pizza = new ChickenMasala(pizza);
       pizza = new Onion(pizza);
       pizza = new Cheese(pizza);
        
       System.out.println("You're getting " + pizza.makePizza());

   }

}