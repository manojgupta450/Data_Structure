package creational.builder.builder2;

import static java.time.LocalDate.of;

public class UserClient {

    public static void main(String[] args) {
        User user = buildUser();
        UserDTO userDTO = directBuild(user, UserDTO.getBuilder());
        System.out.println(userDTO);

    }

    public static UserDTO directBuild(final User user, final UserDTO.UserDTOBuilder builder) {
        return builder.withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withAge(user.getBirthDay())
                .withPhone(user.getPhone())
                .withAddress(user.getAddress())
                .build();
    }

    public static User buildUser() {
        User user = new User();
        user.setFirstName("Manoj");
        user.setLastName("Gupta");
        user.setBirthDay(of(1988, 7, 21));
        user.setPhone("8904667647");
        Address address = new Address();
        address.setStreet("11th cross");
        address.setCity("Bangalore");
        address.setPin("560037");
        address.setState("KA");
        address.setCountry("IN");
        user.setFirstName("Manoj");
        user.setAddress(address);
        return user;
    }
}
