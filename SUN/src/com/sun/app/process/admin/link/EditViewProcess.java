package com.sun.app.process.admin.link;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;

public class EditViewProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String linkId = request.getParameter("linkId");
		Map link = getServMgr().getLinkService().queryForMap(
				Integer.valueOf(linkId));
		System.out.println(link);
		model.put("link", link);
		return model;
	}

}