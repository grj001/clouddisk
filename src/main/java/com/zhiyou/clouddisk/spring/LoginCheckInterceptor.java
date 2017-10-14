package com.zhiyou.clouddisk.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginCheckInterceptor implements HandlerInterceptor {
	//该方法中判断用户是否登录，如果用户已登录则直接放行，否则跳转到登录界面，不再进入Controller
	//该方法返回值是boolean类型，如果返回true则请求继续执行下去，否则请求就再次终结，不再往下执行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object user = request.getSession().getAttribute("user");
		if(user==null){
			//用户未登录，返回到登录界面
			response.sendRedirect("login.jsp");
			return false;
		}else{
			return true;
		}
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
