package com.sun.app.process.admin.type;

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
		int r = 0;
		r = getServMgr().getTypeService().update(request, getIP(request));
		if (r > 0)
			model.putAll(ForwardJson(200, "操作成功", appName));
		else
			model.putAll(ForwardJson(300, "操作失败", appName));

		return model;
	}

}