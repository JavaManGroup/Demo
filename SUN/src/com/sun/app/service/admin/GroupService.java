package com.sun.app.service.admin;

import com.sun.app.service.BaseService;
import com.sun.core.common.PagingList;
import com.sun.core.util.MapUtil;
import com.sun.dao.SysGroupMapper;
import com.sun.dao.SysRoleMapper;
import com.sun.dao.SysUserMapper;
import com.sun.vo.SysGroup;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

public class GroupService extends BaseService {
	@Autowired
	private SysUserMapper userMapper;
	@Autowired
	private SysGroupMapper groupMapper;
	@Autowired
	private SysRoleMapper roleMapper;
	private static final String SQL_GET_ALL_GROUP = "select * from sys_group";
	private static final String ADD_VIEW_GET_GROUP = "select id,group_name from sys_group";

	public PagingList getAllGroupPaging(HttpServletRequest request) {
		return getPagingList(SQL_GET_ALL_GROUP, request);
	}
	public List getAddViewGroup(){
		return jt.queryForList(ADD_VIEW_GET_GROUP);
	}
	public List getAllGroup() {
		// TODO Auto-generated method stub
		return jt.queryForList(SQL_GET_ALL_GROUP);
	}

	public Integer addUserGroup(Map para, String ip) {
		SysGroup record = new SysGroup();
		String[] params = MapUtil.getStringArrayFromMap(para,
				"groupName,groupDes");
		record.setGroupName(params[0]);
		record.setGroupDes(params[1]);
		int r = 0;
		try {
			r = groupMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	/**
	 * 判断用户组是否存在
	 * 
	 * @param groupName
	 * @return
	 */
	private static final String SQL_IS_EXIST_BY_NAME = "select count(*) from sys_group where group_name = ?";

	public boolean isExist(String groupName) {
		// TODO Auto-generated method stub
		int r = jt.queryForInt(SQL_IS_EXIST_BY_NAME, groupName);
		if (r > 0)
			return true;
		else
			return false;
	}

	public Integer deleteGroup(Integer id) {
		// TODO Auto-generated method stub
		groupMapper.deleteByPrimaryKey(id);
		return null;
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
