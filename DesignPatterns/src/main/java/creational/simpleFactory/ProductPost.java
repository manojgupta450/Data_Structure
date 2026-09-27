package creational.simpleFactory;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a product information post. 
 *
 */

@Getter
@Setter
public class ProductPost extends Post{

	private String imageUrl;
	private String name;
}
