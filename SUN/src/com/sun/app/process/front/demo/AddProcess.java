package com.sun.app.process.front.demo;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;

public class AddProcess extends AjaxDwzResultProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("添加用户");
		String flashPath = getServMgr().getSysService().queryForFlash();
		model.put("fpath", flashPath);
		this.pageCount = Integer.valueOf(request.getParameter("pageCount"));
		getServMgr().getUserService().addUser(request.getParameterMap(),
				getIP(request));
		model.putAll(ForwardJson(200, "用户添加成功", appName));
		return model;
	}

}