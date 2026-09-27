package facade;

//https://www.javagists.com/facade-design-pattern
public class Client {
       public static void main(String args[]){
         OrderFacade orderFacade = new OrderFacade();
         orderFacade.placeOrder("OR123456");
         System.out.println("Order processing completed");
       }
  }
