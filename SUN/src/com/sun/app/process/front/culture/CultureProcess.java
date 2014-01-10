package com.sun.app.process.front.culture;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.PagingBaseProcess;

public class CultureProcess extends PagingBaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		List cultureList = getServMgr().getCultureService()
				.getHomeCultureList();
		model.put("allCulture", cultureList);
		model.put("culture", cultureList.get(0));
		Map map = new HashMap();
		String flashPath = getServMgr().getSysService().queryForFlash();
		model.put("fpath", flashPath);
		map.isEmpty();
		return model;
	}

}