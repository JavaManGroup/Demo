package com.sun.app.service.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.app.service.BaseService;
import com.sun.core.common.PagingList;
import com.sun.dao.CultureListMapper;
import com.sun.dao.CultureMapper;
import com.sun.util.ClassUtil;
import com.sun.vo.Culture;
import com.sun.vo.CultureList;
import com.sun.vo.Honour;

public class CultureService extends BaseService {

	@Autowired
	private CultureMapper mapper;
	@Autowired
	private CultureListMapper listMapper;

	@Override
	public Integer add(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		int r = 0;
		try {

			Culture o = (Culture) ClassUtil.convert(request, Culture.class);
			r = mapper.insert(o);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return r;
	}

	@Override
	public Integer delete(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		int countByExample = mapper.countByExample(null);
		if (countByExample == 1)
			return -2;
		try {
			Integer id = Integer.valueOf(request.getParameter("cultureId"));
			return mapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	@Override
	public Integer update(HttpServletRequest request, String ip) {
		int r = 0;
		try {

			Culture o = (Culture) ClassUtil.convert(request, Culture.class);
			r = mapper.updateByPrimaryKeySelective(o);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return r;
	}

	private final static String CULTURE_LIST = "SELECT c.*,u.realname FROM culture_list c ,sys_user u where c.user_id=u.id AND type_id = ?";
	private final static String CULTURES = "SELECT c.*,u.realname FROM culture c ,sys_user u where c.user_id=u.id order by c.sort";

	public List getCultures() {
		// TODO Auto-generated method stub
		return jt.queryForList(CULTURES);
	}

	public List getCultureList(String typeId) {
		// TODO Auto-generated method stub
		return jt.queryForList(CULTURE_LIST, typeId);
	}

	private final static String CULTURE_LIST_HOME = "SELECT c.*,u.realname FROM culture c ,sys_user u where c.user_id=u.id order by sort";

	public List getHomeCultureList() {
		return jt.queryForList(CULTURE_LIST_HOME);
	}

	private final static String CULTURE_MAP = "SELECT * FROM culture WHERE id = ?";

	public Map getCultureMap(String cultureId) {
		// TODO Auto-generated method stub
		return jt.queryForMap(CULTURE_MAP, cultureId);
	}

	private final static String CULTURE_IMAGE_LIST = "SELECT * FROM culture_list WHERE type_id = ? order by updatetime desc";

	public PagingList getHomeCultureImageList(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String typeId = request.getParameter("cultureId");
		request.setAttribute("pageSize", 10);
		return getPagingList(CULTURE_IMAGE_LIST, request, typeId);
	}

	private final static String CULTURE_CERT_MAP = "SELECT * FROM culture_list WHERE id  = ?";

	public Map getHomeCultureCert(String clid) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = jt
				.queryForList(CULTURE_CERT_MAP, clid);
		Map<String, Object> map = list.get(0);
		return map;
	}

	private final static String CULTURE_LIST_TYPE = "SELECT * FROM culture WHERE is_static = 2";

	public List getCultureListStaticType() {
		// TODO Auto-generated method stub
		return jt.queryForList(CULTURE_LIST_TYPE);
	}

	public Integer addContext(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		int r = 0;
		try {

			CultureList o = (CultureList) ClassUtil.convert(request,
					CultureList.class);
			r = listMapper.insert(o);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return r;
	}

	public Map getCultureContentMap(String contentId) {
		// TODO Auto-generated method stub
		return jt.queryForMap(CULTURE_CERT_MAP, contentId);
	}

	public Integer updateContent(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		int r = 0;
		try {

			CultureList o = (CultureList) ClassUtil.convert(request,
					CultureList.class);
			r = listMapper.updateByPrimaryKeySelective(o);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return r;
	}

	private final static String MAX_CULTURE_SORT = "SELECT MAX(sort) FROM culture";

	public Integer getMaxCultureSort() {
		return jt.queryForInt(MAX_CULTURE_SORT) + 1;
	}

	public Integer deleteContent(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		try {
			Integer id = Integer.valueOf(request.getParameter("contentId"));
			return listMapper.deleteByPrimaryKey(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

}
