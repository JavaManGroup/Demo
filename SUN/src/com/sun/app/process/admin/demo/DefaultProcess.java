package com.sun.app.process.admin.demo;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;
import com.sun.app.process.PagingBaseProcess;


public class DefaultProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		List allCulture = getServMgr().getCultureService().getCultures();
		System.out.println(allCulture);
		model.put("allCulture", allCulture);
		return model;
	}
	
}