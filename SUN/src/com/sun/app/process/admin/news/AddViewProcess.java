package com.sun.app.process.admin.news;

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
		try {
			List allType = getServMgr().getNewsService().getAllNewsType();
			model.put("allType", allType);
		} catch (Exception e) {
		}
		return model;
	}

}