package com.example.dormantaccount.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dormantaccount.dto.SampleForm;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SampleController {
	@GetMapping("/addSample")
	public String addSample() {
		
		return "addSample";
	}

	@PostMapping("/addSample")
	public String addSample(@Valid SampleForm sampleForm, Errors err, Model model) {
		// 커맨드 객체 sampleForm이 생성될 때 @Valid 유효성 검증이 먼저 선행된다. -> 에러 발생 시 Errors 객체에 에러 정보가 추가
		log.info(sampleForm.toString());
		// @Valid 선행 작업에서 Errors가 발생한다면 : 입력값 유효성 검사 후 입력 실패
		if(err.hasErrors()) {
			for(FieldError fe : err.getFieldErrors()) {
				model.addAttribute(fe.getField()+"ErrMsg", fe.getDefaultMessage());
				// model.addAttribute(nameErrMsg :, "아이디는 4자 이상 10자 이하로 하셔야 합니다.);
				/*
					@Valid 사용하지 않으면 아래 코드처럼 작성해야 함
					
					if(sampleForm.getName() == null || sampleForm.getName().length() < 4 || sampleForm.getAge() < 0 || sampleForm.getAge() > 200) {
						model.addAttribute("errMsg", "입력값 유효성 검증 실패");
						log.info("인증되지 않은 POST 요청입니다.");
						return "addSample";
						}
				 */
			}
			return "addSample";
		}
		// 유효성 검사 성공 시 Sample이 DB에 입력
		
		return "redircet:/"; // 입력 성공시 리다이렉트 URL
	}
}
