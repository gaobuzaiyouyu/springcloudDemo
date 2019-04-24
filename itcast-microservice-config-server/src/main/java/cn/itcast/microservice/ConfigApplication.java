/**
 * 
 */
package cn.itcast.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 <p>Title: ConfigApplication</p>
 <p>Description: </p>
 <p>Company: </p>
 @author gaozhe
 @date 2019-4-23-上午9:36:59
 */
@EnableConfigServer//开启配置服务
@SpringBootApplication
public class ConfigApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}
}
