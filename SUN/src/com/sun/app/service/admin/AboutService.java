package com.sun.app.service.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.app.service.BaseService;
import com.sun.dao.AboutMapper;
import com.sun.util.ClassUtil;
import com.sun.vo.About;
import com.sun.vo.AboutExample;
import com.sun.vo.AboutWithBLOBs;
import com.sun.vo.Contact;

public class AboutService extends BaseService{
	
	@Autowired
	private AboutMapper mapper;
	@Override
	public Integer add(HttpServletRequest request, String ip) {
		return null;
	}

	@Override
	public Integer delete(HttpServletRequest request, String ip) {
		return null;
	}

	@Override
	public Integer update(HttpServletRequest request, String ip) {
		try {
			AboutWithBLOBs s = (AboutWithBLOBs)ClassUtil.convert(request, AboutWithBLOBs.class);
			s.setId(1);
			return mapper.updateByPrimaryKeySelective(s);
		} catch (Exception e) {
		}
		return 0;
	}
	
	private static final String QUERY_ABOUT_MAP = "select * from about where id = ?"; 
	
	public Map queryForMap(int id){
		Map<String, Object> map = jt.queryForMap(QUERY_ABOUT_MAP, id);
		return map;
	}
}
