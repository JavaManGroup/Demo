package com.sun.app.process.admin.honour;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;

public class AddImageViewProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String projectId = request.getParameter("projectId");
		Map project = getServMgr().getAdminProjectService().getProjectById(
				Integer.valueOf(projectId));
		model.put("project", project);
		return model;
	}

}