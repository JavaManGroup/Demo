package com.sun.app.process.admin.index;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;

public class IndexProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("管理员首页");
		List allType = getServMgr().getNewsService().getAllNewsType();
		model.put("allType", allType);

		List allProtype = getServMgr().getAdminProjectService()
				.getALlProjectType();
		
		List allCulture = getServMgr().getCultureService().getCultures();
		model.put("allCulture", allCulture);
		model.put("allProtype", allProtype);
		
		return model;
	}

}