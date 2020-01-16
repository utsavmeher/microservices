package com.utsav.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean shouldFilter() { // This filter should work or not if true: then filter every request
		return true;
	}

	@Override
	public Object run() throws ZuulException { // Real logic of the filter goes here
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("Request: >>" + request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() { // If the filter is executed before or after the request is executed. Value: "pre" or "post" or "error" only for error request
		return "pre";
	}

	@Override
	public int filterOrder() {   // If you have multiple order then you can set the priority Value:  1 or 2 like this 
		return 1;
	}

}
