package com.sun.app.process.admin.culture;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;

public class EditContentProcess extends AjaxDwzResultProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		Integer r = getServMgr().getCultureService().updateContent(request,
				getIP(request));
		String url = request.getParameter("url");
		try {
			url = url.replaceAll("Q", "&");
		} catch (Exception e) {
			url = "culture.do";
		}
		if (r > 0) {
			model.putAll(ForwardJson(200, "操作成功", appName, url));
		} else {
			model.putAll(ForwardJson(300, "操作失败", appName, url));
		}
		return model;
	}

}