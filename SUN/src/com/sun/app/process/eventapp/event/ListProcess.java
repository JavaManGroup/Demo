package com.sun.app.process.eventapp.event;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;
import com.sun.app.process.PagingBaseProcess;
import com.sun.core.common.PagingList;


public class ListProcess extends PagingBaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		PagingList allEventPaging = getServMgr().getEventService().getAllEventHome(request);
		model.put("allEvent", allEventPaging);
		System.out.println(allEventPaging.getList());
		request.getSession().setAttribute("pageNum", allEventPaging.getPageNum());
		return model;
	}
	
}