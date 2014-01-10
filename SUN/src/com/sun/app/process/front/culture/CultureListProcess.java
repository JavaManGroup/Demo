package com.sun.app.process.front.culture;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;
import com.sun.app.process.PagingBaseProcess;
import com.sun.core.common.PagingList;

public class CultureListProcess extends PagingBaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		PagingList list = getServMgr().getCultureService()
				.getHomeCultureImageList(request);
		String typeId = request.getParameter("cultureId");
		List cultureList = getServMgr().getCultureService()
				.getHomeCultureList();
		model.put("allCulture", cultureList);
		model.put("list", list);
		model.put("culture", cultureList.get(0));
		String flashPath = getServMgr().getSysService().queryForFlash();
		model.put("fpath", flashPath);
		return model;
	}

}