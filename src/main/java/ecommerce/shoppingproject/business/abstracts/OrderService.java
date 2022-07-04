package ecommerce.shoppingproject.business.abstracts;

import java.util.List;

import ecommerce.shoppingproject.core.entities.Order;
import ecommerce.shoppingproject.core.entities.User;
import ecommerce.shoppingproject.core.utilities.results.DataResult;
import ecommerce.shoppingproject.core.utilities.results.Result;
import ecommerce.shoppingproject.entities.concretes.Product;

public interface OrderService {
	Result add(Order order);
	DataResult<List<Order>> getAll();
	DataResult<List<Order>> findByOrderid(Long orderid);
}
