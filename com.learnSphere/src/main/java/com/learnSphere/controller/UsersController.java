package com.learnSphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.entities.Users;
import com.learnSphere.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	// r uobj as m chck if provem pre in db ad us if eml is not pre
	// fe u db it compre  pro pss wth pas r frm db
	@Autowired
	UsersService uservice;
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute Users user) {
		String email=user.getEmail();
		boolean isPresent=uservice.checkEmail(email);
		if(isPresent==false) {
			uservice.addUser(user);
		}
		else {
			System.out.println("email already present");
		}
		return "login";
	}
	
	@PostMapping("/validateUser")
	public String validateUser(@RequestParam("email")String email,
			@RequestParam("password")String password,
			HttpSession session) {			
		
		Users user=uservice.findUserByEmail(email);
		String dbPassword=user.getPassword();
		String role=user.getRole();
		if(password.equals(dbPassword)) {
			//it sets logedin user in session
			session.setAttribute("loggedInUser", user);
		//	m.addAttribute("user", user);
			
			if(role.equals("trainer"))
				return "trainerHome";
			else
				return "studentHome";
		}
		else {
			return "login";
		}
	}

}
