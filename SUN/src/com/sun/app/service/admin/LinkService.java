package com.sun.app.service.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.app.service.BaseService;
import com.sun.core.common.PagingList;
import com.sun.dao.LinkMapper;
import com.sun.util.ClassUtil;
import com.sun.vo.Link;

public class LinkService extends BaseService {

	@Autowired
	private LinkMapper mapper;

	@Override
	public Integer add(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		try {
			Link o = (Link) ClassUtil.convert(request, Link.class);

			return mapper.insert(o);

		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public Integer delete(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		try {
			String id = request.getParameter("linkId");
			int r = mapper.deleteByPrimaryKey(Integer.valueOf(id));
			return r;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return 0;
		}
	}

	@Override
	public Integer update(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		try {
			Link o = (Link) ClassUtil.convert(request, Link.class);

			return mapper.updateByPrimaryKeySelective(o);

		} catch (Exception e) {
			return -1;
		}
	}

	private static final String LINKS_PAGE = "select * from link order by sort";

	public PagingList queryForPagingList(HttpServletRequest request) {
		return getPagingList(LINKS_PAGE, request);
	}

	private static final String LINK_BY_ID = "select * from link WHERE id = ?";

	public Map queryForMap(Integer id) {
		return jt.queryForMap(LINK_BY_ID, id);
	}

	public Integer getSortMax() {
		return getMax("sort", "link");
	}

	private static final String HOME_LINK = "SELECT * FROM link WHERE status = 1";

	public List getHomeLink() {
		// TODO Auto-generated method stub
		return jt.queryForList(HOME_LINK);
	}

}
