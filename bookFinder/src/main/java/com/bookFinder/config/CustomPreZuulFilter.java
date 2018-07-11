package com.bookFinder.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class CustomPreZuulFilter extends ZuulFilter {
 
    @Override
    public Object run() {
    	RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletRequest request = ctx.getRequest();
	    ctx.addZuulRequestHeader("Authorization", "KakaoAK c85eadc30bc87ec577c122f5bcf0b9ad");
	    System.out.println("PreFilter: " + String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
	    return null;
    }
 
    @Override
    public boolean shouldFilter() {
       return true;
    }

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 100;
	}

}
