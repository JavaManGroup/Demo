package com.sun.app.service.front;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;

import com.sun.app.service.BaseService;
import com.sun.core.common.PagingList;

public class FrontNewsService extends BaseService {
	private static final String HOME_NEWS = "SELECT id,title "
			+ "FROM news " + "WHERE is_home = 1 order by updatetime desc limit 0,6";

	/**
	 * 获得index页面的新闻
	 * 
	 * @return
	 */
	public List getHomeNews() {
		// TODO Auto-generated method stub
		return jt.queryForList(HOME_NEWS);
	}

	private static final String HOME_NEWS_TYPE = "SELECT id,name,image from sys_news_type where is_home = 1";

	/**
	 * 获得新闻页面所显示的类型
	 * 
	 * @return
	 */
	public List getNewsType() {
		// TODO Auto-generated method stub
		return jt.queryForList(HOME_NEWS_TYPE);
	}

	private static final String HOME_NEWS_BY_TYPEID = "SELECT id,title,updatetime "
			+ "FROM news " + "WHERE type_id = ? limit 4";

	/**
	 * 根据类型获得4条新闻
	 * 
	 * @param typeId
	 * @return
	 */
	public List getNewsList(Integer typeId) {
		// TODO Auto-generated method stub
		return jt.queryForList(HOME_NEWS_BY_TYPEID, typeId);
	}

	private static final String HOME_ALL_TYPE = "SELECT id,name from sys_news_type order by sort";

	/**
	 * 获得全部类型
	 * 
	 * @return
	 */
	public List getAllType() {
		// TODO Auto-generated method stub
		return jt.queryForList(HOME_ALL_TYPE);
	}

	private static final String GET_NEWS_BY_ID = "SELECT * FROM news n ,sys_news_type t WHERE n.type_id = t.id AND n.id = ?";

	public Map getNewsContentById(String newsId) {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> map = jt.queryForList(GET_NEWS_BY_ID, newsId)
					.get(0);
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	private static final String GET_NEWS_BY_TYPE_ID = "SELECT n.id,n.UPDATETIME,n.title FROM news n ,sys_news_type t WHERE n.type_id = t.id AND n.type_id = ? ";

	public List getNewsListByTypeId(String typeId) {
		// TODO Auto-generated method stub

		return jt.queryForList(GET_NEWS_BY_TYPE_ID, typeId);

	}

	public PagingList getNewsPageListByTypeId(String typeId,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return getPagingList(GET_NEWS_BY_TYPE_ID, request, typeId);
	}

	private static final String GET_TYPE_NAME_BY_ID = "SELECT id,name FROM sys_news_type WHERE id = ?";

	public Map getTypeMap(String typeId) {
		// TODO Auto-generated method stub
		try {
			List<Map<String, Object>> types = jt.queryForList(
					GET_TYPE_NAME_BY_ID, typeId);
			Map<String, Object> map = types.get(0);
			return map;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
