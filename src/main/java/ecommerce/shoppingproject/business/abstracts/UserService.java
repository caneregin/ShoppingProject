package ecommerce.shoppingproject.business.abstracts;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

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
	public void updateAddress(String address,Long userid);
	public void updateUser(String firstName,String lastName,String email,String phoneNumber,String gender,long userid);
	String findByUseridForCurrentCart(Long userid);
	
}
