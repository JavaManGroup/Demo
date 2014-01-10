package com.sun.app.process.front.honour;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;
import com.sun.app.process.PagingBaseProcess;
import com.sun.core.common.PagingList;

public class HonourProcess extends PagingBaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		String typeId = request.getParameter("typeId");
		PagingList allHonour = null;
		if (typeId == null)
			allHonour = getFsMgr().getProjectService()
					.getHonourProject(request);
		else
			allHonour = getFsMgr().getProjectService()
					.getHonourProject(request,typeId);
		model.put("allHonour", allHonour);
		String flashPath = getServMgr().getSysService().queryForFlash();
		model.put("fpath", flashPath);
		model.put("typeId", typeId);
		return model;
	}
}
