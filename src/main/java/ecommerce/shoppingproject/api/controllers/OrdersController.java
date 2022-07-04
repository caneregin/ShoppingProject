package ecommerce.shoppingproject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.shoppingproject.business.abstracts.OrderService;
import ecommerce.shoppingproject.business.abstracts.UserService;
import ecommerce.shoppingproject.core.entities.Order;
import ecommerce.shoppingproject.core.entities.User;
import ecommerce.shoppingproject.core.utilities.results.DataResult;
import ecommerce.shoppingproject.entities.concretes.Product;

@RestController
@RequestMapping(value="/api/orders")
@CrossOrigin
public class OrdersController {
private OrderService orderService;
	
	@Autowired
	public OrdersController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<?> add(@RequestBody Order order) {
		return ResponseEntity.ok(this.orderService.add(order));
	}
	@GetMapping(value="getAll")
	public DataResult<List<Order>> getAll(){
		return this.orderService.getAll();
	}
	@GetMapping("/findByOrderid")
	public DataResult<List<Order>> findByUserid(@RequestParam Long userid){
		return this.orderService.findByOrderid(userid);
	}
}
