package com.sun.app.service.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.sun.app.service.BaseService;
import com.sun.core.common.PagingList;
import com.sun.dao.ZhaopinMapper;
import com.sun.util.ClassUtil;
import com.sun.vo.News;
import com.sun.vo.Zhaopin;

public class ZhaopinService extends BaseService {

	@Autowired
	private ZhaopinMapper mapper;

	@Override
	public Integer add(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		try {
			Zhaopin o = (Zhaopin) ClassUtil.convert(request, Zhaopin.class);
			o.setUpdateIp(ip);
			return mapper.insert(o);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 0;
	}

	@Override
	public Integer delete(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		String zhaopinId = request.getParameter("zhaopinId");
		String[] arrayId = zhaopinId.split(",");
		Integer count = 0;
		for (int i = 0; i < arrayId.length; i++) {
			int r = mapper.deleteByPrimaryKey(Integer.valueOf(arrayId[i]));
			count = count + r;
		}
		return count;

	}

	@Override
	public Integer update(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		try {
			Zhaopin o = (Zhaopin) ClassUtil.convert(request, Zhaopin.class);
			o.setUpdateIp(ip);
			return mapper.updateByPrimaryKeySelective(o);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			return 0;
		}

	}

	private static final String ALL_ZHAOPIN_PAGE = "SELECT n.*,u.realname FROM zhaopin n,sys_user u where n.user_id = u.id order by n.updatetime desc";

	public PagingList queryForPagingList(HttpServletRequest request) {
		request.setAttribute("pageSize", 20);
		return getPagingList(ALL_ZHAOPIN_PAGE, request);
	}

	public Object queryForObject(Integer id) {
		return null;
	}

	private static final String BYID_ZHAOPIN_MAP = "SELECT n.*,u.realname FROM zhaopin n,sys_user u where n.user_id = u.id AND n.id = ?";

	public Map queryForMap(HttpServletRequest request) {
		try {
			return jt.queryForMap(BYID_ZHAOPIN_MAP, request
					.getParameter("zhaopinId"));
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List queryForList() {
		return null;
	}

	public PagingList getHomePagingList(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("pageSize", 10);
		return getPagingList(ALL_ZHAOPIN_PAGE, request);
	}

	public List homeSearch(String s, HttpServletRequest request) {
		// TODO Auto-generated method stub
		String SEARCH_SQL = "SELECT * FROM zhaopin WHERE title like '%"+s+"%'";
		return  jt.queryForList(SEARCH_SQL);
	}

}
