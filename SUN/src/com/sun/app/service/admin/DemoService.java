package com.sun.app.service.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sun.app.service.BaseService;
import com.sun.core.common.PagingList;

public class DemoService extends BaseService {

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
		return null;
	}

	private static final String ALL_ZHAOPIN_PAGE = "SELECT * FROM zhaopin";

	public PagingList queryForPagingList(HttpServletRequest request) {
		return getPagingList(ALL_ZHAOPIN_PAGE, request);
	}

	public Object queryForObject(Integer id) {
		return null;
	}

	public Map queryForMap() {
		return null;
	}

	public List queryForList() {
		return null;
	}

}
