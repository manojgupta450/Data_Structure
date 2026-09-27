package creational.builder.builder2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {

    private String street;
    private String city;
    private String pin;
    private String state;
    private String country;
}
