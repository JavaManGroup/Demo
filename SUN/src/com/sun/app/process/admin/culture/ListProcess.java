package com.sun.app.process.admin.culture;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;
import com.sun.app.process.PagingBaseProcess;

public class ListProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String typeId = request.getParameter("cultureId");
		String url = "culture.do?command=listQQcultureId=" + typeId;
		model.put("url", url);
		List allCulture = getServMgr().getCultureService().getCultureList(
				typeId);
		model.put("allCulture", allCulture);
		model.put("cultureType", typeId);
		return model;
	}

}