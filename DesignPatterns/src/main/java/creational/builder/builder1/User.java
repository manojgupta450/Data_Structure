package creational.builder.builder1;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

//Entity class used to construct the DTO
@Getter
@Setter
public class User {

	private String firstName;
	private String lastName;
	private LocalDate birthday;
	private Address address;
}
