package com.sun.app.process.eventapp.event;

import java.util.HashMap;
import java.util.Map;

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
		System.out.println("EVENT用户添加");
		this.pageCount = (Integer) request.getSession().getAttribute("pageCount");
		getServMgr().getGroupService().addUserGroup(request.getParameterMap(),
				getIP(request));
		model.putAll(ForwardJson(200, "操作成功", "user"));
		return model;
	}
}