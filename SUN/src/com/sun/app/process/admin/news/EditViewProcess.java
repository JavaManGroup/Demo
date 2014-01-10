package com.sun.app.process.admin.news;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;
import com.sun.vo.News;

public class EditViewProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		
		String newsId = request.getParameter("newsId");
		News news = (News) getServMgr().getNewsService().queryForObject(
				Integer.valueOf(newsId));
		model.put("news", news);
		List allType = getServMgr().getNewsService().getAllNewsType();
		model.put("allType", allType);
		return model;
	}

}