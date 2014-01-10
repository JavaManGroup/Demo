package com.sun.app.process.front.honour;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;

public class HonourDetailProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		String honourId = request.getParameter("honourId");
		Map honour =getFsMgr().getProjectService().getHonour(honourId);
		List  detail = getFsMgr().getProjectService().getHonourDetail(honourId);
		model.put("detail", detail);
		model.put("honour", honour);
		String flashPath = getServMgr().getSysService().queryForFlash();
		model.put("fpath", flashPath);
		return model;
	}
}
