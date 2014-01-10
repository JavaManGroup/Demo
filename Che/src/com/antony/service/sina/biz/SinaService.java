package com.antony.service.sina.biz;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antonyframework.service.common.BaseService;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import weibo4j.Account;
import weibo4j.Friendships;
import weibo4j.Users;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.RateLimitStatus;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;

import com.antony.service.sina.db.CSinaFriendshipMapper;
import com.antony.service.sina.db.CSinaMapper;
import com.antony.service.sina.db.SinaMapper;
import com.antony.service.sina.vo.CSina;
import com.antony.service.sina.vo.CSinaFriendship;
import com.antony.service.user.db.UserMapper;

public class SinaService extends BaseService {

	private static final org.apache.commons.logging.Log LOG = LogFactory
			.getLog(SinaService.class);

	@Autowired
	private SinaMapper sinaMapper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private CSinaMapper cSinaMapper;

	@Autowired
	private CSinaFriendshipMapper friendshipMapper;
	private static String access_token = "2.00bhLiVDB4ygRDc597e4af00JipLJB";

	public RateLimitStatus getAccountRateLimitStatus() {
		Account am = new Account();
		am.client.setToken(access_token);
		try {
			RateLimitStatus json = am.getAccountRateLimitStatus();
			long hits = json.getRemainingUserHits();
			System.out.println("剩余次数:" + hits);
			return json;
		} catch (WeiboException e) {
			e.printStackTrace();
			return null;
		}
	}

	public User insertSinaUidByUUID(String uuid, String suid) {
		// TODO Auto-generated method stub
		String access_token = "2.00bhLiVDB4ygRDc597e4af00JipLJB";
		String uid = suid;
		Users um = new Users();
		um.client.setToken(access_token);
		try {
			User user = um.showUserById(uid);
			Log.logInfo(user.toString());
			Map param = new HashMap();
			param.put("UUID", uuid);
			param.put("SUID", suid);
			Integer hasUserSet = sinaMapper.hasUserSet(param);
			if (hasUserSet == 0) {
				// 创建USER SET
				Map set = new HashMap();
				set.put("UUID", uuid);
				userMapper.insertUserSet(set);
				System.out.println("创建USER  SET");
			}

			Integer count = sinaMapper.countSinaUserByUuidanfSuid(param);
			if (count == 0) {
				// update sina 帐号
				userMapper.updateUserSinaUid(param);
				System.out.println("插入sina帐号");
			} else {
				System.out.println("已绑定");
			}
			return user;
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List list(String uuid) {
		// 获得新浪的好友关系
		try {

			String sina_id = null;
			// 从本地数据库 获得sinaId
			Map param = new HashMap();
			param.put("UUID", uuid);
			Map userInfoWithSinaId = userMapper.getUserSinaIdByUUID(param);
			System.out.println(userInfoWithSinaId);
			if (userInfoWithSinaId != null)
				sina_id = userInfoWithSinaId.get("SINA_ID").toString();
			String[] sBilateralIds = getFriendSBilateralIds(sina_id);
			for (String s : sBilateralIds) {
				Log.logInfo(getSinaUserDB(s).toString());
				Integer hasSinaUser = hasSinaUser(s);
				if (hasSinaUser != null) {
					System.out.println("存在");

				} else {
					System.out.println("不存在");
					insertSinaUser(s);
					System.out.println("插入");
				}
			}
			return null;

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public void updateSinaUser(String uuid) {
		// 从本地数据库 获得sinaId
		Map param = new HashMap();
		param.put("UUID", uuid);
		Map userInfoWithSinaId = userMapper.getUserSinaIdByUUID(param);
		// 接收用户帐号
		String sina_id = null;

		if (userInfoWithSinaId != null)
			sina_id = userInfoWithSinaId.get("SINA_ID").toString();

		if (userInfoWithSinaId != null) {
			// 更新本地 新浪数据库
			param.put("SUID", sina_id);
			Integer hasAccount = sinaMapper.hasSinaAccount(param);
			if (hasAccount != 0) {
				// 存在新浪用户 更新数据库

			} else {
				// 插入新浪ID
				User sinaUserDB = getSinaUserDB(sina_id);
				Integer id = sinaMapper.queryId();
				CSina record = new CSina();
				record.setId((BigDecimal.valueOf(id)));
				record.setUserId(BigDecimal.valueOf(Integer.valueOf(uuid)));
				record.setSinaId(sina_id);
				record.setSinaNick(sinaUserDB.getName());
				record.setSinaSex(userInfoWithSinaId.get("SEX").toString());
				record.setSinaAge(BigDecimal.valueOf(Integer
						.valueOf(userInfoWithSinaId.get("AGE").toString())));
				record.setSinaCity(userInfoWithSinaId.get("CITY").toString());
				record.setSinaLocal(userInfoWithSinaId.get("LOCAL").toString());
				record.setSinaDes(sinaUserDB.getDescription());
				record.setSinaPicurl(sinaUserDB.getAvatarLarge());
				record.setUpdatetime(new Date());
				record.setStatus("Y");
				cSinaMapper.insertSelective(record);
			}

		} else {
			// 未获得 新浪用户
		}

	}

	// #{USER_ID},
	// #{SINA_ID},
	// #{SINA_NICK},
	// #{SINA_SEX},
	// #{SINA_AGE},
	// #{SINA_CITY},
	// #{SINA_LOCAL},
	// #{SINA_DES},
	// #{SINA_PICURL},
	// SYSDATE,
	// #{STATUS}

	public Integer hasUserBySinaId(String suid) {
		// 查询 本地数据库 通过SINA_ID 返回UUID
		Integer uuid = sinaMapper.getUUIDBySinaId(suid);
		LOG.info("查询 本地数据库  通过SINA_ID:" + suid + "  返回UUID:" + uuid);
		return uuid;
	}

	public Integer hasSinaUser(String suid) {
		//

		Integer id = sinaMapper.getSinaPkBySinaId(suid);
		LOG.info("查询 本地数据库是否纯在 Sina:" + suid + "帐号 信息返回 PK ID " + id);
		return id;
	}

	// 读取 新浪微博的好友数据 插入数据库，，，，，
	public Integer insertSinaFriendShip(String suid) {
		return insertSinaFriendShip(suid, -1, -1);
	}

	public Integer insertSinaFriendShip(String suid, int index, int limit) {
		Integer count = 0;
		UserWapper users = getFriendsListBySina(suid);
		Integer uuid = hasUserBySinaId(suid);
		CSinaFriendship ship = new CSinaFriendship();
		ship.setSinaId(suid);
		if (uuid != null)
			ship.setUserId(BigDecimal.valueOf(uuid));
		else
			ship.setUserId(BigDecimal.valueOf(0));

		for (User user : users.getUsers()) {
			User sinaUserDB = user;
			String friendSinaId = user.getId();
			ship.setFriendSinaId(user.getId());
			Integer friendUuid = hasUserBySinaId(friendSinaId);
			Integer pkId = updateSinaDAO(sinaUserDB.getId());
			int delete = deleteSinaAccount(user.getId(), null);
			if (friendUuid != null) {
				// 插入 数据到 c sina 表
				Map userDb = userMapper.getUserInfoByUUID(String
						.valueOf(friendUuid));
				insertSinaUserBeanToDBwithUser(friendUuid, userDb, sinaUserDB);

			} else {
				friendUuid = 0;
				// 插入 数据到 c sina 表
				// 判断C_SINA 是否存在
				int r = insertSinaUserBeanToDBwithoutUser(friendUuid,
						sinaUserDB);
			}
			// 插入 数据到 c_ friend_ sina 表
			deletSinaFriendShip(suid, friendSinaId);

			int iCount = insertFriendShip(uuid, suid, friendSinaId, friendUuid,
					sinaUserDB.getName());
			count = count + iCount;
		}
		return count;

	}

	public int deletSinaFriendShip(String sinaId, String friendSinaId) {
		Map param = new HashMap();
		param.put("sinaId", sinaId);
		param.put("friendSinaId", friendSinaId);
		int i = sinaMapper.deletSinaFriendShip(param);
		return i;
	}

	public int deleteSinaAccount(String sinaId, String friendSinaId) {
		Map param = new HashMap();
		param.put("sinaId", sinaId);
		param.put("friendSinaId", friendSinaId);
		int i = sinaMapper.deletSinaAccount(param);
		return i;
	}

	// 插入 C sina friend ship 表 DAO
	public int insertFriendShip(Integer userId, String sinaId,
			String friendsinaId, Integer friendId, String userNick) {
		Map param = new HashMap();
		param.put("userId", BigDecimal.valueOf(userId));
		param.put("sinaId", sinaId);
		param.put("friendSinaId", friendsinaId);
		param.put("friendId", BigDecimal.valueOf(friendId));
		param.put("ainfo", userNick);
		int i = sinaMapper.insertFriendShip(param);
		return i;
	}

	public int updateSinaUserBeanToDBwithUser(Integer Id, Integer userId,
			Map userDb, User userBean) {
		String sinaSex = userDb.get("SEX").toString();
		Integer sinaAge = Integer.valueOf(userDb.get("AGE").toString());
		String sinaCity = userDb.get("CITY").toString();
		String sinaLocal = userDb.get("LOCAL").toString();
		String sinaDes = userDb.get("DES").toString();
		String sinaPicUrl = userDb.get("PIC").toString();
		int i = updateSinaDAO(Id, userId, userBean.getId(), userBean.getName(),
				sinaSex, sinaAge, sinaCity, sinaLocal, sinaDes, sinaPicUrl, "Y");
		return i;
	}

	// 存在 uuid suid 的关系
	public int insertSinaUserBeanToDBwithUser(Integer userId, Map userDb,
			User userBean) {
		LOG.info("存在 uuid :" + userId + " suid :" + userBean.getId() + " 的关系");
		String sinaSex = userDb.get("SEX").toString();
		Integer sinaAge = Integer.valueOf(userDb.get("AGE").toString());
		String sinaCity = userDb.get("CITY").toString();
		String sinaLocal = userDb.get("LOCAL").toString();
		String sinaDes = userDb.get("DES").toString();
		String sinaPicUrl = userDb.get("PIC").toString();
		String status = "Y";
		int i = insertSinaDAO(userId, userBean.getId(), userBean.getName(),
				sinaSex, sinaAge, sinaCity, sinaLocal, sinaDes, sinaPicUrl,
				status);
		return i;
	}

	// 不存在 uuid suid 的关系
	public int insertSinaUserBeanToDBwithoutUser(Integer userId, User user) {
		LOG.info("不存在 uuid :" + userId + " suid :" + user.getId() + " 的关系");
		int i = insertSinaDAO(userId, user.getId(), user.getName(), null, null,
				null, null, user.getDescription(), user.getAvatarLarge(), "N");
		return i;
	}

	public Integer updateSinaDAO(String sinaId) {
		Integer hasSinaUser = hasSinaUser(sinaId);
		if (hasSinaUser != null) {
			return hasSinaUser;
		} else {
			return null;
		}
	}

	// 更新 c sina 表 DAO
	public int updateSinaDAO(Integer id, Integer userId, String sinaId,
			String sinaNick, String sinaSex, Integer sinaAge, String sinaCity,
			String sinaLocal, String sinaDes, String sinaPicUrl, String status) {
		CSina sinaUser = new CSina();
		sinaUser.setId(BigDecimal.valueOf(id));
		if (userId != null)
			sinaUser.setUserId(BigDecimal.valueOf(userId));
		sinaUser.setSinaNick(sinaNick);
		sinaUser.setSinaSex(sinaSex);
		if (sinaAge != null)
			sinaUser.setSinaAge(BigDecimal.valueOf(sinaAge));
		sinaUser.setSinaCity(sinaCity);
		sinaUser.setSinaLocal(sinaLocal);
		sinaUser.setSinaDes(sinaDes);
		sinaUser.setSinaPicurl(sinaPicUrl);
		sinaUser.setStatus(status);
		int i = cSinaMapper.updateByPrimaryKey(sinaUser);
		return i;
	}

	// 插入 c sina 表DAO
	public int insertSinaDAO(Integer userId, String sinaId, String sinaNick,
			String sinaSex, Integer sinaAge, String sinaCity, String sinaLocal,
			String sinaDes, String sinaPicUrl, String status) {

		Map param = new HashMap();
		if (userId != null)
			param.put("userId", BigDecimal.valueOf(userId));
		param.put("sinaId", sinaId);
		param.put("sinaNick", sinaNick);
		param.put("sinaSex", sinaSex);
		if (sinaAge != null)
			param.put("sinaAge", BigDecimal.valueOf(sinaAge));
		param.put("sinaCity", sinaCity);
		param.put("sinaLocal", sinaLocal);
		param.put("sinaDes", sinaDes);
		param.put("sinaPicUrl", sinaPicUrl);
		param.put("status", status);
		return sinaMapper.insertSinaAccount(param);
	}

	public void insertSinaUser(String suid) {
		System.out.println("插入 inserSinaUser   Start  1");
		User sinaUserDB = getSinaUserDB(suid);
		insertSinaUser(0, suid, sinaUserDB.getName(), null, null,
				sinaUserDB.getCity(), null, sinaUserDB.getDescription(),
				sinaUserDB.getAvatarLarge(), "Y");
		System.out.println("插入 inserSinaUser   end");
	}

	public void insertSinaUser(Integer uuid, String suid, String nick,
			String sex, Integer age, Integer city, String local, String des,
			String pic, String status) {
		System.out.println("插入 inserSinaUser   Start  2");
		if (uuid != null && suid != null) {
			System.out.println("插入 inserSinaUser   Start  3");
			CSina sinaUser = new CSina();
			Integer id = sinaMapper.queryId();
			sinaUser.setId((BigDecimal.valueOf(id)));
			if (uuid != null)
				sinaUser.setUserId(BigDecimal.valueOf(uuid));
			sinaUser.setSinaId(suid);
			sinaUser.setSinaNick(nick);
			sinaUser.setSinaSex(sex);
			if (age != null)
				sinaUser.setSinaAge(BigDecimal.valueOf(age));
			if (city != null)
				sinaUser.setSinaCity(String.valueOf(city));
			sinaUser.setSinaLocal(local);
			sinaUser.setSinaPicurl(pic);
			sinaUser.setUpdatetime(new Date());
			sinaUser.setStatus(status);
			cSinaMapper.insertSelective(sinaUser);
			System.out.println("插入 inserSinaUser   Start  4");
		}
	}

	public void updateSinaUser(Integer id, Integer uuid, String suid,
			String nick, String sex, Integer age, String city, String local,
			String des, String pic, String status) {
		if (uuid != null && suid != null) {
			CSina sinaUser = new CSina();
			sinaUser.setId((BigDecimal.valueOf(id)));
			sinaUser.setUserId(BigDecimal.valueOf(uuid));
			sinaUser.setSinaId(suid);
			sinaUser.setSinaNick(nick);
			sinaUser.setSinaSex(sex);
			sinaUser.setSinaAge(BigDecimal.valueOf(age));
			sinaUser.setSinaCity(city);
			sinaUser.setSinaLocal(local);
			sinaUser.setSinaPicurl(pic);
			sinaUser.setUpdatetime(new Date());
			sinaUser.setStatus(status);
			cSinaMapper.updateByPrimaryKeySelective(sinaUser);
		}
	}

	public void updateSinaUser(String uuid, String suid) {
		User sinaUserDB = getSinaUserDB(suid);
		System.out.println("SINA_ACCOUNT:" + sinaUserDB);
		if (sinaUserDB != null) {
		} else {
			// 新浪用户不存在
		}

	}

	public User getSinaUserDB(String suid) {
		Users um = new Users();
		um.client.setToken(access_token);
		try {
			User user = um.showUserById(suid);
			Log.logInfo(user.toString());
			return user;
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 获得 新浪好友数据，，，
	public UserWapper getFriendsListBySina(String suid) {
		Friendships fm = new Friendships();
		fm.client.setToken(access_token);
		try {
			UserWapper users = fm.getFriendsBilateral(suid);
			for (User u : users.getUsers()) {
				Log.logInfo(u.toString());
			}
			System.out.println(users.getNextCursor());
			System.out.println(users.getPreviousCursor());
			System.out.println(users.getTotalNumber());
			return users;
		} catch (WeiboException e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<User> getFriendsList(String suid, int index, int limit) {
		// 默认 limit 为 20
		if (limit == 0) {
			limit = 20;
		}
		if (index == -1) {

		}
		if (limit == -1) {

		}
		if (index == -1) {
			// 调用 好友接口,,,,,,,,
			Friendships fm = new Friendships();
			fm.client.setToken(access_token);
			try {
				UserWapper users = fm.getFriendsBilateral(suid);
				for (User u : users.getUsers()) {
					Log.logInfo(u.toString());
				}
				System.out.println(users.getNextCursor());
				System.out.println(users.getPreviousCursor());
				System.out.println(users.getTotalNumber());
				return users.getUsers();
			} catch (WeiboException e) {
				e.printStackTrace();
			}
		} else {
			// 调用 好友接口,,,,,,,,
			Friendships fm = new Friendships();
			fm.client.setToken(access_token);
			try {
				UserWapper users = fm.getFriendsBilateral(suid);
				for (User u : users.getUsers()) {
					Log.logInfo(u.toString());
				}
				System.out.println(users.getNextCursor());
				System.out.println(users.getPreviousCursor());
				System.out.println(users.getTotalNumber());
			} catch (WeiboException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	public String[] getFriendsIds(String suid, int index, int limit) {
		// 默认 limit 为 20
		if (limit == 0) {
			limit = 20;
		}
		// 调用 好友接口,,,,,,,,
		Friendships fm = new Friendships();
		fm.client.setToken(access_token);
		try {
			String[] ids = fm.getFriendsIdsByUid(suid);
			for (String s : ids) {
				Log.logInfo(s);
			}
			String[] iids = new String[limit];
			if (ids.length > index + limit) {
				for (int i = index; i < limit; i++) {
					iids[i] = ids[i];
				}
				return iids;
			} else {
				return ids;
			}
		} catch (WeiboException e) {
			return null;
		}
	}

	public String[] getFriendSBilateralIds(String suid) {
		Friendships fm = new Friendships();
		fm.client.setToken(access_token);
		try {

			String[] ids = fm.getFriendsIdsByUid(suid);
			for (String s : ids) {
				Log.logInfo(s);
			}
			return ids;
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List getfriendList(String uuid, String suid) {
		// TODO Auto-generated method stub
		Map param = new HashMap();
		param.put("UUID", uuid);
		param.put("SUID", suid);
		List friendshipLIst = sinaMapper.queryFriendShipByUUIDAndSUID(param);
		return friendshipLIst;
	}

	public int hasUserSet(String suid) {
		// TODO Auto-generated method stub
		Map param = new HashMap();
		param.put("SUID", suid);
		return sinaMapper.hasUserSetByBOUNDSINAID(param);
	}

}
