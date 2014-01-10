package com.sun.app.process.admin.about;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;

public class EditProcess extends AjaxDwzResultProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String content = request.getParameter("content");
		if(content.isEmpty()){
			model.putAll(ReturnJson(300, "操作失败", "add", "", "forward","/admin/about.do?command=editview"));
			return model;
		}
		Integer r = getServMgr().getAboutService().update(request,getIP(request));
		if(r>0)
		model.putAll(ReturnJson(200, "操作成功", "add", "", "forward","/admin/about.do?command=editview"));
		else
			model.putAll(ReturnJson(300, "操作失败", "add", "", "forward","/admin/about.do?command=editview"));
		return model;
	}

}