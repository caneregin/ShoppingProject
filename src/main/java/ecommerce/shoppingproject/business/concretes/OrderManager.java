package ecommerce.shoppingproject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.shoppingproject.business.abstracts.OrderService;
import ecommerce.shoppingproject.core.dataAccess.OrderDao;
import ecommerce.shoppingproject.core.entities.Order;
import ecommerce.shoppingproject.core.entities.User;
import ecommerce.shoppingproject.core.utilities.results.DataResult;
import ecommerce.shoppingproject.core.utilities.results.Result;
import ecommerce.shoppingproject.core.utilities.results.SuccessDataResult;
import ecommerce.shoppingproject.core.utilities.results.SuccessResult;
import ecommerce.shoppingproject.entities.concretes.Product;

@Service
public class OrderManager implements OrderService {

	private OrderDao orderDao;
	
	@Autowired
	public OrderManager(OrderDao orderDao) {
		super();
		this.orderDao = orderDao;
	}

	@Override
	public Result add(Order order) {
		this.orderDao.save(order);
		return new SuccessResult("Kullanici eklendi");
	}

	@Override
	public DataResult<List<Order>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Order>>(this.orderDao.findAll(),"ürün listelendi");
	}

	@Override
	public DataResult<List<Order>> findByOrderid(Long orderid) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Order>>
		(this.orderDao.findByOrderid(orderid),"ürün listelendi");
	}
}
