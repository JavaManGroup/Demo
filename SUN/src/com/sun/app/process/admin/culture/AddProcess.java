package com.sun.app.process.admin.culture;

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
		System.out.println("添加文化");
		String content = request.getParameter("content");
		String isStatic =  request.getParameter("isStatic");
		if(isStatic.equals("1")&&content.isEmpty()){
			System.out.println(content.isEmpty());
			model.putAll(ForwardJson(300, "如果您选择静态页面请填写内容", appName, "culture.do"));
			
			return model;
		}
		int r = getServMgr().getCultureService().add(request, getIP(request));
		
		if (r > 0) {
			model.putAll(ForwardJson(200, "操作成功", appName, "culture.do"));
		} else {
			model.putAll(ForwardJson(300, "操作失败", appName, "culture.do"));
		}
		return model;
	}

}