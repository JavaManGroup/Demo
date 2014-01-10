package com.sun.app.service.admin;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.sun.app.service.BaseService;
import com.sun.core.common.PagingList;
import com.sun.core.util.MD5;
import com.sun.core.util.MapUtil;
import com.sun.dao.SysUserMapper;
import com.sun.vo.SysUser;

/**
 * @author LH
 * 
 */
public class UserService extends BaseService {

	/**
	 * 用户管理ORM
	 */
	@Autowired
	private SysUserMapper userMapper;

	/**
	 * 添加用户
	 * 
	 * @param parameter
	 * @param ip
	 */
	public void addUser(Map parameter, String ip) {
		SysUser record = new SysUser();
		String[] params = MapUtil.getStringArrayFromMap(parameter,
				"userName,realName,password,email,phone,roleId,status");
		record.setUsername(params[0]);
		record.setRealname(params[1]);
		record.setPassword(MD5.getMD5ofStr(params[2]));
		record.setEmail(params[3]);
		record.setPhone(params[4]);
		record.setRegip(ip);
		record.setRegtime(new Date().toGMTString());
		record.setLastloginip(ip);
		record.setLastlogintime(new Date());
		record.setState(Integer.valueOf(params[6]));
		record.setRoleId(Integer.valueOf(params[5]));
		userMapper.insertSelective(record);
	}

	// 按用户名查找用户信息(登录)
	private static final String SQL_GET_USER_BY_NAME = "select * from gov_user where USERNAME=?";

	/**
	 * 按用户名查找用户信息(登录)
	 * 
	 * @param userName
	 *            用户名
	 * @return 用户信息的Map
	 */
	public Map<String, Object> getUserByName(String userName) {
		try {
			return jt.queryForMap(SQL_GET_USER_BY_NAME,
					new Object[] { userName });
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	// 记录用户登录时间和IP
	private static final String SQL_SET_LOGIN_TIME_AND_IP = "update gov_user set LASTLOGINTIME=now(), LASTLOGINIP=? where ID=?";

	/**
	 * 记录用户登录时间和IP
	 * 
	 * @param ip
	 * @param id
	 */
	public void setUserLoginInfo(String ip, int id) {
		jt.update(SQL_SET_LOGIN_TIME_AND_IP, ip, id);
	}

	// 获取用户列表
	private static final String SQL_GET_ALL_USERS = "select r.group_name,u.* from sys_user u,sys_group r where u.role_id = r.id order by u.id";

	/**
	 * 获取用户列表 themes/default/images/icon/tico_edit.gif
	 * 
	 * @param request
	 *            HttpServletRequest对象
	 * @return 用户列表
	 */
	public PagingList getAllUsers(HttpServletRequest request) {
		request.setAttribute("pageSize", 20);
		return getPagingList(SQL_GET_ALL_USERS, request);
	}

	public List getAllUserList() {
		return jt.queryForList(SQL_GET_ALL_USERS);
	}

	// 添加用户
	private static final String SQL_ADD_USER = "insert into gov_user(USERNAME,REALNAME,PASSWORD,EMAIL,PHONE,REGTIME,REGIP,USERROLE) values(?,?,?,?,?,now(),?,0)";

	// 根据用户名查找用户数量，用于判断用户是否存在
	private static final String SQL_CHECK_USER_EXISTS = "select count(*) from gov_user where USERNAME=?";

	/**
	 * 根据用户名查找用户数量，用于判断用户是否存在
	 * 
	 * @param userName
	 * @return
	 */
	public int getUserCheck(String userName) {
		return jt.queryForInt(SQL_CHECK_USER_EXISTS, userName);
	}

	// 根据ID获取用户详细信息
	private static final String SQL_GET_USER_BY_ID = "select * from sys_user where ID=?";

	/**
	 * 根据ID获取用户详细信息
	 * 
	 * @param id
	 * @return
	 */
	public Map getUserById(String id) {
		return jt.queryForMap(SQL_GET_USER_BY_ID, id);
	}
	public Map getUserById(Integer id) {
		return jt.queryForMap(SQL_GET_USER_BY_ID, id);
	}

	private static final String SQL_UPDATE_USER_WITHOUT_PASSWORD_BY_ID = "update sys_user set REALNAME=?, EMAIL=?, PHONE=?, role_id=?, STATE=? where ID=?";

	public void updateUserWithoutPasswordById(Map parameter) {
		Object[] params = MapUtil.getObjectArrayFromMap(parameter,
				"realName,email,phone,userRole,state,userId");
		jt.update(SQL_UPDATE_USER_WITHOUT_PASSWORD_BY_ID, params);
	}

	private static final String SQL_UPDATE_USER_WITH_PASSWORD_BY_ID = "update gov_user set REALNAME=?, PASSWORD=?, EMAIL=?, PHONE=?, role_id=?, STATE=? where ID=?";

	public void updateUserWithPasswordById(Map parameter) {
		String password = MapUtil.getStringFromMap(parameter, "password");
		String md5Pwd = MD5.getMD5ofStr(password);
		Object[] params = MapUtil.getObjectArrayFromMap(parameter,
				"realName,email,phone,userRole,state,id");
		jt.update(SQL_UPDATE_USER_WITH_PASSWORD_BY_ID, params[0], md5Pwd,
				params[1], params[2], params[3], params[4], params[5]);
	}

	public Integer deleteUser(Integer id) {
		// TODO Auto-generated method stub
		int r = 0;
		try {
			r = userMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
		}
		return r;
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
