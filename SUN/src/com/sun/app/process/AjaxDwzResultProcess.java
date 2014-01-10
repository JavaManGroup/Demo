package com.sun.app.process;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.sun.app.common.Process;
import com.sun.app.common.Result;
import com.sun.app.service.ServiceManager;
import com.sun.core.bean.BeanManager;

/**
 * 默认跳转（空跳转）
 * 
 * @author Nanlei
 * 
 */
public abstract class AjaxDwzResultProcess extends Process {

	protected Integer pageCount = 1;

	public ServiceManager getServMgr() {
		return (ServiceManager) BeanManager.getBean("ServiceManager");
	}

	@Override
	public Result process(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HashMap<String, Object> model = new HashMap<String, Object>();
		HashMap<String, Object> finalModel = this.execute(request, response,
				model);
		return new Result(this.getSuccessView(), finalModel);
	}

	// "statusCode":"200",
	// "message":"\u64cd\u4f5c\u6210\u529f",
	// "navTabId":"",
	// "rel":"",
	// "callbackType":"closeCurrent",
	// "forwardUrl":""
	public Map ReturnJson(Integer statusCode, String message, String navTabId,
			String rel, String callbackType, String forwardUrl) {
		Map map = new HashMap();
		map.put("statusCode", statusCode);
		map.put("message", message);
		map.put("navTabId", navTabId);
		map.put("rel", rel);
		map.put("callbackType", callbackType);
		map.put("forwardUrl", forwardUrl);
		return map;
	}
	public Map ForwardJson(Integer statusCode, String message, String navTabId) {
		Map map = new HashMap();
		map.put("statusCode", statusCode);
		map.put("message", message);
		map.put("navTabId", navTabId);
		map.put("rel", " ");
		map.put("callbackType", "forward");
		String forwardUrl = appName+".do?command=list";
		map.put("forwardUrl", forwardUrl);
		return map;
	}
	public Map ForwardJson(Integer statusCode, String message, String navTabId,String forwardUrl) {
		Map map = new HashMap();
		map.put("statusCode", statusCode);
		map.put("message", message);
		map.put("navTabId", navTabId);
		map.put("rel", " ");
		map.put("callbackType", "forward");
		map.put("forwardUrl", forwardUrl);
		return map;
	}
	

	public Object getPageNum(HttpServletRequest request) {
		Object s = request.getAttribute("pageNum");
		return s;
	}

	public void setPageNum(HttpServletRequest request, Integer pageNum) {
		request.setAttribute("pageNum", pageNum);
	}

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

	public abstract HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception;

}
