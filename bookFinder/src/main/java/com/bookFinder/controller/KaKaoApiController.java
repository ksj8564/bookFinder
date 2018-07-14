package com.bookFinder.controller;

import java.net.URI;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bookFinder.model.Bookmark;
import com.bookFinder.model.Search;
import com.bookFinder.model.User;
import com.bookFinder.service.BookFinderServiceImpl;
import com.bookFinder.service.UserServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class KaKaoApiController {
	
    @Autowired
    RestTemplate restTemplate;
    
	@Autowired
	private BookFinderServiceImpl bookFinderService;
	
	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/kakaoApi/v2/search/book")
	public Object callKakaoRestApi(Search search,HttpServletRequest request) throws Exception {	
		
		 URI uri = UriComponentsBuilder.newInstance().scheme("https").host("dapi.kakao.com").path("/v2/search/book")
	                .queryParam("query", search.getQuery())	             
	                .queryParam("page", search.getPage())
	                .queryParam("size", search.getSize())
	                .queryParam("target", search.getTarget())
	                .queryParam("category", search.getCategory())
	                .build().expand("json")
	                .encode()
	                .toUri();
		 
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK c85eadc30bc87ec577c122f5bcf0b9ad");
		HttpEntity<String> entity = new HttpEntity<>("headers",headers);

		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);	

		Map<String, Object> map = new HashMap<String, Object>();

		// convert JSON string to Map
		ObjectMapper mapper = new ObjectMapper();
		map = mapper.readValue(result.getBody(), new TypeReference<Map<String, Object>>(){});
		List<HashMap> bookList = (ArrayList<HashMap>)map.get("documents");
		
		for(int i=0;i<bookList.size();i++) {
			HashMap book = bookList.get(i);
			String isbn= String.valueOf(book.get("isbn"));		
			if(isbn != null && !"".equals(isbn)) {				
				Principal principal = request.getUserPrincipal();
				User user = userService.findUserByUsername(principal.getName());		
				Bookmark resBookmark = bookFinderService.findBookmarkByIsbnAndUserId(isbn,user.getUserId());
				System.out.println("AAAAAAAAAAA : "+resBookmark);
				if(resBookmark != null) {
					System.out.println("CCCCCCC : 널아님!!");
					book.put("bookmark", "Y");
				}else if(resBookmark == null){
					System.out.println("CCCCCCC : 널!!");
					book.put("bookmark", "N"); 
				}
			}
		};
		System.out.println("BBB : "+bookList.size());
		String sort = search.getSort();
		String sortDir = search.getSortDir();
		String sortType = search.getSortType();
		System.out.println("AAAAAAAAA : "+sort);
		System.out.println("BBBBBBBBB : "+sortDir);
		System.out.println("CCCCCCCC  : "+sortType);
		if(sort != null) {
			Collections.sort(bookList, new Comparator<HashMap>() {
		        public int compare(HashMap o1, HashMap o2) {	
		        	System.out.println("GGGGGGGGGGGGG : "+o1);
		        	if("asc".equals(sortDir) && "number".equals(sortType)){
		        		return ((Integer)o1.get(sort)).compareTo((Integer)o2.get(sort));
		        	}else if("desc".equals(sortDir) && "number".equals(sortType)){	        		
		        		return ((Integer)o2.get(sort)).compareTo((Integer)o1.get(sort));
		        	}else if("asc".equals(sortDir) && "string".equals(sortType)){
		        		return ((String)o1.get(sort)).compareTo((String)o2.get(sort));
		        	}else{	        		
		        		return ((String)o2.get(sort)).compareTo((String)o1.get(sort));
		        	}	            
		        }
		    });
		}	    
		return map;
	}
	

	

}
