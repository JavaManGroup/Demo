package com.sun.app.process.admin.contact;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;

public class EditViewProcess extends BaseProcess {

	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		Map map=getServMgr().getContactService().queryForMap(1);
		model.put("contact", map);
		return model;
	}
	
}
