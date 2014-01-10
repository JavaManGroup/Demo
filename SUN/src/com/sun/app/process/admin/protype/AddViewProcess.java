package com.sun.app.process.admin.protype;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;


public class AddViewProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("(((((((((((9");
		Integer max = getServMgr().getAdminProjectService().getMaxSort();
		model.put("maxProtypeSort", max+1);
		return model;
	}
	
}