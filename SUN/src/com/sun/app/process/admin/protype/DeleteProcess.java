package com.sun.app.process.admin.protype;

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
		String protypeId = request.getParameter("protypeId");
		getServMgr().getAdminProjectService().deleteProjectType(protypeId);
		model.putAll(ForwardJson(200, "操作成功", appName));
		return model;
	}

}
