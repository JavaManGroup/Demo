package com.sun.app.process.admin.event;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;


public class AddViewProcess extends BaseProcess {
	
	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		List eventUser  = getServMgr().getEventService().getEventUsers();
		model.put("eventUser", eventUser);
		System.out.println("用户组添加窗口");
		return model;
	}
	
}