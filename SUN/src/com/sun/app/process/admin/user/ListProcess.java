package com.sun.app.process.admin.user;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.PagingBaseProcess;
import com.sun.core.common.PagingList;

public class ListProcess extends PagingBaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		
		PagingList allUsers = getServMgr().getUserService()
				.getAllUsers(request);
		model.put("allUsers", allUsers);
		return model;
	}

}