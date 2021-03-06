package com.bitacademy.myportal.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.myportal.vo.GuestbookVo;

// 이름 명시 안하면 클래스 이름을 기반으로 자동 명명
//@Repository("guestbookDao")
@Repository
public class GuestbookDaoImpl implements GuestbookDao {
	private static Logger logger = LoggerFactory.getLogger(MemberDaoImpl.class);
	// 데이터 소스 연결(Connection)
	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public List<GuestbookVo> selectAll() {
		//	TODO: 예외 전환 처리
		List<GuestbookVo> list = sqlSession.selectList("guestbook.selectAll");
		logger.debug("방명록:" + list);
		return list;
	}

	@Override
	public int insert(GuestbookVo vo) {
		int insertedCount = sqlSession.insert("guestbook.insert", vo);
		return insertedCount;
	}

	@Override
	public int delete(GuestbookVo vo) {
		int deletedCount = sqlSession.delete("guestbook.delete", vo);
		return deletedCount;
	}

}
