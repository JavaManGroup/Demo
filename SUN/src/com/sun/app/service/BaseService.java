package com.sun.app.service;

import javax.servlet.http.HttpServletRequest;

import com.sun.core.common.CommonBaseService;

/**
 * Service基类
 * 
 * @author Nanlei
 * 
 */
public abstract class BaseService extends CommonBaseService {
	
	abstract public Integer add(HttpServletRequest request, String ip);

	abstract public Integer delete(HttpServletRequest request, String ip);
	
	abstract public Integer update(HttpServletRequest request, String ip);
}
