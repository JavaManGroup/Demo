package com.sun.app.process.admin.event;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;

public class AddProcess extends AjaxDwzResultProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		model.put("navTabId", "event.do");
		model.put("callbackType", "forward");
		model.put("forwardUrl", "event.do?command=list&pageNum="
				+ request.getAttribute("pageNum"));
		System.out.println("asdfsdf");
		getServMgr().getEventService().addEventInAdmin(request,
				getIP(request));
		return model;
	}

}