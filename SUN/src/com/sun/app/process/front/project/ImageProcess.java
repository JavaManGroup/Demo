package com.sun.app.process.front.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;

public class ImageProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String flashPath = getServMgr().getSysService().queryForFlash();
		model.put("fpath", flashPath);
		String projectId = request.getParameter("projectId");
		Map project = getFsMgr().getProjectService().getProjectById(
				Integer.valueOf(projectId));
		List allImage = getFsMgr().getProjectService()
				.getProjectImageByProjectId(Integer.valueOf(projectId));

		List allProjectTypes = getFsMgr().getProjectService()
				.getALlProjectType();
		model.put("project", project);
		model.put("allImage", allImage);
		model.put("allType", allProjectTypes);
		return model;
	}
}
