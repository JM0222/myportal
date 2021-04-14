package com.bitacademy.myportal.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bitacademy.myportal.vo.GuestbookVo;

// 이름 명시 안하면 클래스 이름을 기반으로 자동 명명
//@Repository("guestbookDao")
@Repository
public class GuestbookDaoImpl implements GuestbookDao {

	@Override
	public List<GuestbookVo> selectAll() {
		// 가상데이터 
		List<GuestbookVo> list = new ArrayList<>();
		list.add(new GuestbookVo(1L,"일동","1234","가상데이터",new Date()));
		list.add(new GuestbookVo(2L,"이동","1234","가상데이터2",new Date()));
		list.add(new GuestbookVo(3L,"삼동","1234","가상데이터3",new Date()));
		list.add(new GuestbookVo(4L,"사동","1234","가상데이터4",new Date()));
		return list;
		
	}

	@Override
	public int insert(GuestbookVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(GuestbookVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
