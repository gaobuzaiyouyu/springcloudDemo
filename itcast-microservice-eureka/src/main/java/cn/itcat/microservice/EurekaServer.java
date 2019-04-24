/**
 * 
 */
package cn.itcat.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 <p>Title: EurekaServer</p>
 <p>Description: </p>
 <p>Company: </p>
 @author gaozhe
 @date 2019-4-17-下午5:34:21
 */
@EnableEurekaServer//申明这是一个Eureka服务
@SpringBootApplication
public class EurekaServer {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServer.class, args);
	}
}
