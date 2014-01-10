package com.sun.app.process.admin.protype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;

public class EditViewProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String protypeId = request.getParameter("protypeId");
		Map type  = getServMgr().getAdminProjectService().getProjectTypeMap(protypeId);
		model.put("type", type);
		return model;
	}

}