package com.sun.app.process.admin.zhaopin;

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
		String content = request.getParameter("content");
		if(content.isEmpty()){
			model.putAll(ForwardJson(300, "请填写招聘信息的内容", appName));
			return model;
		}
		
		getServMgr().getZhaopinService().add(request,getIP(request));
		model.putAll(ForwardJson(200, "招聘信息添加成功", appName));
		return model;
	}

}