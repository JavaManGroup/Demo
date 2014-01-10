package com.sun.app.process.admin.culture;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.core.util.StringUtil;

public class DeleteContentProcess extends AjaxDwzResultProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		Integer r = 0;
		r = getServMgr().getCultureService().deleteContent(request,
				getIP(request));
		if (r == -1) {
			model.putAll(ForwardJson(300, "未找到您要删除的记录", appName, "culture.do"));
			return model;
		}
		if (r == -2) {
			model
					.putAll(ForwardJson(300, "请您不要删除全部企业文化", appName,
							"culture.do"));
			return model;
		}
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
