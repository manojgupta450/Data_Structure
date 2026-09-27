package facade;


public class OrderFacade {
private Payment pymt = new Payment();
private Inventory inventry = new Inventory();

public void placeOrder(String orderId) {
    String step1 = inventry.checkInventory(orderId);
    String step2 = pymt.deductPayment(orderId);
    System.out
            .println("Following steps completed:" + step1
                    + " & " + step2);
   }
}
