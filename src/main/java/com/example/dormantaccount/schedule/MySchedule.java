package com.example.dormantaccount.schedule;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.dormantaccount.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MySchedule {
	@Autowired MemberService memberService;
	/*
		@Scheduled(cron =  "0 0 0 1 * *")
		public void myScheduleTest() {
			log.info("스케줄러 테스트");
		}
	*/
	
	/*
		매월 25일 23시 59분 59초 스케줄러 호출
		마지막 접속이 1년 전 	휴면 계정으로 만드는 서비스 메서드 ON -> OFF
	 	메일을 보내는 서비스 메서드

	 	
	 	로그인 컨트롤러 호출
	 	로그인시 이력을 입력하는 메서드
	 */
	@Scheduled(cron = "0 0 12 * * *")
	public void dormantAccountScheduler() {
		log.info("휴면계정 활성화 test");
		memberService.setDormantAccounts();
	}
	
	@Scheduled(cron = "1 * * * * *")
	public void removePwAccount() {
		log.info("비밀번호 변경 기록 삭제 완료");
		memberService.removePwAccount();
	}
}
