package com.sun.app.process.admin.about;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;

public class EditViewProcess extends BaseProcess {

	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		System.out.println("11111");
		Map map=getServMgr().getAboutService().queryForMap(1);
		model.put("about", map);
		return model;
	}
	
}
