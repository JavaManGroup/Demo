package com.sun.app.process.admin.demo;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.AjaxDwzResultProcess;

public class EditProcess extends AjaxDwzResultProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		int r = 0;
		getServMgr();
		if (r > 0) {
			model.putAll(ForwardJson(200, "操作成功", appName, appName + ".do"));
		} else {
			model.putAll(ForwardJson(300, "操作失败", appName, appName + ".do"));
		}
		return model;
	}

}