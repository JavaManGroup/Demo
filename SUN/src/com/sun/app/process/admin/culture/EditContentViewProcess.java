package com.sun.app.process.admin.culture;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;

public class EditContentViewProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		List list = getServMgr().getCultureService().getCultureListStaticType();
		model.put("listType", list);
		String contentId = request.getParameter("contentId");
		Map map  = getServMgr().getCultureService().getCultureContentMap(contentId);
		model.put("content", map);
		return model;
	}

}