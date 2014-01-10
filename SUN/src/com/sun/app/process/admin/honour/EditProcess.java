package com.sun.app.process.admin.honour;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;

public class EditProcess extends AjaxDwzResultProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		int r = getServMgr().getHonourService().update(request, getIP(request));
		System.out.println(appName + r + "*********888");
		model.putAll(ForwardJson(200, "操作成功", appName));
		return model;
	}

}