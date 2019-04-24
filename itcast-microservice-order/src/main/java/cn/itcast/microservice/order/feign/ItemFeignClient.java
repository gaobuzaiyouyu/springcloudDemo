/**
 * 
 */
package cn.itcast.microservice.order.feign;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.itcast.microservice.order.pojo.Item;

/**
 <p>Title: ItemFeignClient</p>
 <p>Description: 
 流程分析：
1、由于我们在入口@EnableFeignClients注解，Spring启动后会扫描标注了@FeignClient注解的接口，然后生成代理类
2、我们在@FeignClient接口中指定了value，其实就是指定了在Eureka中的服务名称
3、在FeignClient中的定义方法以及使用了SpringMVC的注解，Feign就会根据注解中的内容生成对应的URL，然后基于Ribbon的负载均衡去调用REST服务
 </p>
 <p>Company: </p>
 @author gaozhe
 @date 2019-4-18-下午8:56:32
 */
@FeignClient(value = "itcast-microservice-item") //申明这是一个Feign客户端，并且指明服务id
public interface ItemFeignClient {

	//这里定义了类似于SpringMVC用法的方法，就可以进行RESTful的调用了
	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
	public Item queryItemById(@PathVariable("id") Long id);
	
	//多参数构造：方法一，指定多个参数
	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public Item queryItemById1(@RequestParam("title")String title,@RequestParam("price")Long price);
	
	//多参数构造：方法二，通过Map指定参数
	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public Item queryItemById2(@RequestParam Map<String,Object> params);
}
