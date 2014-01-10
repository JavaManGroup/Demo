package com.sun.app.service.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.sun.app.service.BaseService;
import com.sun.core.common.PagingList;
import com.sun.dao.HonourDetailMapper;
import com.sun.dao.HonourMapper;
import com.sun.util.ClassUtil;
import com.sun.vo.Honour;
import com.sun.vo.Project;

public class HonourService extends BaseService {
	@Autowired
	private HonourMapper mapper;
	@Autowired
	private HonourDetailMapper detailMapper;
	@Override
	public Integer add(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		int r = 0;
		String max = "SELECT MAX(id) FROM honour";
		Integer maxId = jt.queryForInt(max);
		

		String[] Sort = request.getParameterValues("items.itemSort");
		String[] Name = request.getParameterValues("items.itemName");
		String[] Des = request.getParameterValues("items.itemDes");
		String[] fileName = request
				.getParameterValues("dwz.items.attachment.fileName");
		try {
			for (int i = 0; i < fileName.length; i++) {
				String sql = "insert into honour_detail (honour_id,name,des,image,sort) values (?,?,?,?,?)";
				jt.update(sql, maxId + 1, Name[i], Des[i], fileName[i], i + 1);
			}
		} catch (Exception e) {
			return -2;
		}
		try {

			Honour o = (Honour) ClassUtil.convert(request, Honour.class);
			o.setId(maxId + 1);
			r = mapper.insert(o);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Map pm = request.getParameterMap();
		return r;
	}

	@Override
	public Integer delete(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		String honourId = request.getParameter("honourId");
		int r = mapper.deleteByPrimaryKey(Integer.valueOf(honourId));
		if(r>0){
			String delImages = "DELETE FROM honour_detail WHERE honour_id = ?";
			int s = jt.update(delImages,honourId);
		}
			
		return r;
	}

	@Override
	public Integer update(HttpServletRequest request, String ip) {
		// TODO Auto-generated method stub
		try {
			String imagePath = request.getParameter("imagePath");
			Honour r = (Honour) ClassUtil.convert(request, Honour.class);
			
			
			String[] Sort = request.getParameterValues("items.itemSort");
			String[] Name = request.getParameterValues("items.itemName");
			String[] Des = request.getParameterValues("items.itemDes");
			String[] fileName = request
					.getParameterValues("dwz.items.attachment.fileName");
			try {
				for (int i = 0; i < fileName.length; i++) {
					String sql = "insert into honour_detail (honour_id,name,des,image,sort) values (?,?,?,?,?)";
					jt.update(sql, r.getId(), Name[i], Des[i], fileName[i], i + 1);
				}
			} catch (Exception e) {
			}
			
			int upEd = mapper.updateByPrimaryKey(r);
			
			
			return upEd;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	private static final String GET_HONUOR_PAGE_LIST = "SELECT h.*,u.realname FROM honour h , sys_user u WHERE u.id = h.user_id AND h.type_id  = ? order by updatetime desc";
	private static final String GET_HONUOR_PAGE_LIST_ALL = "SELECT h.*,u.realname FROM honour h , sys_user u WHERE u.id = h.user_id order by updatetime desc";

	public PagingList queryForPagingList(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("pageSize", 20);
		String typeId = "1";
		if (request.getParameter("typeId") == null) {
			return getPagingList(GET_HONUOR_PAGE_LIST_ALL, request);
		}
		// typeId = request.getParameter("typeId");
		return getPagingList(GET_HONUOR_PAGE_LIST, request, request
				.getParameter("typeId"));
	}

	private static final String GET_HONOUR_MAP = "SELECT * FROM honour WHERE id = ?";
	private static final String GET_HONOUR_IMAGES = "SELECT * FROM honour_detail WHERE honour_id = ?";

	public Map querForMap(String id) {
		// TODO Auto-generated method stub
		Map<String, Object> map = jt.queryForMap(GET_HONOUR_MAP, id);
		List list = jt.queryForList(GET_HONOUR_IMAGES, id);
		map.put("images", list);
		return map;
	}

	public Integer getHonourCount(Integer id) {
		// TODO Auto-generated method stub
		String countSql = getCountSql(GET_HONOUR_IMAGES);
		return jt.queryForInt(countSql, id);
	}

	public Integer deleteImages(String imageId) {
		// TODO Auto-generated method stub
		return detailMapper.deleteByPrimaryKey(Integer.valueOf(imageId));
	}

}
