package com.example.chartjs.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.chartjs.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberService {
	 @Autowired MemberMapper memberMapper;
	 @Autowired JavaMailSender javaMailSender;
	 
	 public int insertJoinMember(String id, String pw, String email) {
	        return memberMapper.insertJoinMember(id, pw, email);
	 }
	 
	 public void setDormant(String id) {
		 int row = memberMapper.updateMemberActiveToOff(id);
	        if(row == 1) {
	            // 메일 전송
	        	String email = memberMapper.selectEmailById(id);
	            SimpleMailMessage msg = new SimpleMailMessage();
	            msg.setFrom("admin@localhost.com"); // 실제 메일서버 계정으로 변경 필요
	            msg.setTo(email);
	            msg.setSubject("휴면계정 처리 안내");
	            msg.setText("귀하의 계정이 1년동안 미접속하여 휴면계정 처리되었습니다.");

	            javaMailSender.send(msg);
	        }
	 }
}
