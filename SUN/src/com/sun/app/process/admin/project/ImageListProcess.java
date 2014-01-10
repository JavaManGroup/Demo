package com.sun.app.process.admin.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.PagingBaseProcess;
import com.sun.core.common.PagingList;

public class ImageListProcess extends PagingBaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String projectId = request.getParameter("projectId");
		Map project = getServMgr().getAdminProjectService().getProjectById(
				Integer.valueOf(projectId));
		List images = getServMgr().getAdminProjectService()
				.getProjectImageByProjectId(Integer.valueOf(projectId));
		
		model.put("images", images);
		
		model.put("project", project);
		return model;
	}

}