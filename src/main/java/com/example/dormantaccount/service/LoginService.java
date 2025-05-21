package com.example.dormantaccount.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dormantaccount.mapper.LoginMapper;
import com.example.dormantaccount.mapper.MemberMapper;

@Service
public class LoginService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private LoginMapper loginMapper;

    // 로그인 처리
    public boolean login(String id, String pw) {
    	Map<String, Object> member = loginMapper.selectMemberByIdAndPw(id, pw);
    	return member != null;
    }

    public void addLoginHistory(String id) {
        loginMapper.insertLoginHistory(id);
    }


}