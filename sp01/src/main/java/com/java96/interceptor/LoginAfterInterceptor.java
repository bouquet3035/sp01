package com.java96.interceptor;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.java96.dto.MemberDTO;

public class LoginAfterInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if(request.getMethod().equals("GET")) {
			return ; 
		}
		
		Map<String,Object> map = modelAndView.getModel() ;   
		
		if(map.get("memberDTO")!= null) {
			//usesession
			request.getSession().setAttribute("memberDTO", map.get("memberDTO"));
			//use cookie 
//			MemberDTO dto =(MemberDTO)map.get("memberDTO"); 
//			Cookie loginCooKie = new Cookie("login",map.get("memberDTO")) ; 
//			loginCookie.setMaxAge(2*60) ; 
//			response.addCookie(loginCooKie);
			
		}
		
	}

}
