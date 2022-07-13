package ecommerce.shoppingproject.entities.dtos;

import lombok.Data;

@Data
public class UserRequest {
	String userName;
	String password;
	String firstName;
	String lastName;
	String email;
	String address;
	String phoneNumber;
	String gender;
}
