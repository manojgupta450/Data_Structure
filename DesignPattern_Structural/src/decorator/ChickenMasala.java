package decorator;
 
public class ChickenMasala extends PizzaToppings {
 
private Pizza pizza;
     
    public ChickenMasala(Pizza pizza) {
        this.pizza = pizza;
    }
     
    @Override
    public String makePizza() {
        return pizza.makePizza() + " with chicken masala, ";
    }
 
}