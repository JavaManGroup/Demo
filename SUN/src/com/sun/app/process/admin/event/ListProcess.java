package com.sun.app.process.admin.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

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
		PagingList allEvent = getServMgr().getEventService().getAllEventPaging(
				request);
		model.put("allEvent", allEvent);
		request.getSession().setAttribute("pageNum", allEvent.getPageNum());
		return model;
	}

}