package creational.builder.builder1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

//A product in builder pattern
@Getter
@AllArgsConstructor
@ToString
public class UserDTOImpl implements UserDTO {

	private String name;
	private String address;
	private String age;
}
