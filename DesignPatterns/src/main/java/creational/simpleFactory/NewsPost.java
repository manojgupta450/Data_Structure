package creational.simpleFactory;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a news post.
 *
 */
@Getter
@Setter
public class NewsPost extends Post{

	private String headline;
	private LocalDate newsTime;
}
