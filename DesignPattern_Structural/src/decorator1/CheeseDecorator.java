package decorator1;

import java.math.BigDecimal;

/**
 * A Decorator class, which adds cheese (new functionality) into Sandwich object.
 * This Decorator class modifies price() and getDescritption() method to implement
 * new behaviour.
 *
 * @author
 */
public class CheeseDecorator extends SandWichDecorator{
    Sandwich currentSandwich;
   
    public CheeseDecorator(Sandwich sw){
        currentSandwich = sw;
    }
   
    @Override
    public String getDescription(){
        return currentSandwich.getDescription() + ", Cheese";
    }
    @Override
    public BigDecimal price() {
        return currentSandwich.price().add(new BigDecimal("0.50"));
    }
   
}
