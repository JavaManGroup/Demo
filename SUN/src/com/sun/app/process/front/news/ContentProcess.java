package com.sun.app.process.front.news;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;

public class ContentProcess extends BaseProcess{

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String newsId = request.getParameter("newsId");
		Map news = getFsMgr().getFrontnewsService().getNewsContentById(newsId);
		List allType  = getFsMgr().getFrontnewsService().getAllType();
		List newsList = getFsMgr().getFrontnewsService().getNewsList(1);
		model.put("news", news);
		model.put("newsList", newsList);
		model.put("allType", allType);
		String flashPath = getServMgr().getSysService().queryForFlash();
		model.put("fpath", flashPath);
		return model;
	}

}
