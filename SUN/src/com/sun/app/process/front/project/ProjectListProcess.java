package com.sun.app.process.front.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;
import com.sun.core.common.PagingList;

public class ProjectListProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String flashPath = getServMgr().getSysService().queryForFlash();
		model.put("fpath", flashPath);
		String typeId = request.getParameter("typeId");
		PagingList allList = getFsMgr().getProjectService().getProjectPageList(
				Integer.valueOf(typeId), request);
		List allProjectTypes = getFsMgr().getProjectService()
				.getALlProjectType();
		model.put("allType", allProjectTypes);
		model.put("allList", allList);
		
		//获得类型名称
		for (int j = 0; j < allProjectTypes.size(); j++) {
			Map map = (Map) allProjectTypes.get(j);
			Integer d = (Integer) map.get("id");
			if (Integer.valueOf(typeId).equals(d)) {
				model.put("typeMap", map);
			}
		}
		return model;
	}
}