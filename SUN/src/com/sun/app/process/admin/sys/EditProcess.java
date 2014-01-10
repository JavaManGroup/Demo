package com.sun.app.process.admin.sys;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;

public class EditProcess extends AjaxDwzResultProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String path = request.getParameter("dwz.attachment.fileName");
		if (path.isEmpty()) {
			model.putAll(ForwardJson(300, "请上传flash", appName,
					"sys.do?command=flash"));
			return model;
		}
		int r = getServMgr().getSysService().update(request, getIP(request));
		model.putAll(ForwardJson(200, "操作成功", appName, "sys.do?command=flash"));
		return model;
	}

}