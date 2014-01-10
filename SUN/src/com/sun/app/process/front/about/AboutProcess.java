package com.sun.app.process.front.about;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.BaseProcess;

public class AboutProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		Map map=getServMgr().getAboutService().queryForMap(1);
		model.put("about", map);
		String flashPath = getServMgr().getSysService().queryForFlash();
		model.put("fpath", flashPath);
		return model;
	}
	
}
