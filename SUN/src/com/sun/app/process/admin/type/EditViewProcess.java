package com.sun.app.process.admin.type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;
import com.sun.vo.SysNewsType;

public class EditViewProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String userId = request.getParameter("uid");
		String typeId = request.getParameter("typeId");
		SysNewsType type = getServMgr().getNewsService().getNewsTypeById(typeId);
		model.put("type", type);
		return model;
	}

}