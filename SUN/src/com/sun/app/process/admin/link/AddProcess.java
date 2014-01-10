package com.sun.app.process.admin.link;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.AjaxDwzResultProcess;
import java.util.regex.*;

public class AddProcess extends AjaxDwzResultProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("添加友情链接");
		String url = request.getParameter("url");
//		if (!isHomepage(url)) {
//			model.putAll(ForwardJson(300, "请正确输入网址格式", appName, "link.do"));
//			return model;
//		}
		int r = getServMgr().getLinkService().add(request, getIP(request));
		if (r > 0) {
			model.putAll(ForwardJson(200, "操作成功", appName, "link.do"));
		} else {
			model.putAll(ForwardJson(300, "操作失败", appName, "link.do"));
		}
		return model;
	}

	public boolean isHomepage(String str) {
		String regex = "http://(([a-zA-z0-9]|-){1,}\\.){1,}[a-zA-z0-9]{1,}-*";
		return match(regex, str);
	}

	private boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

}