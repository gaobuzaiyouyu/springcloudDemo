/**
 * 
 */
package cn.itcast.microservice.filters;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 <p>Title: UserLoginZuulFilter</p>
 <p>Description: </p>
 <p>Company: </p>
 @author gaozhe
 @date 2019-4-22-上午11:37:16
 */
@Component
public class UserLoginZuulFilter extends ZuulFilter{
	/**
	 * 该过滤器需要执行
	 */
	@Override
	public boolean shouldFilter() {
		return true; 
	}
	/**
	 * 过滤器的具体业务逻辑
	 */
	@Override
	public Object run() {
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		String token = request.getParameter("token");
		if(StringUtils.isEmpty(token)){
			requestContext.setSendZuulResponse(false); // 过滤该请求，不对其进行路由
			requestContext.setResponseStatusCode(401); // 设置响应状态码
			return null;
		}
		return null;
	}
	/**
	 * 设置过滤器类型为：pre
	 */
	@Override
	public String filterType() {
		return"pre";
	}
	/**
	 * 设置执行顺序
	 */
	@Override
	public int filterOrder() {
		return 0;
	}
}
