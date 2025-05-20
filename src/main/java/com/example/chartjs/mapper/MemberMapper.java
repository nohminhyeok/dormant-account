package com.example.chartjs.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {
	List<Map<String, Object>> selectDormantMember();
	
	int updateMemberActiveToOff(@Param("id") String id);
	
	int insertJoinMember(@Param("id") String id, @Param("pw") String pw, @Param("email") String email);
	
	String selectEmailById(String id);
}
