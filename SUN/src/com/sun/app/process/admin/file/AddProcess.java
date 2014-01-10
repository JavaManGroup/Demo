package com.sun.app.process.admin.file;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;

public class AddProcess extends AjaxDwzResultProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		model.put("navTabId", "user");
		model.put("callbackType", "forward");
		model.put("forwardUrl", "user.do?command=list&pageNum=" + pageCount);
		getServMgr().getGroupService().addUserGroup(request.getParameterMap(),
				getIP(request));
		return model;
	}

}