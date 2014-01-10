package com.sun.app.process.front.honour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;

public class HonourListProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String typeId = request.getParameter("typeId");
		List allHonour = getFsMgr().getProjectService().getHonourProjectByType(
				typeId);
		List honourType = getFsMgr().getProjectService().getHonourType();
		model.put("allType", honourType);
		model.put("allHonour", allHonour);
		String flashPath = getServMgr().getSysService().queryForFlash();
		model.put("fpath", flashPath);
		model.put("typeId", typeId);
		return model;
	}

}
