package com.sun.app.process.admin.protype;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.PagingBaseProcess;

public class ListProcess extends PagingBaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		List aLlProjectType = getServMgr().getAdminProjectService()
				.getALlProjectType();
		Iterator it = aLlProjectType.iterator();
		while (it.hasNext()) {
			Map next = (Map) it.next();
			Integer typeId = (Integer)next.get("id");
			Integer count = getServMgr().getAdminProjectService().getProjectCountByTypeId(typeId);
			next.put("count", count);
		}
		model.put("allProtype", aLlProjectType);
		return model;
	}

}