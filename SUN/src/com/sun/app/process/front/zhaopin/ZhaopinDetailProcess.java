package com.sun.app.process.front.zhaopin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;

public class ZhaopinDetailProcess extends BaseProcess{

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		Map zhaopin = getServMgr().getZhaopinService().queryForMap(request);
		model.put("zhaopin", zhaopin);
		Map map=getServMgr().getContactService().queryForMap(1);
		model.put("contact", map);
		String flashPath = getServMgr().getSysService().queryForFlash();
		model.put("fpath", flashPath);
		return model;
	}

}
