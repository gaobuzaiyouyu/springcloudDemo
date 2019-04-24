package cn.itcast.microservice.order.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.microservice.order.OrderApplication;

/**
<p>Title: ItemServiceTest</p>
<p>Description: </p>
<p>Company: </p>
@author gaozhe
@date 2019-4-18-下午3:53:29
*/
@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest
@Import(OrderApplication.class)
public class ItemServiceTest {
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Test
	public void test(){
		String serviceId = "itcast-microservice-item";
		for (int i = 0; i< 100; i++) {
			ServiceInstance serviceInstance = this.loadBalancerClient.choose(serviceId);
			System.out.println("第"+(i+1)+"次：" + serviceInstance.getHost() + ": " + serviceInstance.getPort());
		}
	}

}

