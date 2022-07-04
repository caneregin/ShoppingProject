package ecommerce.shoppingproject.core.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ecommerce.shoppingproject.core.entities.Order;

public interface OrderDao extends JpaRepository<Order,Long>{
	@Query("From Order where user.userid=:userid")
	List<Order> findByOrderid(Long userid);
}
