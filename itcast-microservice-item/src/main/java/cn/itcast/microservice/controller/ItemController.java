/**
 * 
 */
package cn.itcast.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.itcast.microservice.config.JdbcConfigBean;
import cn.itcast.microservice.pojo.Item;
import cn.itcast.microservice.service.ItemService;

/**
 <p>Title: ItemController</p>
 <p>Description: </p>
 <p>Company: </p>
 @author gaozhe
 @date 2019-4-16-下午9:57:57
 */
@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	/**
	 * 对外提供接口服务，查询商品信息
	 * @param id
	 * @return
	 */
	//@RequestMapping(value = "item/{id}", method= RequestMethod.GET) //简化后：
	@GetMapping(value = "item/{id}")
	public Item queryItemById(@PathVariable("id") Long id) {
		return this.itemService.queryItemById(id);
	}

	@Autowired
	private JdbcConfigBean jdbcConfigBean;
	
	@GetMapping(value = "test")
	public String test(){
		return this.jdbcConfigBean.toString();
	}

}
