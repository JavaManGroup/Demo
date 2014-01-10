package com.sun.app.service.front;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;

import com.sun.app.service.BaseService;
import com.sun.core.common.PagingList;

public class ProjectService extends BaseService {
	private static final String PROJECT_LIST_BY_TYPEID = "SELECT id,title "
			+ "FROM project " + "WHERE type_id = ? AND is_home = 1 order by updatetime desc limit 6 ";

	public List getProjectList(Integer typeId) {
		// TODO Auto-generated method stub
		return jt.queryForList(PROJECT_LIST_BY_TYPEID, typeId);
	}

	private static final String HOME_TYPE_ID = "SELECT id,name,image "
			+ "FROM project_type " + "WHERE is_home = 1";

	public List getHomeType() {
		// TODO Auto-generated method stub
		return jt.queryForList(HOME_TYPE_ID);
	}

	private static final String PROJECT_LIST_BY_IS_HOME = "SELECT id,title,updatetime FROM project WHERE status = 1 order by updatetime desc limit 6";

	/**
	 * 精品工程
	 * 
	 * @return
	 */
	public List getProjectByIsHome() {
		// TODO Auto-generated method stub
		return jt.queryForList(PROJECT_LIST_BY_IS_HOME);
	}

	private static final String ALL_PROJECT_TYPE = "SELECT id,name,image FROM project_type order by sort";

	/**
	 * 获得全部精品工程分类
	 * 
	 * @return
	 */

	public List getALlProjectType() {
		// TODO Auto-generated method stub
		return jt.queryForList(ALL_PROJECT_TYPE);

	}

	private static final String ALL_PROJECT_TYPE_IS_TOP = "SELECT id,name FROM project_type WHERE is_top = 1 limit 4";

	/**
	 * 活动精品页面置顶LIST
	 * 
	 * @return
	 */
	public List getTopProjectType() {
		// TODO Auto-generated method stub
		return jt.queryForList(ALL_PROJECT_TYPE_IS_TOP);
	}

	private static final String GET_PROJECT_IMAGE_LIST = "select * from project_image where project_id = ?";

	public List getProjectImageByProjectId(Integer projectId) {
		// TODO Auto-generated method stub
		return jt.queryForList(GET_PROJECT_IMAGE_LIST, projectId);
	}

	private static final String GET_PROJECT_BY_ID = "SELECT p.*,t.name FROM project p,project_type t WHERE p.type_id = t.id AND p.id = ?";

	public Map getProjectById(Integer id) {
		// TODO Auto-generated method stub
		try {
			List<Map<String, Object>> list = jt.queryForList(GET_PROJECT_BY_ID,
					id);
			Map<String, Object> map = list.get(0);
			return map;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	private static final String GET_PROJECT_PAGE_LIST = "SELECT id,title,image_path FROM project WHERE type_id = ? order by updatetime desc";

	public PagingList getProjectPageList(Integer id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("pageSize", 12);
		return getPagingList(GET_PROJECT_PAGE_LIST, request, id);
	}

	private static final String GET_HONOUR_LIST = "SELECT * FROM honour where type_id = ?";

	public PagingList getHonourProject(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("pageSize", 10);
		return getPagingList(GET_HONOUR_LIST, request, 1);
	}

	public PagingList getHonourProject(HttpServletRequest request, String typeId) {
		// TODO Auto-generated method stub
		return getPagingList(GET_HONOUR_LIST, request, typeId);
	}

	public List getHonourType() {
		// TODO Auto-generated method stub
		List type = new ArrayList();
		Map type1 = new HashMap();
		type1.put("id", 1);
		type1.put("name", "荣誉业绩");
		Map type2 = new HashMap();
		type2.put("id", 2);
		type2.put("name", "获得奖项");
		Map type3 = new HashMap();
		type3.put("id", 3);
		type3.put("name", "工程业绩");
		type.add(type1);
		type.add(type2);
		return type;
	}

	private static final String HONOUR_LIST_BY_TYPE = "SELECT * FROM honour order by updatetime desc";

	public List getHonourProjectByType(String typeId) {
		// TODO Auto-generated method stub
		return jt.queryForList(HONOUR_LIST_BY_TYPE, typeId);
	}

	private static final String HONOUR_DETAIL_LIST_BY_FK_ID = "select * from honour_detail where honour_id = ?";

	public List getHonourDetail(String honourId) {
		// TODO Auto-generated method stub
		return jt.queryForList(HONOUR_DETAIL_LIST_BY_FK_ID, honourId);
	}

	private static final String HONOUR = "SELECT * FROM honour WHERE id = ?";

	public Map getHonour(String honourId) {
		// TODO Auto-generated method stub
		try {
			List<Map<String, Object>> queryForList = jt.queryForList(HONOUR,
					honourId);
			Map<String, Object> map = queryForList.get(0);
			return map;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			return null;
		}

	}

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

}
