package com.sun.app.process.admin.protype;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;

public class AddProcess extends AjaxDwzResultProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String fileName = request.getParameter("dwz.attachment.fileName");
		if(fileName.isEmpty()){
			model.putAll(ForwardJson(300, "请上传图片", appName));
			return model;
		}
		if(fileName.equals("上传格式错误")){
			model.putAll(ForwardJson(300, "上传文件格式错误", appName));
			return model;
		}
		Integer r = getServMgr().getAdminProjectService().addProjectType(request);
		
		if (r > 0)
			model.putAll(ForwardJson(200, "操作成功", appName));
		else
			model.putAll(ForwardJson(300, "操作失败", appName));
		return model;
	}

}