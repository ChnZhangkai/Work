package com.cinasofti.springcloud.service.zuul;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * zuul实现路由安全过滤
 * @author Administrator
 *
 */
@Component
public class MyFilter extends ZuulFilter{
	
	private static Logger log = LoggerFactory.getLogger(MyFilter.class);
	
	/* 
	 * 具体的逻辑
	 */
	@Override
	public Object run() {
		
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        log.info("ok");
		return null;
	}

	/* 
	 * 逻辑判断，是否过滤，一般true，永远过滤
	 */
	@Override
	public boolean shouldFilter() {
		
		return true;
	}
	
	/* 
	 * 过滤的顺序
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/* 
	 * 返回一个字符串代表过滤器的类型
	 */
	@Override
	public String filterType() {
		
		return "pre";
	}

}
