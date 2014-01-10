package com.sun.app.process;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.sun.app.common.Process;
import com.sun.app.common.Result;
import com.sun.app.service.FrontServiceManager;
import com.sun.app.service.ServiceManager;
import com.sun.core.Constants;
import com.sun.core.bean.BeanManager;

/**
 * Process基类
 * 
 * @author Nanlei
 * 
 */
public abstract class BaseProcess extends Process {
	/**
	 * 获取系统管理的Service管理器
	 * 
	 * @return
	 */
	public FrontServiceManager getFsMgr(){
		return (FrontServiceManager) BeanManager.getBean("FrontServiceManager");
	}
	public ServiceManager getServMgr() {
		return (ServiceManager) BeanManager.getBean("ServiceManager");
	}
	
	
	/**
	 * 获取登录用户对象
	 * 
	 * @param request
	 * @return
	 */
	public Map getUser(HttpServletRequest request) {
		return (Map) request.getSession().getAttribute(Constants.LOGIN_USER);
	}

	/**
	 * 获取登录用户的ID
	 * 
	 * @param request
	 * @return
	 */
	public String getUserId(HttpServletRequest request) {
		return String.valueOf(getUser(request).get("ID"));
	}

	/**
	 * 获取IP的方法，加入了通过代理服务器跳转过来请求的判断
	 * 
	 * @param request
	 * @return
	 */
	public String getIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("x-forward-for");
			if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
		}
		return ip;
	}

	@Override
	public Result process(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HashMap<String, Object> model = new HashMap<String, Object>();
		HashMap<String, Object> finalModel = this.execute(request, response,
				model);
		return new Result(this.getSuccessView(), finalModel);
	}

	public abstract HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception;



}
