package com.sun.app.process.admin.user;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;

public class AddViewProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		List addGroup = getServMgr().getGroupService().getAddViewGroup();
		model.put("addGroup", addGroup);
		return model;
	}

}