package com.sun.app.process.admin.group;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;
import com.sun.dao.SysGroupMapper;
import com.sun.vo.SysGroup;

public class EditProcess extends AjaxDwzResultProcess {
	@Autowired
	private SysGroupMapper groupMapper;

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		model.put("navTabId", "group");
		model.put("callbackType", "forward");
		model.put("forwardUrl", "group.do");
		String groupId = request.getParameter("groupId");
		
		String groupName = null;
		String groupDes = null;
		try {
			groupName = request.getParameter("groupName");
			groupDes = request.getParameter("groupDes");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SysGroup r = new SysGroup();
		r.setId(Integer.valueOf(groupId));
		r.setGroupName(groupName);
		r.setGroupDes(groupDes);

		groupMapper.updateByPrimaryKeySelective(r);
		return model;
	}

}