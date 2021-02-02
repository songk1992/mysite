package com.bitacademy.mysite.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.mysite.dto.JsonResult;
import com.bitacademy.mysite.service.UserService;

@Controller("UserApiController")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/existemail")
	public JsonResult existEmail(@RequestParam(value="email", required=false, defaultValue="") String email) {
		
		boolean result = userService.existsEmail(email);
		return JsonResult.success(result);
		
		// 맵 대신에 JSONRESULT를 만들어서 사용
//		Map<String, Object> map = new HashMap<>();
//		map.put("result", "success"); // "success" or "fail"
//		map.put("data", result); // if success, Data set  (true / false)
//		map.put("message", "김송");// if fail, Error Message

		
		
	}
}
