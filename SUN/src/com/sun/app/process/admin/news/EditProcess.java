package com.sun.app.process.admin.news;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;

public class EditProcess extends AjaxDwzResultProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("修改新闻");
		Integer r = getServMgr().getNewsService().update(request,getIP(request));
		model.putAll(ReturnJson(200, "操作成功", "add", "", "forward","news.do"));
		return model;
	}

}