package com.sun.app.process;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.core.Constants;
import com.sun.core.common.ExecuteResult;

/**
 * 通用结果操作基类Process
 * 
 * @author Nanlei
 * 
 */
public abstract class ExecuteResultBaseProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		this.execute(request, response);
		return model;
	}

	/**
	 * 执行方法
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	public abstract void execute(HttpServletRequest request,
			HttpServletResponse response);

	/* 通用操作结果返回页 */
	public static final String EXECUTE_RESULT = Constants.EXECUTE_RESULT;
	public static final String ERROR = Constants.ERROR;
	public static final String SUCCESS = Constants.SUCCESS;

	private ExecuteResult executeResult;

	private ExecuteResult buildExecuteResult(HttpServletRequest request) {
		if (executeResult == null) {
			executeResult = new ExecuteResult();
			request.getSession().setAttribute(EXECUTE_RESULT, executeResult);
		}
		return executeResult;
	}

	public void setResult(String result, HttpServletRequest request) {
		buildExecuteResult(request).setResult(result);
	}

	public void addMessage(String message, HttpServletRequest request) {
		buildExecuteResult(request).getMessages().clear();
		buildExecuteResult(request).addMessage(message);
	}

	public void addRedirURL(String desc, String url, HttpServletRequest request) {
		buildExecuteResult(request).addRedirURL(desc, url);
	}

	// public ExecuteResult getExecuteResult(HttpServletRequest request) {
	// return (ExecuteResult) request.getSession()
	// .getAttribute(EXECUTE_RESULT);
	// }

}
