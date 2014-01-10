package com.sun.app.process.admin.honour;

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
		String Id = request.getParameter(appName + "Id");
		System.out.println(Id);
		Map honour = getServMgr().getHonourService().querForMap(Id);
		System.out.println(honour);
		model.put("honour", honour);
		return model;
	}

}