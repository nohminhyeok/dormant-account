package com.example.chartjs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.chartjs.dto.SampleForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SampleController {
	@GetMapping("/addSample")
	public String addSample() {
		
		return "addSample";
	}

	@PostMapping("/addSample")
	public String addSample(SampleForm sampleForm, Model model) {
		log.info(sampleForm.toString());
		// 입력값 유효성 검사 후 입력 실패
		if(sampleForm.getName() == null || sampleForm.getName().length() < 4 || sampleForm.getAge() < 0 || sampleForm.getAge() > 200) {
			model.addAttribute("errMsg", "입력값 유효성 검증 실패");
			return "addSample";
		}
		return "redircet:/입력성공 후 요청";
	}
}
