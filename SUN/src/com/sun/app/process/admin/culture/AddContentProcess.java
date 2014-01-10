package com.sun.app.process.admin.culture;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;

public class AddContentProcess extends AjaxDwzResultProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String typeId = request.getParameter("typeId");
		String content = request.getParameter("content");
		if (typeId.equals("0")) {
			model.putAll(ForwardJson(300, "请选择分类", appName));
			return model;
		}
		if (content.isEmpty()) {
			model.putAll(ForwardJson(300, "请输入文章内容", appName));
			return model;
		}
		String url = request.getParameter("url");
		try {
			url = url.replaceAll("Q", "&");
		} catch (Exception e) {
			url = "culture.do";
		}
		Integer r = getServMgr().getCultureService().addContext(request,
				getIP(request));
		model.putAll(ForwardJson(200, "用户添加成功", appName, url));
		return model;
	}

}