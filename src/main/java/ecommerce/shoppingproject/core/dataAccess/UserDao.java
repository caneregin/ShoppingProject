package ecommerce.shoppingproject.core.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.shoppingproject.core.entities.User;
import ecommerce.shoppingproject.entities.concretes.Product;

public interface UserDao extends JpaRepository<User,Long>{

	User findByUserName(String userName);
	User findByUserid(Long userid);
	//User addItem(String additem);
	@Modifying
	@Transactional
	@Query("UPDATE User SET currentCart = :currentCart where userid = :userid")
	public void updateCart(String currentCart, long userid);
	
	@Modifying
	@Transactional
	@Query("UPDATE User SET address = :address where userid = :userid")
	public void updateAddress(String address, long userid);
	
	@Modifying
	@Transactional
	@Query("UPDATE User SET firstName = :firstName, lastName = :lastName, email = :email, phoneNumber = :phoneNumber, gender = :gender where userid = :userid")
	public void updateUser(String firstName,String lastName,String email,String phoneNumber,String gender, long userid);
	
	@Query("Select currentCart FROM User u where userid = :userid")
	String findByUseridForCurrentCart(Long userid);
}
