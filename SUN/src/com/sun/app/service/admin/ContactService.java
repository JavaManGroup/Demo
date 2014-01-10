package com.sun.app.service.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.app.service.BaseService;
import com.sun.dao.ContactMapper;
import com.sun.util.ClassUtil;
import com.sun.vo.Contact;

public class ContactService extends BaseService{
	@Autowired
	private ContactMapper mapper;
	public Integer add(HttpServletRequest request, String ip) {
		
		return null;
	}

	public Integer delete(HttpServletRequest request, String ip) {

		return null;
	}

	public Integer update(HttpServletRequest request, String ip) {
		try {
			Contact o = (Contact)ClassUtil.convert(request, Contact.class);
			return mapper.updateByPrimaryKeySelective(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return 0;
	}
	
	private static final String QUERY_CONATCT_MAP = "select * from contact where id = ?"; 
	
	public Map queryForMap(int id){
		Map<String, Object> map = jt.queryForMap(QUERY_CONATCT_MAP, id);
		return map;
	}
	
}
