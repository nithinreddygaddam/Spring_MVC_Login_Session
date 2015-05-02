package edu.sjsu.myapp;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.myapp.model.*;
import edu.sjsu.myapp.service.*;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
 
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
 
	public UserService getUserService() {
		return userService;
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET) 
	public String homepage() {
		return "index";
	}
 
	@RequestMapping("toLogin")
	public String toLogin(Model model) {
		//Make sure to add model of User in which login 
		//userName and password will be stored from the login form 
		model.addAttribute("user", new User());
		//"login" will be resolved to login.jsp
		//where login-form is presented to user
		return "login";
	}
	
	@RequestMapping("toSignUp")
	public String toSignUp(Model model) {
		model.addAttribute("user", new User());
		return "signUp";
	}
 
	@RequestMapping("doLogin")
	public ModelAndView doLogin(@ModelAttribute @Valid User user,BindingResult result) {
		ModelAndView view = new ModelAndView("login");
		//If input bean does not have validation error then proceed
		if(!result.hasFieldErrors()) {
			//If not a valid user then add error
			//else proceed to user welcome page
			if(!userService.authenticateUser(user)) {
				result.addError(new ObjectError("err", "Invalid Credentials"));
			}
			else {
				view = new ModelAndView("person-page", "person-entity", new Person());
			}
		}
		return view;
	}
	
	@RequestMapping("doSignUp")
	public ModelAndView doSignUp(@ModelAttribute @Valid User user,BindingResult result) {
		ModelAndView view = new ModelAndView("signUp");
		//If input bean does not have validation error then proceed
		if(!result.hasFieldErrors()) {
			//If not a valid user then add error
			//else proceed to user welcome page
			if(!userService.registerUser(user)) {
				result.addError(new ObjectError("err", "The user id already exits"));
			}
			else {
				view.setViewName("welcome");
			}
		}
		return view;
	}


}
	
	