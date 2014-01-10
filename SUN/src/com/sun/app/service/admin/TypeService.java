package com.sun.app.service.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.sun.app.service.BaseService;
import com.sun.dao.SysNewsTypeMapper;
import com.sun.util.ClassUtil;
import com.sun.vo.Culture;
import com.sun.vo.SysNewsType;

public class TypeService extends BaseService {

	@Autowired
	private SysNewsTypeMapper mapper;

	@Override
	public Integer add(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		try {
			return mapper.deleteByPrimaryKey(Integer.valueOf(request
					.getParameter("typeId")));
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public Integer update(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		int r = 0;
		try {

			SysNewsType o = (SysNewsType) ClassUtil.convert(request,
					SysNewsType.class);
			r = mapper.updateByPrimaryKeySelective(o);
		} catch (Exception e1) {
		}
		return r;
	}

}
