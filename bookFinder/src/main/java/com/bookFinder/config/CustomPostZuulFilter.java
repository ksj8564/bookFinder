package com.bookFinder.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class CustomPostZuulFilter extends ZuulFilter {
 
    @Override
    public Object run() {
    	RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletResponse response = ctx.getResponse();
	    System.out.println("AAAAAAA : "+response.getStatus());
	    
        return null;
    }
 
    @Override
    public boolean shouldFilter() {
       return true;
    }

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 100;
	}

}
