package com.example.dormantaccount.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
	Map<String, Object> selectMemberByIdAndPw(@Param("id") String id, @Param("pw") String pw);

	void insertLoginHistory(String id);
}
