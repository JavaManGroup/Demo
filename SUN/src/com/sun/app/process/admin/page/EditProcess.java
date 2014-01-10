package com.sun.app.process.admin.page;

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
		getServMgr().getUserService().updateUserWithoutPasswordById(
				request.getParameterMap());
		model.putAll(ReturnJson(200, "修改成功", appName, "rel", "closeCurrent","forward"));
		return model;
	}

}