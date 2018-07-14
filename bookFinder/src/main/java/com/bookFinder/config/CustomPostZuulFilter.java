package com.bookFinder.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class CustomPostZuulFilter extends ZuulFilter {

	@Override
	public Object run() {
		/*RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletResponse response = ctx.getResponse();
		System.out.println("AAAAAAA: " + ctx.getResponseDataStream());
		System.out.println("BBBBBBB : " + ctx.getResponseBody());

		try (final InputStream responseDataStream = ctx.getResponseDataStream()) {
			InputStreamReader ip = new InputStreamReader(responseDataStream, "UTF-8");
			final String responseData = CharStreams.toString(ip);
			System.out.println("CCCCCCCCCCCC : " + responseData);

			ctx.setResponseBody(responseData);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
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
