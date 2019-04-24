/**
 * 
 */
package cn.itcast.microservice.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.itcast.microservice.order.feign.ItemFeignClient;
import cn.itcast.microservice.order.pojo.Item;
import cn.itcast.microservice.order.properties.OrderProerties;

/**
 <p>Title: ItemService</p>
 <p>Description: </p>
 <p>Company: </p>
 @author gaozhe
 @date 2019-4-16-下午10:21:38
 */
@Service
public class ItemService {
	// Spring框架对RESTful方式的http请求做了封装，来简化操作
	@Autowired
	private RestTemplate restTemplate;
	
	//1 第一种解决URl的硬编码方法
	@Value("${itcast.item.url}")
	private String itcastItemUrl;
	
	/*public Item queryItemById(Long id) {
		//return this.restTemplate.getForObject("http://127.0.0.1:8081/item/"+ id, Item.class);
		return this.restTemplate.getForObject(this.itcastItemUrl+id, Item.class);
	}*/
	
	//2 第二种解决URl的硬编码方法，
	//  在SpringBoot中使用@ConfigurationProperties注解可以非常简单的将配置文件中的值映射成对象
	@Autowired
	private OrderProerties orderProerties;
	/*public Item queryItemById(Long id) {
		return this.restTemplate.getForObject(this.orderProerties.getItem().getUrl()+id, Item.class);
	}*/
	
	//3 第三种 使用eureka注册中心实现（springcloud微服务） 
	@Autowired
	private DiscoveryClient discoveryClient; // 服务发现对象
	
	/*public Item queryItemById(Long id) {
		String serviceId = "itcast-microservice-item";
		List<ServiceInstance> instances = this.discoveryClient.getInstances(serviceId);
		if(instances.isEmpty()){
			return null;
		}
		// 为了演示，在这里只获取一个实例
		ServiceInstance serviceInstance = instances.get(0);
		String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();
		return this.restTemplate.getForObject("http://" + url + "/item/" + id, Item.class);
	}*/
	
	//4 第四种 使用ribbon负载均衡实现 （RestTemplate的Bean加@LoadBalanced注解//开启负载均衡（ribbon））
	/*@HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod") // 进行容错处理
	public Item queryItemById(Long id) {
		String serviceId = "itcast-microservice-item";
		return this.restTemplate.getForObject("http://" + serviceId + "/item/" + id, Item.class);
	}*/
	
	public Item queryItemByIdFallbackMethod(Long id){// 请求失败执行的方法
		return new Item(id, "查询商品信息出错!", null, null, null);
	}
	
	//5 第五种 使用feign更便捷、更优雅的调用HTTP API（终极写法）
	@Autowired
	private ItemFeignClient itemFeignClient;
	
	@HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod") // 进行容错处理
	public Item queryItemById(Long id) {
		return this.itemFeignClient.queryItemById(id);
	}
}
