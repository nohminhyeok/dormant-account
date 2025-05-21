package com.example.dormantaccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dormantaccount.service.LoginService;
import com.example.dormantaccount.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	@Autowired LoginService  loginService;
	@Autowired MemberService memberService;
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
    @PostMapping("/login")
    public String login(@RequestParam String id, @RequestParam String pw, HttpSession session) {

        boolean result = loginService.login(id, pw);
        if(result) {
            loginService.addLoginHistory(id);
            session.setAttribute("loginId", id);
            return "redirect:/memberHome";
        } else {
        	return "/login";
        }
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
	
    @GetMapping("/memberHome")
    public String memberHome() {
    	return "/memberHome";
    }
    
    @PostMapping("/memberHome")
    public String memberHome(@RequestParam String id) {
    	return "/changePw";
    }
    
    
    @GetMapping("/changePw")
    public String changePw(HttpSession session, Model model) {
        String id = (String) session.getAttribute("loginId");
        model.addAttribute("id", id); // JSP에서 쓸 수 있게 전달
        return "changePw";
    }
    
    @PostMapping("/changePw")
    @ResponseBody
    public String changePw(@RequestParam String id,
                           @RequestParam String email,
                           @RequestParam String pw,
                           @RequestParam String pwck) {
        int row = memberService.updateMemberPw(id, email, pw, pwck);
        if(row > 0) {
            log.info("비번 변경 성공");
            memberService.addPwChangeHistory(id, pwck);
            return "success";
        } else {
            log.info("비번 변경 실패");
            return "fail";
        }
    }
}
