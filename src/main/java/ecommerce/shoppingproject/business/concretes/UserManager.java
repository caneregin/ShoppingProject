package ecommerce.shoppingproject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.shoppingproject.business.abstracts.UserService;
import ecommerce.shoppingproject.core.dataAccess.UserDao;
import ecommerce.shoppingproject.core.entities.User;
import ecommerce.shoppingproject.core.utilities.results.DataResult;
import ecommerce.shoppingproject.core.utilities.results.Result;
import ecommerce.shoppingproject.core.utilities.results.SuccessDataResult;
import ecommerce.shoppingproject.core.utilities.results.SuccessResult;

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


}
