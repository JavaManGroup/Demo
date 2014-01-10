package com.sun.app.process.front.news;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.PagingBaseProcess;
import com.sun.core.common.PagingList;

public class NewsListProcess extends PagingBaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String typeId = request.getParameter("typeId");
		List allType  = getFsMgr().getFrontnewsService().getAllType();
		PagingList addNews = getFsMgr().getFrontnewsService().getNewsPageListByTypeId(typeId, request);
		model.put("addNews", addNews);
		model.put("allType", allType);
		Map typeMap  = getFsMgr().getFrontnewsService().getTypeMap(typeId);
		model.put("typeMap", typeMap);
		String flashPath = getServMgr().getSysService().queryForFlash();
		model.put("fpath", flashPath);
		return model;
	}

}