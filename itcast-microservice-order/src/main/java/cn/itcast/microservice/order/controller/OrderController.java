/**
 * 
 */
package cn.itcast.microservice.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cn.itcast.microservice.order.pojo.Order;
import cn.itcast.microservice.order.service.OrderService;

/**
 <p>Title: OrderController</p>
 <p>Description: </p>
 <p>Company: </p>
 @author gaozhe
 @date 2019-4-16-下午10:22:58
 */
@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;

	@GetMapping(value = "order/{orderId}")
	public Order queryOrderById(@PathVariable("orderId") String orderId) {
		return this.orderService.queryOrderById(orderId);
	}
}
