package com.sun.app.process.admin.user;

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
		String userId = request.getParameter("userId");
		Map user = getServMgr().getUserService().getUserById(userId);
		List allGroup = getServMgr().getGroupService().getAllGroup();
		model.put("user", user);
		model.put("allGroup", allGroup);
		return model;
	}

}