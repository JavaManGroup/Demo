package com.sun.app.process;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.common.Process;
import com.sun.app.common.Result;

/**
 * 默认跳转（空跳转）
 * 
 * @author Nanlei
 * 
 */
public class DefaultProcess extends Process {

	@Override
	public Result process(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HashMap<String, Object> model = new HashMap<String, Object>();
		return new Result(this.getSuccessView(), model);
	}

}
