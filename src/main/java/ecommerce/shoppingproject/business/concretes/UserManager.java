package ecommerce.shoppingproject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import ecommerce.shoppingproject.business.abstracts.UserService;
import ecommerce.shoppingproject.core.dataAccess.UserDao;
import ecommerce.shoppingproject.core.entities.Order;
import ecommerce.shoppingproject.core.entities.User;
import ecommerce.shoppingproject.core.utilities.results.DataResult;
import ecommerce.shoppingproject.core.utilities.results.Result;
import ecommerce.shoppingproject.core.utilities.results.SuccessDataResult;
import ecommerce.shoppingproject.core.utilities.results.SuccessResult;
import ecommerce.shoppingproject.entities.concretes.Product;

@Service
public class UserManager implements UserService{
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanici eklendi");
	}

	@Override
	public User findByUserName(String email) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(email);
	}
	public User getOneUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(userName);
	}
	public Result saveOneUser(User newUser) {
		this.userDao.save(newUser);
		return new SuccessResult("Kullanici eklendi");
	}
	public User getOneUserById(Long userId) {
		return userDao.findById(userId).orElse(null);
	}

	@Override
	public DataResult<List<User>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"ürün listelendi");
	}

	@Override
	public User findByUserid(Long userid) {
		// TODO Auto-generated method stub
		return userDao.findByUserid(userid);
	}

	@Override
	public void updateCart(String currentCart, Long userid) {
		// TODO Auto-generated method stub
		userDao.updateCart(currentCart, userid);
	}

	@Override
	public String findByUseridForCurrentCart(Long userid) {
		// TODO Auto-generated method stub
		return userDao.findByUseridForCurrentCart(userid);
	}

	@Override
	public void updateUser(String firstName,String lastName,String email,String phoneNumber,String gender, long userid) {
		// TODO Auto-generated method stub
		userDao.updateUser(firstName,lastName,email,phoneNumber,gender,userid);
	}

	@Override
	public void updateAddress(String address, Long userid) {
		// TODO Auto-generated method stub
		userDao.updateAddress(address, userid);
	}


	/*@Override
	public User addItem(String additem) {
		// TODO Auto-generated method stub
		return userDao.addItem(additem)
	}*/


}
