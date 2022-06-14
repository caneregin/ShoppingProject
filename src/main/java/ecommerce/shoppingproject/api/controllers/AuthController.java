package ecommerce.shoppingproject.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.shoppingproject.business.concretes.UserManager;
import ecommerce.shoppingproject.core.dataAccess.UserDao;
import ecommerce.shoppingproject.core.entities.User;
import ecommerce.shoppingproject.core.utilities.responses.AuthResponse;
import ecommerce.shoppingproject.entities.dtos.UserRequest;
import ecommerce.shoppingproject.security.JwtTokenProvider;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
	
	private AuthenticationManager authenticationManager;
	
	private JwtTokenProvider jwtTokenProvider;
	
	private UserManager userService;
	
	private PasswordEncoder passwordEncoder;
	
    public AuthController(AuthenticationManager authenticationManager, UserManager userService, 
    		PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }
	@PostMapping("/login")
	public AuthResponse login(@RequestBody UserRequest loginRequest) {
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword());
		System.out.println(authToken);
		Authentication auth = authenticationManager.authenticate(authToken);
		System.out.println("gecti2"+auth);
		SecurityContextHolder.getContext().setAuthentication(auth);
		String jwtToken = jwtTokenProvider.generateJwtToken(auth);
		User user = userService.getOneUserByUserName(loginRequest.getUserName());
		AuthResponse authResponse = new AuthResponse();
		authResponse.setMessage("Bearer "+jwtToken);
		authResponse.setUserId(user.getUserid());
		return authResponse;
	}
	
	@PostMapping("/register")
	public ResponseEntity<AuthResponse> register(@RequestBody UserRequest registerRequest) {
		AuthResponse authResponse = new AuthResponse();
		if(userService.getOneUserByUserName(registerRequest.getUserName()) != null) {
			authResponse.setMessage("Username already in use.");
			return new ResponseEntity<>(authResponse, HttpStatus.BAD_REQUEST);
		}
		
		User user = new User();
		user.setUserName(registerRequest.getUserName());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		userService.saveOneUser(user);
		authResponse.setMessage("User successfully registered.");
		return new ResponseEntity<>(authResponse, HttpStatus.CREATED);		
	}
		
}