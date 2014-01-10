package com.sun.app.process.admin.user;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;
import com.sun.core.Constants;
import com.sun.core.util.MD5;
import com.sun.dao.SysUserMapper;
import com.sun.vo.SysUser;

public class SetViewProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		
		Object user = request.getSession().getAttribute(Constants.LOGIN_USER);
		SysUser u = (SysUser) user;
		model.put("userId", u.getId());
		return model;
	}

}