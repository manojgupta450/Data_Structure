package decorator;
 
public class Onion extends PizzaToppings {
 
    private Pizza pizza;
     
    public Onion(Pizza pizza) {
        this.pizza = pizza;
    }
     
    @Override
    public String makePizza() {
        return pizza.makePizza() + "onions, ";
    }
 
}