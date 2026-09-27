package creational.builder.builder2;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String firstName;
    private String lastName;
    private String phone;
    private LocalDate birthDay;
    private Address address;
}
