package ecommerce.shoppingproject.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.shoppingproject.core.entities.User;

public interface UserDao extends JpaRepository<User,Integer>{
	User findByEmail(String email);
}
