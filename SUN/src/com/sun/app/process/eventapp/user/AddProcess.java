package com.sun.app.process.eventapp.user;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.app.process.BaseProcess;
import com.sun.core.util.MD5;
import com.sun.dao.EventUserMapper;
import com.sun.util.TimeUtil;
import com.sun.vo.EventUser;
import com.sun.vo.EventUserExample;

public class AddProcess extends BaseProcess {
	@Autowired
	private EventUserMapper userMapper;

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		EventUser u = new EventUser();
		u.setEmail(request.getParameter("email"));
		u.setNick(request.getParameter("nick"));
		String md5Str = MD5.getMD5ofStr(request.getParameter("password"));
		u.setPassword(md5Str);
		try {
			u.setSid(String.valueOf(new Date().getTime()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		EventUserExample ByNick = new EventUserExample();
		ByNick.createCriteria().andNickEqualTo(u.getNick());
		int countByNick = userMapper.countByExample(ByNick);
		if (countByNick > 0) {
			System.out.println("注册失败nick重复");
			return model;
		}
		EventUserExample ByEmail = new EventUserExample();
		ByEmail.createCriteria().andEmailEqualTo(u.getEmail());
		int countByEmail = userMapper.countByExample(ByEmail);
		if (countByEmail > 0) {
			System.out.println("注册失败email重复");
			return model;
		}
		if (countByNick == 0 && countByEmail == 0) {
			u.setRegisterip(getIP(request));
			u.setRegistertime(TimeUtil.dateToDatetime(new Date()));
			int r = userMapper.insert(u);
			if (r > 0) {
				System.out.println("注册成功");
			}

		}
		return model;
	}
}