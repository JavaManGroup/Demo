package com.sun.app.process.admin.user;

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
		String userId = request.getParameter("userId");
		Integer r = getServMgr().getUserService().deleteUser(
				StringUtil.valueOf(userId));
		if (r > 0) {
			model.putAll(ForwardJson(200, "用户删除成功", appName));
		} else {
			model.putAll(ForwardJson(300, "操作失败", appName));
		}

		return model;
	}

}
