package decorator1;

import java.math.BigDecimal;

/**
 * Base class for all types of Sandwich, cost method is abstract because
 * different sandwiches has different price.
 *
 * @author Javin Paul
 */
public abstract class Sandwich {   
    protected String description = "Sandwich";  
   
    public String getDescription(){
        return description;
    }
   
    public abstract BigDecimal price();
}

