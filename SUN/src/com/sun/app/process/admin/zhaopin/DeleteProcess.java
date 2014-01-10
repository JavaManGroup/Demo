package com.sun.app.process.admin.zhaopin;

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
		String zhaopinId = request.getParameter("zhaopinId");
		Integer r = 0;
		r = getServMgr().getZhaopinService().delete(request, getIP(request));
		if (r > 0) {
			model.putAll(ForwardJson(200, "操作成功", appName,"zhaopin.do"));
		} else {
			model.putAll(ForwardJson(300, "操作失败", appName,"zhaopin.do"));
		}

		return model;
	}

}
