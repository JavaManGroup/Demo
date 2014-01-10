package com.sun.app.process.admin.honour;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.core.util.StringUtil;

public class DelImageProcess extends AjaxDwzResultProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String imageId = request.getParameter("imageId");
		String honourId = request.getParameter("honourId");
		Integer r = getServMgr().getHonourService().deleteImages(imageId);
		model.putAll(ForwardJson(200, "操作成功", appName,"honour.do?command=editview&&honourId="+honourId));

		return model;
	}

}
