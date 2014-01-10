package com.sun.app.service.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.sun.app.service.BaseService;
import com.sun.core.Constants;
import com.sun.core.common.PagingList;
import com.sun.dao.ProjectImageMapper;
import com.sun.dao.ProjectMapper;
import com.sun.dao.ProjectTypeMapper;
import com.sun.util.ClassUtil;
import com.sun.vo.News;
import com.sun.vo.NewsExample;
import com.sun.vo.Project;
import com.sun.vo.ProjectExample;
import com.sun.vo.ProjectImage;
import com.sun.vo.ProjectImageExample;
import com.sun.vo.ProjectType;
import com.sun.vo.SysNews;

public class AdminProjectService extends BaseService {

	@Autowired
	private ProjectMapper mapper;
	@Autowired
	private ProjectImageMapper imageMapper;
	@Autowired
	private ProjectTypeMapper typeMapper;
	private static final String PROJECT_LIST_BY_TYPEID = "SELECT id,title "
			+ "FROM project " + "WHERE type_id = ? AND is_home = 1 limit 6";

	public List getProjectList(Integer typeId) {
		// TODO Auto-generated method stub
		System.out.println("---------->" + typeId);
		return jt.queryForList(PROJECT_LIST_BY_TYPEID, typeId);
	}

	private static final String HOME_TYPE_ID = "SELECT id,name,image "
			+ "FROM project_type " + "WHERE is_home = 1";

	public List getHomeType() {
		// TODO Auto-generated method stub
		return jt.queryForList(HOME_TYPE_ID);
	}

	private static final String PROJECT_LIST_BY_IS_HOME = "SELECT id,title FROM project WHERE is_home = 1 limit 6";

	/**
	 * 取得首頁顯示文章
	 * 
	 * @return
	 */
	public List getProjectByIsHome() {
		// TODO Auto-generated method stub
		return jt.queryForList(PROJECT_LIST_BY_IS_HOME);
	}

	private static final String ALL_PROJECT_TYPE = "SELECT id,name FROM project_type order by sort";

	/**
	 * 获得全部精品工程分类
	 * 
	 * @return
	 */
	private static final String PROJECT_TYPE = "SELECT * FROM project_type order by sort";

	public List getALlProjectType() {
		// TODO Auto-generated method stub
		return jt.queryForList(PROJECT_TYPE);
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

	private static final String GET_PROJECT_PAGE_LIST_BY_TYPEID = "SELECT p.*,t.name FROM project p,project_type t WHERE p.type_id  = t.id AND type_id = ?";
	private static final String GET_PROJECT_PAGE_LIST = "SELECT p.*,t.name FROM project p,project_type t WHERE p.type_id  = t.id order by p.updatetime desc";

	public PagingList getProjectPageList(HttpServletRequest request) {
		String typeId = request.getParameter("typeId");
		System.out.println(typeId + "@@@@@@@@@222");
		request.setAttribute("pageSize", 20);
		return getPagingList(GET_PROJECT_PAGE_LIST, request);
	}

	public PagingList getProjectSearch(HttpServletRequest request) {
		String sql = "SELECT p.*,t.name FROM project p,project_type t WHERE p.type_id = t.id";
		String title = request.getParameter("title");
		String status = request.getParameter("status");
		String typeId = request.getParameter("typeId");
		request.setAttribute("pageSize", 50);
		if (title != "")
			sql = sql + " AND p.title like '%" + title + "%'";
		if (Integer.valueOf(typeId) != 0)
			sql = sql + " AND p.type_id = " + typeId;
		if (Integer.valueOf(status) != 999)
			sql = sql + " AND p.status = " + status;
		return getPagingList(sql, request);
	}

	private static final String GET_HONOUR_LIST = "SELECT p.id,p.title,p.image_path FROM project_honour h ,project p WHERE p.id = h.project_id";

	public List getHonourProject() {
		// TODO Auto-generated method stub

		return jt.queryForList(GET_HONOUR_LIST);
	}

	public List getHonourType() {
		// TODO Auto-generated method stub
		List type = new ArrayList();
		Map type1 = new HashMap();
		type1.put("id", 1);
		type1.put("name", "获得奖项");
		Map type2 = new HashMap();
		type2.put("id", 2);
		type2.put("name", "荣誉业绩");
		Map type3 = new HashMap();
		type3.put("id", 3);
		type3.put("name", "精品推荐");
		type.add(type1);
		type.add(type2);
		type.add(type3);
		return type;
	}

	private static final String HONOUR_LIST_BY_TYPE = "SELECT * FROM honour";

	public List getHonourProjectByType(String typeId) {
		// TODO Auto-generated method stub
		return jt.queryForList(HONOUR_LIST_BY_TYPE, typeId);
	}

	public int addProjectMain(HttpServletRequest request) {
		try {
			String imagePath = request.getParameter("dwz.attachment.fileName");
			Project r = (Project) ClassUtil.convert(request, Project.class);
			r.setImagePath(imagePath);
			return mapper.insert(r);
		} catch (Exception e) {
			return 0;
		}
	}

	public int updateProject(HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			String imagePath = request.getParameter("dwz.attachment.fileName");
			String projectId = request.getParameter("projectId");
			Project r = (Project) ClassUtil.convert(request, Project.class);
			r.setId(Integer.valueOf(projectId));
			r.setImagePath(imagePath);
			return mapper.updateByPrimaryKey(r);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Integer delete(String projectId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String[] arrayId = projectId.split(",");
		Integer count = 0;
		for (int i = 0; i < arrayId.length; i++) {
			int r = mapper.deleteByPrimaryKey(Integer.valueOf(arrayId[i]));
			count = count + r;
		}
		return count;
	}

	private static final String COUNT_PROJECT_IMAGE = "select count(*) from project_image WHERE ( project_id = ? )";

	public Integer getProjectImageCount(Integer projectId) {
		return jt.queryForInt(COUNT_PROJECT_IMAGE, projectId);
	}

	public void addProjectImage(HttpServletRequest request, int id,
			String fileName) {
		// TODO Auto-generated method stub
		ProjectImage i = new ProjectImage();
		i.setProjectId(id);
		i.setTitle("123213");
		i.setImageUrl(fileName);
		i.setImagePath(fileName);
		i.setIsDel(0);
		imageMapper.insert(i);
	}

	private static final String UPDATE_SET_STATUS = "update project SET status = 0";

	public Integer updateProjectStatus(String projectId) {
		// TODO Auto-generated method stub
		String[] arrayId = projectId.split(",");

		Integer count = 0;
		jt.update(UPDATE_SET_STATUS);
		for (int i = 0; i < arrayId.length; i++) {
			Project p = new Project();
			p.setId(Integer.valueOf(arrayId[i]));
			p.setStatus(1);
			int r = mapper.updateByPrimaryKeySelective(p);
			count = count + r;
		}
		return count;

	}

	public int updateProjectDelStatus(String projectId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String[] arrayId = projectId.split(",");

		Integer count = 0;
		for (int i = 0; i < arrayId.length; i++) {
			Project p = new Project();
			p.setId(Integer.valueOf(arrayId[i]));
			p.setStatus(1);
			int r = mapper.updateByPrimaryKeySelective(p);
			count = count + r;
		}
		return count;
	}

	public int updateProjectAddStatus(String projectId) {
		// TODO Auto-generated method stub
		String[] arrayId = projectId.split(",");

		Integer count = 0;
		for (int i = 0; i < arrayId.length; i++) {
			Project p = new Project();
			p.setId(Integer.valueOf(arrayId[i]));
			p.setStatus(0);
			int r = mapper.updateByPrimaryKeySelective(p);
			count = count + r;
		}
		return count;
	}

	public Integer getProjectCountByTypeId(Integer typeId) {
		ProjectExample example = new ProjectExample();
		example.createCriteria().andTypeIdEqualTo(typeId);
		int countByExample = mapper.countByExample(example);
		return countByExample;
	}

	private static final String ADD_PROJECT_TYPE = "insert into project_type (name,image,is_home,user_id,updatetime,sort) values (?,?,?,?,now(),?);";

	public Integer addProjectType(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String image = request.getParameter("dwz.attachment.fileName");
		String isHome = request.getParameter("isHome");
		String sort = request.getParameter("sort");
		Integer userId = (Integer) request.getSession().getAttribute(
				Constants.LOGIN_USER_ID);

		return jt.update(ADD_PROJECT_TYPE, name, image, isHome, userId,sort);
	}

	private static final String DELETE_PROJECT_TYPE = "delete from project_type where id = ?";

	public Integer deleteProjectType(String protypeId) {
		// TODO Auto-generated method stub
		String[] arrayId = protypeId.split(",");
		Integer count = 0;
		for (int i = 0; i < arrayId.length; i++) {
			int r = jt.update(DELETE_PROJECT_TYPE, arrayId[i]);
			count = count + r;
		}
		return count;
	}

	private static final String PROJECT_TYPE_BY_ID = "SELECT * FROM project_type WHERE id  = ?";

	public Map getProjectTypeMap(String protypeId) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = jt.queryForList(PROJECT_TYPE_BY_ID,
				protypeId);
		Map<String, Object> map = list.get(0);
		return map;
	}

	public void updateProjectTypeById(HttpServletRequest request) {
		ProjectType c;
		try {
			ProjectType record = (ProjectType) ClassUtil.convert(request,
					ProjectType.class);
			String image = request.getParameter("dwz.attachment.fileName");
			record.setImage(image);
			typeMapper.updateByPrimaryKey(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public Integer setIsTop(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		String status = request.getParameter("status");
		String newsId = request.getParameter("projectId");
		ProjectExample example = new ProjectExample();
		example.createCriteria().andIdEqualTo(Integer.valueOf(newsId))
				.andStatusEqualTo(Integer.valueOf(status));
		Project project = new Project();
		project.setId(Integer.valueOf(newsId));
		if (status.equals("1"))
			project.setStatus(0);
		else
			project.setStatus(1);
		project.setUpdatetime(new Date());
		int r = mapper.updateByExampleSelective(project, example);

		return r;

	}

	public Integer getMaxSort() {
		// TODO Auto-generated method stub
		return getMax("sort", "project_type");
	}

	public int deleteImages(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String imageId = request.getParameter("imageId");
		String[] arrayId = imageId.split(",");
		Integer count = 0;
		for (int i = 0; i < arrayId.length; i++) {
			int r = imageMapper.deleteByPrimaryKey(Integer.valueOf(arrayId[i]));
			count = count + r;
		}
		
		return count;
	}

	public List homeSearch(String s, HttpServletRequest request) {
		// TODO Auto-generated method stub
		String SEARCH_SQL = "SELECT * FROM project WHERE title like '%"+s+"%'";
		return  jt.queryForList(SEARCH_SQL);
	}

}
