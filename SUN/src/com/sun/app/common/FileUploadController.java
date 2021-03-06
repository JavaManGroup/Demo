package com.sun.app.common;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.sun.core.Constants;

/**
 * 文件上传总控制器
 * 
 * @author Nanlei
 * 
 */
public class FileUploadController extends SimpleFormController {
	private static final Log log = LogFactory
			.getLog(FileUploadController.class);
	private HashMap<String, FileUploadProcess> processMap;
	private boolean needTranslateGetMethod = false;

	public boolean isNeedTranslateGetMethod() {
		return needTranslateGetMethod;
	}

	public void setNeedTranslateGetMethod(boolean needTranslateGetMethod) {
		this.needTranslateGetMethod = needTranslateGetMethod;
	}

	public HashMap<String, FileUploadProcess> getProcessMap() {
		return processMap;
	}

	public void setProcessMap(HashMap<String, FileUploadProcess> processMap) {
		this.processMap = processMap;
		System.out.println(this.processMap);
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		ModelAndView mv = null;
		putParameterToAttribute(request);
		System.out.println(command);
		System.out.println(errors);
		String commond = (String) request.getAttribute(Constants.COMMAND);
		// 根据提交的command,选择对应的process进行处理
		FileUploadProcess process = null;
		if (commond == null || StringUtils.isEmpty(commond.trim())) {
			if (log.isDebugEnabled()) {
				log
						.debug("commond is null,and will choose the default process");
			}
			process = processMap.get(Constants.DEFAULT);
		} else {
			process = processMap.get(commond);
		}
		// 如果process不存在,跳转到系统错误页面
		if (process == null) {
			if (log.isErrorEnabled()) {
				log.error("process is null,please check your config files");
			}
			mv = new ModelAndView(Constants.SYSTEM_ERROR);
		} else {
			// 进行对应的处理
			Result result = null;
			result = process.validatAndProcess(request, response, command,
					errors);
			if (StringUtils.isNotEmpty(result.getMsgCode())
					&& !result.getMsgCode().startsWith(Constants.ERROR_PREFIX)) {
				Object[] msgArgs = result.getMsgArgs();
				if (null != msgArgs && msgArgs.length != 0) {
					for (int i = 0; i < msgArgs.length; i++) {
						Object msgArg = msgArgs[i];
						if (msgArg instanceof String) {
							if (((String) msgArg).indexOf('.') != -1) {
								String realMsg = this.getApplicationContext()
										.getMessage(
												(String) msgArg,
												null,
												RequestContextUtils
														.getLocale(request));
								msgArgs[i] = realMsg;
							}
						}
					}
				}
				String errorMessage = this.getApplicationContext().getMessage(
						result.getMsgCode(), msgArgs,
						RequestContextUtils.getLocale(request));
				request.setAttribute(Constants.ERROR, errorMessage);
				result.getModel().put("error", errorMessage);
			}

			if (result == null || result.getForward() == null) {
				if (log.isDebugEnabled()) {
					log
							.debug("the forward is null,will be go to the systemerror page");
				}
				mv = new ModelAndView(Constants.SYSTEM_ERROR);
			} else {
				if (result.isRedirect()) {
					mv = new ModelAndView("redirect:" + result.getForward(),
							result.getModel());
				} else if (result.isForward()) {
					mv = new ModelAndView("forward:" + result.getForward(),
							result.getModel());
				} else {
					mv = new ModelAndView(result.getForward(), result
							.getModel());
					if (mv.getViewName().equalsIgnoreCase("jsonView")) {
						if (request.getProtocol().equals("HTTP/1.0")) {
							response.setHeader("Pragma", "no-cache");
						}
						if (request.getProtocol().equals("HTTP/1.1")) {
							response.setHeader("Cache-Control", "no-cache");
							response.addHeader("Cache-Control", "no-store");
							response.addHeader("Cache-Control",
									"must-revalidate");
						}
						response.setDateHeader("Expires", 0);
					}
				}
			}

		}
		return mv;
	}

	private void putParameterToAttribute(HttpServletRequest request) {
		Map<String, String[]> paraMap = request.getParameterMap();
		Iterator<String> iter = paraMap.keySet().iterator();
		boolean isGetMethod = request.getMethod().equalsIgnoreCase("get");
		while (iter.hasNext()) {
			String key = iter.next();
			String[] values = paraMap.get(key);
			if (isGetMethod && needTranslateGetMethod && values != null) {
				for (int i = 0; i < values.length; i++) {
					try {
						values[i] = new String(values[i].getBytes("8859_1"),
								"UTF-8");
					} catch (UnsupportedEncodingException e) {
						if (log.isDebugEnabled()) {
							log.debug(e);
						}
						if (log.isInfoEnabled()) {
							log.info("Unsupport encode!");
						}
					}
				}
			}
			if (request.getAttribute(key) == null) {
				if (values != null) {
					if (values.length == 1) {
						request.setAttribute(key, values[0]);
					} else {
						request.setAttribute(key, Arrays.asList(values));
					}
				}
			}
		}
	}

}
