package ecommerce.shoppingproject.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.shoppingproject.business.abstracts.UserService;
import ecommerce.shoppingproject.core.entities.Order;
import ecommerce.shoppingproject.core.entities.User;
import ecommerce.shoppingproject.core.utilities.results.DataResult;
import ecommerce.shoppingproject.core.utilities.results.ErrorDataResult;
import ecommerce.shoppingproject.entities.concretes.Product;

@RestController
@RequestMapping(value="/api/users")
@CrossOrigin
public class UsersController {
	private UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	@PostMapping(value="/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user) {
		return ResponseEntity.ok(this.userService.add(user));
	}
	@GetMapping(value="getAll")
	public DataResult<List<User>> getAll(){
		return this.userService.getAll();
	}
	@GetMapping("/findByUserid")
	public User findByUserid(@RequestParam Long userid){
		return userService.findByUserid(userid);	
	}
	@PutMapping("/updateCart")
	public void updateCart(@RequestBody(required = false) String currentCart,@RequestParam Long userid) {
		userService.updateCart(currentCart, userid);
		System.out.println(currentCart+userid);
	}
	@PutMapping("/updateAddress")
	public void updateAddress(@RequestBody String address,@RequestParam Long userid) {
		userService.updateAddress(address, userid);
		System.out.println(address+userid);
	}
	@PutMapping("/updateUser")
	public void updateUser(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String email,@RequestParam String phoneNumber,@RequestParam String gender, @RequestParam Long userid) {
		userService.updateUser(firstName,lastName,email,phoneNumber,gender,userid);
		//System.out.println(firstName+lastName+email+phoneNumber+gender+userid);
	}
	@GetMapping("/findByUseridForCurrentCart")
	public String findByUseridForCurrentCart(@RequestParam Long userid){
		return userService.findByUseridForCurrentCart(userid);	
	}
	/*@PostMapping(value="/addItem")
	public ResponseEntity<?> addItem(@RequestBody String additem) {
		return ResponseEntity.ok(this.userService.addItem(additem));
	}*/
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String,String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Do??rulama Hatalari");
		return errors;
	}
}
