package com.sun.app.process.front.project;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;

public class ProjectProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		List allProjectTypes = getFsMgr().getProjectService()
				.getALlProjectType();
		List<Map> topType = getFsMgr().getProjectService().getTopProjectType();
		ListIterator<Map> typeIt = allProjectTypes.listIterator();
		int i = 0;
		while (typeIt.hasNext()) {
			Map next = typeIt.next();
			List topProject = getFsMgr().getProjectService().getProjectList(
					(Integer) next.get("id"));
			next.put("list", topProject);
		}
		model.put("allType", allProjectTypes);
		String flashPath = getServMgr().getSysService().queryForFlash();
		model.put("fpath", flashPath);
		return model;
	}
}