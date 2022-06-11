package ecommerce.shoppingproject.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.shoppingproject.business.concretes.UserManager;
import ecommerce.shoppingproject.core.entities.User;
import ecommerce.shoppingproject.entities.dtos.UserRequest;
import ecommerce.shoppingproject.security.JwtTokenProvider;

@RestController
@RequestMapping("/auth")
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
	public String login(@RequestBody UserRequest loginRequest) {
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword());
		System.out.println(authToken);
		System.out.println("gecti1");
		Authentication auth = authenticationManager.authenticate(authToken);
		System.out.println("gecti2"+auth);
		SecurityContextHolder.getContext().setAuthentication(auth);
		String jwtToken = jwtTokenProvider.generateJwtToken(auth);
		return "Bearer "+jwtToken;
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody UserRequest registerRequest) {
		if(userService.getOneUserByUserName(registerRequest.getUserName()) != null) {
			return new ResponseEntity<>("Username already in use.", HttpStatus.BAD_REQUEST);
		}
		
		User user = new User();
		user.setUserName(registerRequest.getUserName());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		userService.saveOneUser(user);
		return new ResponseEntity<>("User successfully registered.", HttpStatus.CREATED);		
	}
		
}