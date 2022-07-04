package ecommerce.shoppingproject.core.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ecommerce.shoppingproject.entities.concretes.Product;
import lombok.Data;

@Entity
@Table(name="users")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","orders"})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long userid;
	String userName;
	String password;
	String firstName;
	String lastName;
	String email;
	String address;
	String userPhoto;
	String currentCart;
	String authorityLevel;
	String phoneNumber;
	String gender;
	
	@OneToMany(mappedBy = "user")
	private List<Order> orders;
}