package com.sun.app.process.admin.news;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;
import com.sun.vo.SysNews;
import com.sun.vo.SysUser;

public class AddProcess extends AjaxDwzResultProcess {

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
			model.putAll(ForwardJson(300, "请输入新闻内容", appName));
			return model;
		}
		int r = getServMgr().getNewsService().add(request, getIP(request));
		if (r > 0) {
			model.putAll(ForwardJson(200, "操作成功", appName, "news.do"));
		} else {
			model.putAll(ForwardJson(300, "操作失败", appName, "news.do"));
		}
		return model;
	}

}