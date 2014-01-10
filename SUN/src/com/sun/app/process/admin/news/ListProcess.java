package com.sun.app.process.admin.news;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.PagingBaseProcess;
import com.sun.core.common.PagingList;

public class ListProcess extends PagingBaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String typeId = "0";
		typeId = request.getParameter("typeId");
		if (typeId != "0") {
			PagingList allNews = getServMgr().getNewsService()
					.getPageNewsListByTypeId(request);
			model.put("allNews", allNews);
		} else {
			PagingList allNews = getServMgr().getNewsService().getPageNewsList(
					request);
			model.put("allNews", allNews);
		}

		List allType = getServMgr().getNewsService().getAllNewsType();
		model.put("allType", allType);
		return model;
	}

}