package com.sun.app.process.admin.user;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;
import com.sun.app.process.PagingBaseProcess;
import com.sun.core.common.PagingList;

public class LookGroupProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		List allGroup = getServMgr().getGroupService().getAllGroup();
		model.put("allGroup", allGroup);
		return model;
	}

}