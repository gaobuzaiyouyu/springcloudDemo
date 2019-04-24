/**
 * 
 */
package cn.itcast.microservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 <p>Title: JdbcConfigBean</p>
 <p>Description: </p>
 <p>Company: </p>
 @author gaozhe
 @date 2019-4-23-下午5:32:57
 */
@RefreshScope//需要为动态更新配置内容的bean添加@RefreshScope注解
@Component//加入到Spring容器
public class JdbcConfigBean {

	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;

	@Value("${jdbc.driverClassName}")
	private String driverClassName;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	@Override
	public String toString() {
		return "JdbcConfigBean [url=" + url + ", username=" + username
				+ ", password=" + password + ", driverClassName="
				+ driverClassName + "]";
	}
	
}