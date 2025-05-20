package com.example.chartjs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.chartjs.service.LoginService;
import com.example.chartjs.service.MemberService;

@Controller
public class LoginController {
	@Autowired LoginService  loginService;
	@Autowired MemberService memberService;
	
	@GetMapping("/login")
	public String login() {
		
		return "/login";
	}
	
    @PostMapping("/login")
    public String login(@RequestParam String id, @RequestParam String pw) {

        boolean result = loginService.login(id, pw);
        if(result) {
            loginService.addLoginHistory(id);
        }
        return "redirect:/dormantMember";
    }	
	
    @GetMapping("/dormantMember")
    public String dormantMember() {
    	
    	return "/dormantMember";
    }
    
    
    
    
    @GetMapping("/joinMember")
    public String joinMember() {
    	
    	return "/joinMember";
    }
    
    @PostMapping("/joinMember")
    public String joinMember(@RequestParam String id
    						,@RequestParam String pw
    						,@RequestParam String email) {
    	int result = memberService.insertJoinMember(id, pw, email);
    
    	if(result>0) {
    		return "/login";
    	} else {
    		return "/joinMember";
    	}
    }
}
