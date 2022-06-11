package ecommerce.shoppingproject.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ecommerce.shoppingproject.core.entities.User;

public interface UserDao extends JpaRepository<User,Long>{
	
	User findByUserName(String userName);
	
}
