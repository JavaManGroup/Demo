package com.sun.app.process.admin.group;

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
		model.put("navTabId", "group");
		model.put("callbackType", "forward");
		model.put("forwardUrl", "group.do?command=list");
		boolean isExist = getServMgr().getGroupService().isExist(
				request.getParameter("groupName"));
		if (!isExist) {
			getServMgr().getGroupService().addUserGroup(
					request.getParameterMap(), getIP(request));
			model.put("statusCode", "200");
			model.put("message", "操作成功");
			model.put("rel", "");
		} else {
			model.put("statusCode", "300");
			model.put("message", "操作失败-用户组名称已存在");
			model.put("rel", "");

		}

		return model;
	}

}