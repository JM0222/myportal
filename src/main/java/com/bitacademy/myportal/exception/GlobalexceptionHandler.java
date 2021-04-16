package com.bitacademy.myportal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

// 어드바이징 컨트롤러: 전역에서 발생하는 예외를 감지해서 처리하는 처리기
@ControllerAdvice
public class GlobalexceptionHandler {
	// 하나의 예외 클래스에 하나의 핸들러 붙이는것 추천
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	// 이 예외가 발생하면 에러 전송
	@ExceptionHandler(ControllerException.class)
	public ModelAndView handleControllerException(ControllerException e) {
		// 1. 로깅
		System.err.println("===========================");
		System.err.println("ControllerAdvice에 의한 Error Handling");
		e.printStackTrace();
		
		// 2. 시스템오류 관련 안내 화면
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", e.getClass().getSimpleName());
		mav.addObject("message",e.getMessage());
		mav.setViewName("error/exception");
		
		return mav;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(MemberDaoException.class)
	public ModelAndView handleMemberDaoException(MemberDaoException e) {
		// 로그 기록
		System.err.println("MemberDaoException:" + e.getMessage());
		e.printStackTrace();
		// 에외 상황 정보 로깅
		System.err.println("MemberVo:" + e.getMemberVo());
		// 안내 화면
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", e.getClass().getSimpleName());
		mav.addObject("message",e.getMessage());
		mav.setViewName("error/exception");
		
		return mav;
	}
}
