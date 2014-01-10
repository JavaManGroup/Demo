package com.sun.app.process.admin.group;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.core.util.StringUtil;
import com.sun.dao.SysGroupMapper;

public class DeleteProcess extends AjaxDwzResultProcess {

	@Autowired
	private SysGroupMapper groupMapper;

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		model.put("navTabId", "user");
		model.put("callbackType", "forward");
		model.put("forwardUrl", "");
		String gid = request.getParameter("groupId");
		int r = groupMapper.deleteByPrimaryKey(Integer.valueOf(gid));
		if (r > 0) {
			model.put("statusCode", "200");
			model.put("message", "操作成功");
		} else {
			model.put("statusCode", "300");
			model.put("message", "操作失败");
		}

		model.put("rel", "");
		return model;
	}

}
