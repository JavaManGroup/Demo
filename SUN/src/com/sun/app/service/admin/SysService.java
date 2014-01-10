package com.sun.app.service.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.app.service.BaseService;
import com.sun.dao.FlashMapper;
import com.sun.util.ClassUtil;
import com.sun.vo.Flash;

public class SysService extends BaseService {
	@Autowired
	private FlashMapper mapper;

	@Override
	public Integer add(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		try {
			String path = request.getParameter("dwz.attachment.fileName");
			Flash o = (Flash) ClassUtil.convert(request, Flash.class);
			o.setId(1);
			o.setPath(path);
			return mapper.updateByPrimaryKeySelective(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return 0;
	}

	public String queryForFlash() {
		Map<String, Object> flash = jt.queryForMap("select path from flash where id = 1");
		return (String) flash.get("path");
	}

}
