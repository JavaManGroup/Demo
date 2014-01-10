package com.sun.app.process.front.best;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;
import com.sun.app.process.PagingBaseProcess;
import com.sun.core.common.PagingList;


public class BestProcess extends PagingBaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		PagingList allGroupPaging = getServMgr().getGroupService().getAllGroupPaging(request);
		model.put("allGroup", allGroupPaging);
		String flashPath = getServMgr().getSysService().queryForFlash();
		model.put("fpath", flashPath);
		request.getSession().setAttribute("pageNum", allGroupPaging.getPageNum());
		return model;
	}
	
}