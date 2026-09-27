package creational.singalton;

public class Test {
}

class Singlton {
     private static Singlton singlton = null;

     public static Singlton getInstance(){
         if (singlton == null) {
             synchronized (Singlton.class) {
                 if (singlton == null) {
                     singlton = new Singlton();
                 }
             }
         }
         return singlton;
     }


}
