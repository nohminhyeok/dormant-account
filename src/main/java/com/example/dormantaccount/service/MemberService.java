package com.example.dormantaccount.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.dormantaccount.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberService {
	 @Autowired MemberMapper memberMapper;
	 @Autowired JavaMailSender javaMailSender;
	 
	 public int insertJoinMember(String id, String pw, String email) {
	        return memberMapper.insertJoinMember(id, pw, email);
	 }
	 
	 public void setDormantAccounts() {
        List<Map<String, Object>> dormantList = memberMapper.selectDormantMember();
        for (Map<String, Object> member : dormantList) {
            String id = (String) member.get("id");
            setDormant(id); // 아래 코드 실행
        }
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

	public int updateMemberPw(String id, String email, String pw, String pwck) {
		
		return memberMapper.updateMemberPw(id, email, pw, pwck);
	}

	public void addPwChangeHistory(String id, String pwck) {
		
		memberMapper.insertPwChangeHistory(id, pwck);
	}
	
	public void removePwAccount() {
		memberMapper.deletePwHistory();
	}
}
