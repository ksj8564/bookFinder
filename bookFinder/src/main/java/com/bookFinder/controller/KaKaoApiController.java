package com.bookFinder.controller;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class KaKaoApiController {

	@GetMapping("/kakaoApi/v2/search/book")
	public Object callKakaoRestApi(HttpServletRequest request) {			
		return "json";
	} 
}
