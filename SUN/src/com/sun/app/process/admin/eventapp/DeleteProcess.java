package com.sun.app.process.admin.eventapp;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.core.util.StringUtil;

public class DeleteProcess extends AjaxDwzResultProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		model.put("navTabId", "user");
		model.put("callbackType", "forward");
		model.put("forwardUrl", "user.do?command=list");
		System.out.println("asdfsdf");
		String uid = request.getParameter("uid");
		Integer r = getServMgr().getUserService().deleteUser(
				StringUtil.valueOf(uid));
		if (r > 0) {
			model.put("statusCode", "200");
			model.put("message", "操作成功");
		} else {
			model.put("statusCode", "300");
			model.put("message", "操作失败");
		}

		model.put("rel", "");
		return model;
	}

}
