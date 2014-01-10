package com.sun.app.process.admin.group;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;
import com.sun.dao.SysGroupMapper;
import com.sun.vo.SysGroup;

public class EditViewProcess extends BaseProcess {
	@Autowired
	private SysGroupMapper groupMapper;

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		String groupId = request.getParameter("groupId");
		SysGroup dbGroup = groupMapper.selectByPrimaryKey(Integer
				.valueOf(groupId));
		model.put("group", dbGroup);
		return model;
	}

}