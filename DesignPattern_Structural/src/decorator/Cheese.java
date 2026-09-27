package decorator;
 
public class Cheese extends PizzaToppings {
 
    private Pizza pizza;
     
    public Cheese(Pizza pizza) {
        this.pizza = pizza;
    }
     
    @Override
    public String makePizza() {
        return pizza.makePizza() + "and mozzarella cheese.";
    }
}