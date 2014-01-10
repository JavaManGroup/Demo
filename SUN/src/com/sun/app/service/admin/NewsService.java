package com.sun.app.service.admin;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.app.service.BaseService;
import com.sun.core.Constants;
import com.sun.core.common.PagingList;
import com.sun.core.util.MapUtil;
import com.sun.dao.NewsMapper;
import com.sun.dao.SysNewsMapper;
import com.sun.dao.SysNewsTypeMapper;
import com.sun.util.ClassUtil;
import com.sun.util.HtmlUtil;
import com.sun.vo.News;
import com.sun.vo.NewsExample;
import com.sun.vo.SysNews;
import com.sun.vo.SysNewsType;
import com.sun.vo.SysUser;

public class NewsService extends BaseService {
	@Autowired
	private NewsMapper mapper;

	public Integer add(HttpServletRequest request, String ip) {
		// TODO Auto-generated catch block
		try {
			News n = (News) ClassUtil.convert(request, News.class);
			n.setUpdateIp(ip);
			return mapper.insert(n);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 0;
	}

	public Integer delete(HttpServletRequest request, String ip) {
		String newsId = request.getParameter("newsId");
		String[] arrayNewsId = newsId.split(",");
		News news = new News();
		Integer countDeleteNews = 0;
		for (int i = 0; i < arrayNewsId.length; i++) {
			news.setId(Integer.valueOf(arrayNewsId[i]));
			news.setIsDel(1);
			int r = mapper.deleteByPrimaryKey(news.getId());
			countDeleteNews = countDeleteNews + r;
		}
		return countDeleteNews;
	}

	public Integer update(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		try {
			News n = (News) ClassUtil.convert(request, News.class);
			n.setUpdateIp(ip);
			String content = HtmlUtil.LimitImgWidth(n.getContent(), 500);
			n.setContent(content);
			return mapper.updateByPrimaryKeyWithBLOBs(n);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	public Object queryForObject(Integer id) {
		// TODO Auto-generated method stub
		News selectByPrimaryKey = mapper.selectByPrimaryKey(id);
		return mapper.selectByPrimaryKey(id);
	}

	private final static String ALL_NEWS = ""
			+ "SELECT n.id,n.title,n.viewcount,n.updatetime,n.is_del,n.is_top,n.is_home,n.status,t.name,u.realname "
			+ "FROM news n,sys_news_type t,sys_user u "
			+ "WHERE n.type_id =  t.ID AND n.user_id = u.id AND n.is_del = 0 "
			+ "ORDER BY n.updatetime desc";

	public PagingList getPageNewsList(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("pageSize", 20);
		try {
			return getPagingList(ALL_NEWS, request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	private final static String ALL_NEWS_BY_TYPE = ""
			+ "SELECT n.id,n.title,n.viewcount,n.updatetime,n.is_del,n.is_top,n.is_home,n.status,t.name,u.realname "
			+ "FROM news n,sys_news_type t,sys_user u "
			+ "WHERE n.type_id =  t.ID AND n.user_id = u.id AND n.is_del = 0 AND n.type_id = ?"
			+ "ORDER BY n.updatetime desc";

	public PagingList getPageNewsListByTypeId(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String typeId = request.getParameter("typeId");
		return getPagingList(ALL_NEWS_BY_TYPE, request, typeId);
	}

	private final static String SQL_ALL_CITY = "select * from sys_city where proId = ?";
	private final static String SQL_ALL_PRO = "select * from sys_province";

	@Autowired
	private SysNewsMapper newsMapper;
	@Autowired
	private SysNewsTypeMapper typeMapper;

	public List getCity(Integer pid) {
		// TODO Auto-generated method stub
		return jt.queryForList(SQL_ALL_CITY, pid);
	}

	public List getAllPro() {
		// TODO Auto-generated method stub
		return jt.queryForList(SQL_ALL_PRO);
	}

	private final static String SQL_HOME_NEWS_TYPE = ""
			+ "select ID,NAME from sys_news_type";
	private final static String SQL_ALL_NEWS_TYPE = ""
			+ "select t.ID,t.NAME,t.SORT,t.UPDATETIME,t.USERID,t.is_banner,t.is_static,is_banner,u.REALNAME "
			+ "from sys_news_type t,sys_user u " + "where t.USERID = u.ID "
			+ "order by t.SORT";

	public List getAllNewsType() {
		// TODO Auto-generated method stub
		return jt.queryForList(SQL_ALL_NEWS_TYPE);
	}

	public List getHomeNewsType() {
		return jt.queryForList(SQL_HOME_NEWS_TYPE);
	}

	public int addNews(HttpServletRequest request, String ip) {
		// TODO Auto-generated catch block
		Integer userid = 0;
		try {
			SysUser User = (SysUser) request.getSession().getAttribute(
					Constants.LOGIN_USER);
			userid = User.getId();
		} catch (Exception e) {

			e.printStackTrace();
		}
		SysNews record = new SysNews();
		String[] params = MapUtil.getStringArrayFromMap(request
				.getParameterMap(),
				"title,content,status,newstypeid,dwz.attachment.fileName");
		record.setTitle(params[0]);
		record.setContent(params[1]);
		record.setState(Integer.valueOf(params[2]));
		record.setNewstypeid(Integer.valueOf(params[3]));
		record.setUserid(userid);
		record.setPosttime(new Date());
		record.setUpdatetime(new Date());
		record.setUpdateip(ip);
		record.setTop(0);
		record.setImage(params[4]);
		int r = newsMapper.insertSelective(record);
		return r;

	}

	private final static String SQL_ALL_NEW_BY_ID = ""
			+ "select n.id,n.title,n.content,n.posttime,n.IMAGE as newimage,n.UPDATETIME,n.VIEWCOUNT,n.STATE,n.top,t.name,u.realname "
			+ "from sys_news n,sys_news_type t,sys_user u "
			+ "where n.NEWSTYPEID=t.ID and n.USERID=u.id AND n.id=?";

	public Map getNewsById(Integer id) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> news = jt.queryForList(SQL_ALL_NEW_BY_ID, id);
		if (news.isEmpty())
			return null;
		else
			return news.get(0);
	}

	public Integer deleteNews(String newsId) {
		// TODO Auto-generated method stub
		String[] arrayNewsId = newsId.split(",");
		SysNews news = new SysNews();
		Integer countDeleteNews = 0;
		for (int i = 0; i < arrayNewsId.length; i++) {

			news.setId(Integer.valueOf(arrayNewsId[i]));
			news.setIsDel(1);
			int r = newsMapper.updateByPrimaryKeySelective(news);
			countDeleteNews = countDeleteNews + r;
		}
		return countDeleteNews;
	}

	public Integer updateNews(HttpServletRequest request, Map parameterMap,
			String ip) {
		Integer userid = 0;
		try {
			SysUser User = (SysUser) request.getSession().getAttribute(
					Constants.LOGIN_USER);
			userid = User.getId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SysNews n = new SysNews();
		String[] params = MapUtil
				.getStringArrayFromMap(parameterMap,
						"newsId,title,content,status,newstypeid,top,dwz.attachment.fileName");
		n.setId(Integer.valueOf(params[0]));
		n.setTitle(params[1]);
		n.setContent(params[2]);
		n.setState(Integer.valueOf(params[3]));
		n.setNewstypeid(Integer.valueOf(params[4]));
		n.setTop(Integer.valueOf(params[5]));
		n.setUpdateip(ip);
		n.setUpdatetime(new Date());

		n.setUserid(userid);
		n.setImage(params[6]);

		return newsMapper.updateByPrimaryKeySelective(n);
	}

	public int addNewsType(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		SysNewsType type = new SysNewsType();
		type.setName(request.getParameter("name"));
		type.setIntroduction(request.getParameter("introduction"));
		type.setPosttime(new Date());
		type.setUpdatetime(new Date());
		type.setState(1);
		type.setSort(Integer.valueOf(request.getParameter("sort")));
		type.setUserid(Integer.valueOf(request.getParameter("userId")));
		type.setIsBanner(Integer.valueOf(request.getParameter("isBanner")));
		type.setIsStatic(Integer.valueOf(request.getParameter("isStatic")));
		return typeMapper.insert(type);
	}

	public SysNewsType getNewsTypeById(String typeId) {
		// TODO Auto-generated method stub
		try {
			return typeMapper.selectByPrimaryKey(Integer.valueOf(typeId));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	public PagingList search(HttpServletRequest request) {
		String sql = "SELECT n.*,t.name,u.realname FROM news n,sys_news_type t,sys_user u WHERE n.type_id = t.id AND n.user_id = u.id ";
		String title = request.getParameter("title");
		String isTop = request.getParameter("isTop");
		String isHome = request.getParameter("isHome");
		String typeId = request.getParameter("typeId");
		request.setAttribute("pageSize", 50);
		if (title != "")
			sql = sql + " AND n.title like '%" + title + "%'";
		if (Integer.valueOf(typeId) != 0)
			sql = sql + " AND n.type_id = " + typeId;
		if (Integer.valueOf(isTop) != 999)
			sql = sql + " AND n.is_top = " + isTop;
		if (Integer.valueOf(isHome) != 999)
			sql = sql + " AND n.is_home = " + isHome;
		return getPagingList(sql, request);
	}

	/**
	 * AJAX设置首页显示的service
	 * 
	 * @param request
	 * @return
	 */
	public Integer setIsHome(HttpServletRequest request) {
		// TODO Auto-generated method stub
		// setIsHome&&status=1&&newsId=15&&pageNum=
		String status = request.getParameter("status");
		String newsId = request.getParameter("newsId");
		NewsExample example = new NewsExample();
		example.createCriteria().andIdEqualTo(Integer.valueOf(newsId))
				.andIsHomeEqualTo(Integer.valueOf(status));
		News news = new News();
		news.setId(Integer.valueOf(newsId));
		if (status.equals("1"))
			news.setIsHome(0);
		else
			news.setIsHome(1);

		news.setUpdatetime(new Date());
		int r = mapper.updateByExampleSelective(news, example);

		return r;
	}

	public List homeSearch(String s, HttpServletRequest request) {
		// TODO Auto-generated method stub
		String SEARCH_SQL = "SELECT * FROM news WHERE title like '%" + s + "%'";
		return jt.queryForList(SEARCH_SQL);
	}

}
