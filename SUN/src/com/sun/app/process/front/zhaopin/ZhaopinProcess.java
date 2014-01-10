package com.sun.app.process.front.zhaopin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.PagingBaseProcess;
import com.sun.core.common.PagingList;

public class ZhaopinProcess extends PagingBaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		PagingList list = getServMgr().getZhaopinService().getHomePagingList(request);
		model.put("allZhaopin", list);
		List links = getServMgr().getLinkService().getHomeLink();
		model.put("links", links);
		Map map=getServMgr().getContactService().queryForMap(1);
		model.put("contact", map);
		String flashPath = getServMgr().getSysService().queryForFlash();
		model.put("fpath", flashPath);
		return model;
	}

}