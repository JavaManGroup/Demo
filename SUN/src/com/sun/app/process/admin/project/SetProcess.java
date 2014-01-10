package com.sun.app.process.admin.project;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;

public class SetProcess extends AjaxDwzResultProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String projectId = request.getParameter("projectId");
		String field = request.getParameter("field");
		if (field.equals("delstatus"))
			getServMgr().getAdminProjectService()
					.updateProjectDelStatus(projectId);
		if (field.equals("addstatus"))
			getServMgr().getAdminProjectService()
					.updateProjectAddStatus(projectId);
		model.putAll(ForwardJson(200, "操作成功", appName));
		return model;
	}

}