package com.sun.app.process.eventapp;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.app.Message;
import com.sun.app.common.Process;
import com.sun.app.common.Result;
import com.sun.core.Constants;
import com.sun.core.util.MD5;
import com.sun.dao.SysUserMapper;
import com.sun.vo.SysUser;
import com.sun.vo.SysUserExample;

public class LoginProcess extends Process {
	@Autowired
	private SysUserMapper userDAO;

	@Override
	public Result process(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		HashMap<String, Object> model = new HashMap<String, Object>();
		String method = request.getMethod();
		if (method == "POST") {
			String userName = request.getParameter("username");
			String passWord = request.getParameter("password");

			String rand = (String) request.getSession().getAttribute("rand");
			String code = request.getParameter("code");
			System.out.println(rand);
			System.out.println(code);
			if (!rand.equals(code)) {
				model.put("errorInfo", Message.LOGIN_CODE_ERR);
				return new Result(this.getFailureView(), model);
			}
			String md5Pwd = MD5.getMD5ofStr(passWord);
			System.out.println(MD5.getMD5ofStr(passWord));
			SysUserExample example = new SysUserExample();
			example.createCriteria().andUsernameEqualTo(userName);
			List<SysUser> dbUser = userDAO.selectByExample(example);
			if (!dbUser.isEmpty()
					&& dbUser.get(0).getPassword().equals(
							MD5.getMD5ofStr(passWord))) {
				System.out.println("登录成功");
				request.getSession().invalidate();
				request.getSession().setAttribute(Constants.LOGIN_USER, dbUser.get(0));
				return new Result(null, null, "/admin/root.do", true, model);
			}
			if (dbUser.isEmpty()) {
				model.put("errorInfo", Message.LOGIN_NOT_EXISTS);
				return new Result(this.getFailureView(), model);
			}
			// 密码错误
			if (!md5Pwd.equals((String) dbUser.get(0).getPassword())) {
				model.put("errorInfo", Message.LOGIN_WRONG_PASS);
				return new Result(this.getFailureView(), model);
			}

			System.out.println(rand);
			System.out.println(code);

		}else{
			request.getSession().removeAttribute(Constants.LOGIN_USER);
			request.getSession().invalidate();
		}
		return new Result(this.getFailureView(), model);
	}

	public String getIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("x-forward-for");
			if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
		}
		return ip;
	}
}