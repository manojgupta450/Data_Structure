package creational.builder.builder2;

import java.time.LocalDate;
import java.time.Period;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserDTO {

    private String name;
    private String age;
    private String phone;
    private String address;

    private void setName(final String name) {
        this.name = name;
    }

    private void setAge(final String age) {
        this.age = age;
    }

    private void setPhone(final String phone) {
        this.phone = phone;
    }

    private void setAddress(final String address) {
        this.address = address;
    }

    public static UserDTOBuilder getBuilder() {
        return new UserDTOBuilder();
    }

    public static class UserDTOBuilder {

        private String firstName;
        private String lastName;
        private String age;
        private String phone;
        private String address;

        private UserDTO userDTO;

        public UserDTOBuilder withFirstName(String fName) {
            firstName = fName;
            return this;
        }

        public UserDTOBuilder withLastName(String lName) {
            lastName = lName;
            return this;
        }

        public UserDTOBuilder withAge(LocalDate birthDate) {
            Period ageInYears = Period.between(birthDate, LocalDate.now());
            age = Integer.toString(ageInYears.getYears());
            return this;
        }

        public UserDTOBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserDTOBuilder withAddress(Address address) {
            this.address = address.getStreet() + ", " + address.getCity() + ", " + address.getPin()
                           + ", " + address.getState() + ", " + address.getCountry();
            return this;
        }

        public UserDTO build() {
            this.userDTO = new UserDTO();
            userDTO.setName(firstName + " " + lastName);
            userDTO.setAge(age);
            userDTO.setPhone(phone);
            userDTO.setAddress(address);
            return userDTO;
        }

        //If want to retrieve existing build object.
        public UserDTO getUserDTO() {
            return this.userDTO;
        }
    }
}
