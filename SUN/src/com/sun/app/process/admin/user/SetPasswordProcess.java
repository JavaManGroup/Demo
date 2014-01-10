package com.sun.app.process.admin.user;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.app.process.BaseProcess;
import com.sun.app.process.DefaultProcess;
import com.sun.core.util.MD5;
import com.sun.dao.SysUserMapper;
import com.sun.vo.SysUser;

public class SetPasswordProcess extends AjaxDwzResultProcess {
	@Autowired
	private SysUserMapper userMapper;

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub

		String userId = request.getParameter("userId");
		String oldPass = request.getParameter("oldPass");
		String newPass = request.getParameter("newPass");
		SysUser dbUser = userMapper.selectByPrimaryKey(Integer.valueOf(userId));
		if (MD5.verifyPassword(oldPass, dbUser.getPassword())) {
			String md5Pwd = MD5.getMD5ofStr(newPass);
			SysUser u = new SysUser();
			u.setId(Integer.valueOf(userId));
			u.setPassword(md5Pwd);
			int r = userMapper.updateByPrimaryKeySelective(u);
			if (r > 0) {
				model.putAll(ForwardJson(200, "操作成功", appName));
				return model;
			}
		}
		model.putAll(ForwardJson(300, "操作失败", appName));
		return model;

	}

}