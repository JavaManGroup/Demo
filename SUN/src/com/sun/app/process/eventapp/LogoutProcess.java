package com.sun.app.process.eventapp;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.Message;
import com.sun.app.common.Process;
import com.sun.app.common.Result;
import com.sun.core.Constants;

/**
 * 退出后台管理
 * 
 * @author Nanlei
 * 
 */
public class LogoutProcess extends Process {

	@Override
	public Result process(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HashMap<String, Object> model = new HashMap<String, Object>();
		request.getSession().removeAttribute(Constants.LOGIN_USER);
		request.getSession().invalidate();
		model.put("logout", Message.LOGOUT);
		return new Result(this.getSuccessView(), model);
	}

}
