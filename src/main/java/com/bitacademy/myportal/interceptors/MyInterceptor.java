package com.bitacademy.myportal.interceptors;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {
	private static Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("myinterceptor.prehandle");
		return true;
	}

	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("myinterceptor.posthandle");
	}

	// 뷰 렌더링까지 완료된 상태
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			Exception ex)
			throws Exception {
		logger.debug("myinterceptor.afterCompletion");
	}
}
	