package ecommerce.shoppingproject.business.abstracts;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ecommerce.shoppingproject.core.dataAccess.UserDao;
import ecommerce.shoppingproject.core.entities.User;
import ecommerce.shoppingproject.security.JwtUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private UserDao userDao;
	
	public UserDetailsServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUserName(username);
		return JwtUserDetails.create(user);
	}
	
	public UserDetails loadUserById(Long userid) {
		User user = userDao.findById(userid).get();
		return JwtUserDetails.create(user);
	}

}
