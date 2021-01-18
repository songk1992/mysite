  
package com.bitacademy.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.security.Auth;

@Auth("ADMIN")
@Controller
@RequestMapping("/admin")
public class AdminController{
	
	@RequestMapping("")
	public String main() {
		return "admin/main";
	}
	
	@RequestMapping(value="/guestbook", method=RequestMethod.GET)
	public String guestbook() {
		return "admin/guestbook";
	}

	@RequestMapping(value="/board", method=RequestMethod.GET)
	public String board() {
		return "admin/board";
	}

	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String user() {
		return "admin/user";
	}
	
}