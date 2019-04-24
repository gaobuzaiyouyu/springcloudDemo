/**
 * 
 */
package cn.itcast.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 <p>Title: ApiGatewayApplication</p>
 <p>Description: </p>
 <p>Company: </p>
 @author gaozhe
 @date 2019-4-18-下午9:40:33
 */
@EnableZuulProxy //启用Zuul网关
@SpringBootApplication
public class ApiGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
}
