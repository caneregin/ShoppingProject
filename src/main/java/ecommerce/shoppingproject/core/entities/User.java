package ecommerce.shoppingproject.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class User {
	public User() {}

	public User(int userid, String firstname, String lastname, @Email @NotBlank @NotNull String email, String password,
			String birthdate, String address, String userphoto, String orders, String currentcart, int authoritylevel) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.birthdate = birthdate;
		this.address = address;
		this.userphoto = userphoto;
		this.orders = orders;
		this.currentcart = currentcart;
		this.authoritylevel = authoritylevel;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userid")
	private int userid;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Email
	@NotBlank
	@NotNull
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="birthdate")
	private String birthdate;
	
	@Column(name="address")
	private String address;
	
	@Column(name="userphoto")
	private String userphoto;
	
	@Column(name="orders")
	private String orders;
	
	@Column(name="currentcart")
	private String currentcart;
	
	@Column(name="authoritylevel")
	private int authoritylevel;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserphoto() {
		return userphoto;
	}

	public void setUserphoto(String userphoto) {
		this.userphoto = userphoto;
	}

	public String getOrders() {
		return orders;
	}

	public void setOrders(String orders) {
		this.orders = orders;
	}

	public String getCurrentcart() {
		return currentcart;
	}

	public void setCurrentcart(String currentcart) {
		this.currentcart = currentcart;
	}

	public int getAuthoritylevel() {
		return authoritylevel;
	}

	public void setAuthoritylevel(int authoritylevel) {
		this.authoritylevel = authoritylevel;
	}
	


}