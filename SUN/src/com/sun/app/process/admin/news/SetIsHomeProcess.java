package com.sun.app.process.admin.news;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.app.process.BaseProcess;

public class SetIsHomeProcess extends AjaxDwzResultProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// AJAX 设置首页显示

		Integer r = getServMgr().getNewsService().setIsHome(request);
		String pageNum = request.getParameter("pageNum");
		if (r > 0) {
			model.putAll(ForwardJson(200, "操作成功", appName, "news.do?pageNum="
					+ pageNum));
		} else {
			model.putAll(ForwardJson(300, "操作失败", appName, "news.do?pageNum="
					+ pageNum));
		}
		return model;
	}

}
