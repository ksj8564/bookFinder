package com.bookFinder.controller;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class KaKaoApiController {

	@GetMapping("/kakaoApi/v2/search/book")
	public Object callKakaoRestApi(@PathVariable String apiUrl,HttpServletRequest request) {			
		return "json";
	} 
}
