package com.sun.app.process.admin.link;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;
import com.sun.app.process.PagingBaseProcess;
import com.sun.core.common.PagingList;

public class DefaultProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		PagingList Links = getServMgr().getLinkService().queryForPagingList(
				request);
		System.out.println(Links);
		model.put("pageLink", Links);
		return model;
	}

}