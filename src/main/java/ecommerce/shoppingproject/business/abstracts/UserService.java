package ecommerce.shoppingproject.business.abstracts;

import java.util.List;

import ecommerce.shoppingproject.core.entities.User;
import ecommerce.shoppingproject.core.utilities.results.DataResult;
import ecommerce.shoppingproject.core.utilities.results.Result;

public interface UserService {
	Result add(User user);
	//DataResult<User> findBy(String email);
	User findByUserName(String userName);
	DataResult<List<User>> getAll();
	User findByUserid(Long userid);
	//User addItem(String additem);
	public void updateCart(String currentCart,Long userid);
	String findByUseridForCurrentCart(Long userid);
	
}
