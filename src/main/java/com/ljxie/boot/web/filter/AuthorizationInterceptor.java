package com.ljxie.boot.web.filter;


import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
* @ClassName: AuthorizationInterceptor
* @Description: 用户权限拦截器
* @author cinfotech
* @date 2017年12月1日
*
*/ 
public class AuthorizationInterceptor extends HandlerInterceptorAdapter{
	
	private static Map<String , Boolean> noCheckPath = new HashMap<String , Boolean>(){{  
		put("/login", true);
		put("/logout", true);
		put("/validateCode", true);
		put("/", true);  
		}};  

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("request path:" + request.getServletPath());
		//判断当前类的处理器是不是业务类的控制器
		//排除静态资源控制器
		if(handler instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod) handler; 
			Object controller = method.getBean();
			
			boolean isAjaxReq = request.getHeader("x-requested-with") != null  
	                && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest");
			
			//通用请求Controller 做session认证操作
//			if(!noCheckPath.containsKey(request.getServletPath())) {
//				Object currentUser = request.getSession().getAttribute(Const.LOGIN_SESSION_KEY);
//
//				//session 超时
//				if(currentUser == null) {
//					// 未登录
//					request.getRequestDispatcher("/").forward(request, response);
//	                return false;
//				}
//			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	
	

}
