package com.bitacademy.myportal.repository;

import com.bitacademy.myportal.vo.MemberVo;

public interface MemberDao {
	public int insert(MemberVo vo); // INSERT
	public MemberVo selectUser(String email, String password); // 셀렉트
	public MemberVo selectUser(String email); // 중복체크
}
