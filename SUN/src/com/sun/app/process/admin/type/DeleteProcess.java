package com.sun.app.process.admin.type;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.core.util.StringUtil;

public class DeleteProcess extends AjaxDwzResultProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String typeId = request.getParameter("typeId");
		Integer r = 0;
		r = getServMgr().getTypeService().delete(request, getIP(request));
		if (r == -1) {
			model.putAll(ForwardJson(300, "请您提前清空该分类下的全部文章", appName,"type.do"));
			return model;
		}
		if (r > 0) {
			model.putAll(ForwardJson(200, "操作成功", appName, "type.do"));
		} else {
			model.putAll(ForwardJson(300, "操作失败", appName, "type.do"));
		}
		return model;
	}

}
