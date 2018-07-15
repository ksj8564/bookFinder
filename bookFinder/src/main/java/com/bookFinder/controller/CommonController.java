package com.bookFinder.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bookFinder.model.User;
import com.bookFinder.service.UserService;

@Controller
public class CommonController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value={ "/","/login"}, method = RequestMethod.GET)
	public ModelAndView login(ModelAndView modelAndView){	
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value={"/bookFinder"}, method = RequestMethod.GET)	
	public ModelAndView bookFind(ModelAndView modelAndView){	
		modelAndView.setViewName("bookFinder");
		return modelAndView;
	}
		
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(ModelAndView modelAndView){
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult, ModelAndView modelAndView) {
		User userExists = userService.findUserByUsername(user.getUsername());
		if (userExists != null) {
			bindingResult.rejectValue("username", "error.user","There is already a user registered with the username provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {		
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}

}
