package com.sun.app.process.admin.link;

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
		int r = getServMgr().getLinkService().delete(request, getIP(request));
		if (r > 0) {
			model.putAll(ForwardJson(200, "操作成功", appName, "link.do"));
		} else {
			model.putAll(ForwardJson(300, "操作失败", appName, "link.do"));
		}
		return model;
	}

}
