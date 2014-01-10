package com.antony.service.user.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antonyframework.service.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import com.antony.service.user.db.UserMapper;

public class UserService extends BaseService {

	@Autowired
	private UserMapper mapper;

	public void testDB() {
		String sql = "select * from co0001";
		List<Map<String, Object>> list = jt.queryForList(sql);

		System.out.println(list);

	}

	public Map getFriendInfoByUUIDandFriendId(String uuid, String friendId) {
		Map p = new HashMap();
		p.put("USER_ID", uuid);
		p.put("FRIEND_ID", friendId);
		return mapper.getFriendInfoByUUIDandFriendId(p);

	}

	public List getFriendListByUUID(String uuid, Integer from, Integer to) {
		// TODO Auto-generated method stub
		Map param = new HashMap();
		param.put("uuid", uuid);
		param.put("FROM", from);
		param.put("TO", to);
		return mapper.getFriendListByUUID(param);
	}

	public Integer count_friendListByuuid() {
		return mapper.Count_FriendListByUUID(null);
	}

	public Map getUserByUUID(String uuid) {
		// TODO Auto-generated method stub
		Map userInfo = mapper.getUserInfoByUUID(uuid);
		return userInfo;
	}

	public Integer userFriend(Integer uuid) {
		Map param = new HashMap();
		param.put("UID", uuid);
		return mapper.user_friend(param);
	}

	public Map addFriend(Integer userMessage, Integer friend_id) {
		System.out.println(userMessage);
		System.out.println(friend_id);
		Map param = new HashMap();
		param.put("U_ID", userMessage);
		param.put("F_ID", friend_id);
		return mapper.userfriend(param);
	}
	public Map Delete_userfriend(Integer userMessage, Integer friend_id) {
		System.out.println(userMessage);
		System.out.println(friend_id);
		Map param = new HashMap();
		param.put("U_ID", userMessage);
		param.put("F_ID", friend_id);
		return mapper.Delete_userfriend(param);
	}
	public Map Friend_addMessage(Integer userMessage, Integer friend_id) {
		Map param = new HashMap();
		param.put("U_ID", userMessage);
		param.put("F_ID", friend_id);
		return mapper.Friend_addMessage(param);
	}
	public int TrueForFriend_Message(String time,Integer uid, Integer fid) {
		Map param = new HashMap();
		param.put("U_ID", uid);
		param.put("SYSDATE", time);
		param.put("F_ID", fid);
		return mapper.TrueForFriend_Message(param);
	}
	public int update_M_CountForFriend(Integer friend_id) {
		Map param = new HashMap();
		param.put("F_ID", friend_id);
		return mapper.update_M_CountForFriend(param);
	}
	public Map verFriend(Integer uid, Integer friend_id) {
		Map param = new HashMap();
		param.put("UID", uid);
		param.put("FID", friend_id);
		return mapper.verfriend(param);
	}

	public void updateUser(String user_nick, String user_pic, String user_sex,
			Integer user_age, String user_local, String user_des, Integer uuid,
			String user_city) {
		Map param = new HashMap();
		param.put("NICK", user_nick);
		param.put("SEX", user_sex);
		param.put("AGE", user_age);
		param.put("LOCAL", user_local);
		param.put("DES", user_des);
		param.put("UUID", uuid);
		param.put("CITY", user_city);
		mapper.updateUser(param);
	}

	public List friendMessage(Integer uid, Integer from, Integer to, String type) {
		Map param = new HashMap();
		param.put("TYPE", type);
		param.put("UID", uid);
		param.put("FROM", from);
		param.put("TO", to);
		return mapper.friendMessage(param);
	}

	public Map friendMessage_ForP_id(String m_id) {
		Map param = new HashMap();
		param.put("M_ID", m_id);
		return mapper.friendMessage_ForP_id(param);
	}

	public Map friendMessage_ForP_Info(Integer p_id) {
		Map param = new HashMap();
		param.put("PID", p_id);
		return mapper.friendMessage_ForP_Info(param);
	}

	public Integer Count_friendMessage(Integer uid) {
		Map param = new HashMap();
		param.put("UID", uid);
		return mapper.Count_friendMessage(param);
	}

	public Map sendUser(Integer uid, Integer m_id,Integer fid) {
		Map param = new HashMap();
		param.put("UID", uid);
		param.put("MID", m_id);
		param.put("FID", fid);
		return mapper.sendUser(param);
	}

	public int TrueForUser(Integer uid, Integer fid) {
		Map param = new HashMap();
		param.put("UID", uid);
		param.put("FID", fid);
		return mapper.TrueForUser(param);
	}
	public int Delete_ForUser(Integer uid, Integer fid) {
		Map param = new HashMap();
		param.put("UID", uid);
		param.put("FID", fid);
		return mapper.Delete_ForUser(param);
	}
	public int Delete_For_User(Integer uid, Integer fid) {
		Map param = new HashMap();
		param.put("UID", uid);
		param.put("FID", fid);
		return mapper.Delete_ForTrueUser(param);
	}
	public int Delete_ForTrueUser_Message(Integer uid, Integer fid) {
		Map param = new HashMap();
		param.put("UID", uid);
		param.put("FID", fid);
		return mapper.Delete_ForTrueUser_Message(param);
	}
	public Map Select_Sysdate(Integer uid, Integer fid) {
		Map param = new HashMap();
		param.put("UID", uid);
		param.put("FID", fid);
		return mapper.Select_Sysdate(param);
	}

	public void TrueForFriend(Integer uid, Integer fid) {
		Map param = new HashMap();
		param.put("UID", uid);
		param.put("FID", fid);
		mapper.TrueForFriend(param);
	}

	public Map User_Info(Integer uid) {
		Map param = new HashMap();
		param.put("UID", uid);
		return mapper.User_Info(param);
	}

	public Map User_Set(Integer uid) {
		Map param = new HashMap();
		param.put("UID", uid);
		return mapper.User_Set(param);
	}

	public Map User_Set_Bound(Integer uid) {
		Map param = new HashMap();
		param.put("UID", uid);
		return mapper.User_Set_Bound(param);
	}

	public int validatorUser(String mail, String nick) {
		// TODO Auto-generated method stub

		// 验证E - mail
		Map param = new HashMap();
		param.put("email", mail);

		int code = 0;
		Map userEmail = mapper.queryUserByEmail(param);
		if (userEmail == null) {
			return 1;
		} else {
			code = code + 4;
		}

		// 验证 昵称
		Map userNick = mapper.queryUserByNick(nick);
		if (userNick == null) {
			return 2;
		} else {
			code = code + 6;
		}
		return code;

	}

	public Integer createUser(String mail, String mailPass, String userPic,
			String userNick, String userSex, Integer userAge) {
		// TODO Auto-generated method stub
		Integer uuid = createUserUUID();
		insertUserDAO(uuid, mailPass, mail, null, userNick, "(null)","(null)", null,
				userSex, "0", userPic, userAge, null);
		Map set = new HashMap();
		set.put("UUID", uuid);
		set.put("suid", mailPass);
		mapper.insertUserSet(set);
		//INSERT  COUNT  M_COUNT 2013年2月26日, PM 03:19:17 START
		
		Map count = new HashMap();
		count.put("uuid", uuid);
		mapper.insertUserCount(count);
		//INSERT  COUNT  M_COUNT 2013年2月26日, PM 03:19:17 END
		return uuid;
	}

	public Integer createUserUUID() {
		int uuid = mapper.queryUserUUID();
		return uuid;
	}

	public int insertUserDAO(Integer uuid, String pass, String email,
			String phone, String nick, String local, String city, String des,
			String sex, String status, String pic, Integer age, String sign) {

		Map param = new HashMap();
		param.put("uuid", uuid);
		param.put("pass", pass);
		param.put("email", email);
		param.put("phone", phone);
		param.put("nick", nick);
		param.put("local", local);
		param.put("city", city);
		param.put("des", des);
		param.put("sex", sex);
		param.put("status", status);
		param.put("pic", pic);
		param.put("age", age);
		param.put("sign", sign);
		int i = mapper.insertUser(param);
		return i;
	}

	// <if test="pass != null">
	// #{pass},
	// </if>
	// <if test="email != null">
	// #{email},
	// </if>
	// <if test="phone != null">
	// #{phone},
	// </if>
	// <if test="nick != null">
	// #{nick},
	// </if>
	// <if test="local != null">
	// #{local},
	// </if>
	// <if test="city != null">
	// #{city},
	// </if>
	// <if test="des != null">
	// #{des},
	// </if>
	// <if test="sex !=null">
	// #{sex},
	// </if>
	// SYSDATE,
	// <if test="status != null">
	// #{status},
	// </if>
	// <if test="pic != null">
	// #{pic},
	// </if>
	// <if test="age !=null">
	// #{age},
	// </if>
	// <if test="sign !=null">
	// #{sign}
	// </if>

	public Map getUserByEmail(String mail) {
		// TODO Auto-generated method stub
		if (mail != null) {
			System.out.println("登录  用户   邮箱" + mail);
			Map param = new HashMap();
			param.put("email", mail);
			Map user = mapper.queryUserByEmail(param);
			return user;
		} else {
			return null;
		}
	}

	public Map getUUIDBySUID(String suid) {
		// TODO Auto-generated method stub
		Map param = new HashMap();
		param.put("suid", suid);
		Map queryUserUUIDBySinaUid = mapper.queryUserUUIDBySinaUid(param);
		return queryUserUUIDBySinaUid;
	}

	public int updateUserFromMap(Map param) {
		// TODO Auto-generated method stub
		mapper.updateUser(param);
		return 1;
	}

	public int creatUserFromMap(Map param) {

		// TODO Auto-generated method stub
		log.info("注册  START ");

		// 验证邮箱 是否存在，
		int code = validatorUser(param.get("EMAIL").toString(),
				param.get("NICK").toString());
		log.info("验证邮箱     START  CODE " + code);
		if (code == 1) {
			// 邮箱不存在
			log.info("邮箱不存在");
		} else if (code == 2) {
			// 昵称不存在
			log.info("昵称不存在");
		} else if (code == 3) {
			// 允许注册
			log.info("允许注册");
		} else if (code == 4) {
			// 邮箱已存在
			log.info("邮箱已注册");
			return 0;
		} else if (code == 6) {
			// 昵称已存在
			log.info("昵称已注册");
			return 0;
		} else if (code == 10) {
			// 存在此用户
			return 0;
		}
		// 注册用户
		try {
			log.info("用户注册  START");
			Integer uuid = createUser(param.get("EMAIL").toString(),
					param.get("PASS").toString(), param.get("PIC").toString(),
					param.get("NICK").toString(), param.get("SEX").toString(),
					Integer.valueOf(param.get("AGE").toString()));
			log.info("用户注册  END");
			// 返回JSON
			if (uuid != null) {
				return uuid;
			} else {
				return 0;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info("用户注册  报错");
		}

		log.info("注册  END ");
		return 0;
	}

	public int updateUserPass(String uuid, String userMail, String userPass) {
		// TODO Auto-generated method stub
		Map param = new HashMap();
		param.put("UUID", uuid);
		param.put("PASS", userPass);
		int i = mapper.updateUserPass(param);
		return i;
	}

	public List getAllUserList(String uuid, String city, String local) {
		// TODO Auto-generated method stub
		// 如果city 为空
		if (city != null) {
			// 根据城市获得好友 ，
			Map param = new HashMap();
			param.put("CITY", city);
			List<Map> users = mapper.queryUserListByCity(param);

			return users;
		} else {
			// 获得全部好友，，
			return null;
		}

	}

	public List getTest() {
		// TODO Auto-generated method stub
		List  s = mapper.DBTest(null);
		return s;
	}

	public int updatePassForget(String mail, String pass) {
		// TODO Auto-generated method stub
		Map param = new HashMap();
		param.put("email", mail);
		param.put("pass", pass);
		int i = mapper.updatePassForget(param);
		return i;
	}
}
