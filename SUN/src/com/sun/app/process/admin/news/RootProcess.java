package com.sun.app.process.admin.news;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.PagingBaseProcess;
import com.sun.core.common.PagingList;

public class RootProcess extends PagingBaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		
		List allType = getServMgr().getNewsService().getAllNewsType();
		model.put("allType", allType);
		String page = request.getParameter("page");
		if(page!=null)
			if (request.getMethod() == "POST" && page.equals("false")) {
				doPost(request, response, model);
				return model;
			}
			
		
		PagingList allNews = getServMgr().getNewsService().getPageNewsList(
				request);
		model.put("allNews", allNews);
		
		model.put("typeId", 0);
		return model;
	}

	public HashMap<String, Object> doPost(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		String typeId = request.getParameter("typeId");
		
		PagingList allNews = getServMgr().getNewsService().search(request);
		model.put("allNews", allNews);
		return model;
	}

}