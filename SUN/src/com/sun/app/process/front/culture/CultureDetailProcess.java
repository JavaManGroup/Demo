package com.sun.app.process.front.culture;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.PagingBaseProcess;

public class CultureDetailProcess extends PagingBaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String clid = request.getParameter("clid");
		List cultureList = getServMgr().getCultureService()
				.getHomeCultureList();
		
		Map cert = getServMgr().getCultureService().getHomeCultureCert(clid);
		model.put("allCulture", cultureList);
		model.put("cert", cert);
		String flashPath = getServMgr().getSysService().queryForFlash();
		model.put("fpath", flashPath);
		return model;
	}

}