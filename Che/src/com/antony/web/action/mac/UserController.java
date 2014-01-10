package com.antony.web.action.mac;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.antony.mail.task.RejectMailTask;
import com.antony.web.action.BaseController;

@Controller
@RequestMapping("/mac/user")
public class UserController extends BaseController {
	private static final Log log = LogFactory.getLog(UserController.class);

	public String pic;

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@RequestMapping("IF00040")
	public void IF00040(HttpServletRequest request, HttpServletResponse response) {
		try {

			String uuid = request.getParameter("uuid");
			String sex = request.getParameter("user_sex");
			String age = request.getParameter("user_age");
			System.out.println("IF00040  param   request map "
					+ request.getParameterMap());
			System.out.println("IF00040    UUID " + uuid +"sex:"+sex+"age:"+age);
			// 修改用户年龄
			Integer v = 0;
			if (age != null) {
				try {
					v = Integer.valueOf(age);
				} catch (Exception e) {
					v = 0;
				}
			}
			Map param = new HashMap();
			param.put("UUID", uuid);
			param.put("SEX", sex);
			param.put("AGE", v);
			param.put("DES", "这家伙很懒什么也没留下，，，");
			int i = getServMgr().getUserService().updateUserFromMap(param);

			Map json = new HashMap();
			json.put("status", 200);
			sendJson(response, json);
			return;
		} catch (Exception e) {
			// TODO: handle exception
			Map json = new HashMap();
			json.put("status", 300);
			sendJson(response, json);
			return;
		}
	}

	@RequestMapping("IF00037")
	public void IF00037(HttpServletRequest request, HttpServletResponse response) {
		// 获得数据
		String uuid = request.getParameter("uuid");
		String city = request.getParameter("city");
		String local = request.getParameter("local");

		// 查询全部好友，， 根据地区 选择全部好友
		city = "北京";
		List userList = getServMgr().getUserService().getAllUserList(uuid,
				city, local);

		Map json = new HashMap();
		json.put("status", 200);
		json.put("message", "读取成功");
		json.put("userList", userList);
		sendJson(response, json);
		return;
		// 返回结果

	}

	@RequestMapping("IF00038")
	public void IF00038(HttpServletRequest request, HttpServletResponse response) {
		// 获得数据
		String uuid = request.getParameter("uuid");
		String userMail = request.getParameter("user_mail");
		String userPass = request.getParameter("user_mail_pass");
		// 修改密码
		try {
			int i = getServMgr().getUserService().updateUserPass(uuid,
					userMail, userPass);
			// 返回json
			if (i > 0) {
				Map json = new HashMap();
				json.put("status", 200);
				sendJson(response, json);
			} else {
				Map json = new HashMap();
				json.put("status", 300);
				sendJson(response, json);
			}

		} catch (Exception e) {
			// TODO: handle exception
			Map json = new HashMap();
			json.put("status", 300);
			sendJson(response, json);
		}

	}

	@RequestMapping("")
	public void index(HttpServletRequest request, HttpServletResponse response) {
		List list = getServMgr().getPartyService().list();
		System.out.println(list);
		Map json = new HashMap();
		json.put("status", 200);
		json.put("party", list);
		sendJson(response, json);

	}

	@RequestMapping("IF00003")
	public void IF0003(HttpServletRequest request, HttpServletResponse response) {
		String uuid = request.getParameter("uuid");
		String friendId = request.getParameter("user_id");
		Map info = getServMgr().getUserService()
				.getFriendInfoByUUIDandFriendId(uuid, friendId);
		Map json = new HashMap();

		System.out.println(info);

		if (info != null) {
			json.putAll(info);
			json.put("message", "读取成功");
			json.put("status", 200);
		} else {
			json.put("message", "读取失败");
			json.put("status", 300);
		}
		sendJson(response, json);

	}

	@RequestMapping("IF00008")
	public void IF00008(HttpServletRequest request, HttpServletResponse response) {
		String uuid = request.getParameter("uuid");
		Map userInfo = null;
		if (uuid != null)
			userInfo = getServMgr().getUserService().getUserByUUID(uuid);
		if (userInfo != null) {
			Map json = new HashMap();
			json.putAll(userInfo);
			json.put("message", "读取成功");
			json.put("status", 200);
			sendJson(response, json);
		} else {
			Map json = new HashMap();

			json.put("message", "读取失败");
			json.put("status", 300);
			sendJson(response, json);
		}

	}

	@RequestMapping("IF00009")
	public void IF00009(HttpServletRequest request, HttpServletResponse response) {
		String uuid = request.getParameter("uuid");
		String fo = request.getParameter("from");
		String t = request.getParameter("to");
		Integer to;
		Integer from;
		if (fo != null) {
			from = Integer.valueOf(fo);
		} else {
			from = 1;
		}
		if (t != null) {
			to = Integer.valueOf(t);
		} else {
			to = 20;
		}
		List friendList = getServMgr().getUserService().getFriendListByUUID(
				uuid, from, to);
		Integer count_friendListbyuuid = getServMgr().getUserService()
				.count_friendListByuuid();
		Map json = new HashMap();
		json.put("users", friendList);
		json.put("index_num", count_friendListbyuuid);
		json.put("total", friendList.size());
		json.put("message", "读取成功");
		json.put("status", 200);
		sendJson(response, json);

	}

	@RequestMapping("IF00012")
	public void IF00012(HttpServletRequest request, HttpServletResponse response) {
		log.info("IF00012   MAP PARAM "+request.getParameterMap()  +"START");
		String uuid = request.getParameter("uuid");
		String friendid = request.getParameter("user_id");
		if (uuid != null && friendid != null) {
			Integer uid = Integer.valueOf(uuid);
			Integer friend_id = Integer.valueOf(friendid);
			Map verfriend = getServMgr().getUserService().verFriend(uid,
					friend_id);
			if (verfriend != null) {
				Map json = new HashMap();
				json.put("status", 300);
				sendJson(response, json);
			} else {
				Integer userMessage = getServMgr().getUserService().userFriend(
						uid);
				if (userMessage != null) {
					getServMgr().getUserService().Delete_userfriend(userMessage, friend_id);
					getServMgr().getUserService().addFriend(userMessage,
							friend_id);
					getServMgr().getUserService().Friend_addMessage(
							userMessage, friend_id);
					//添加好友的计数器
					getServMgr().getUserService().update_M_CountForFriend(friend_id);
					Map json = new HashMap();
					json.put("status", 200);
					sendJson(response, json);
				}
			}
		} else {
			Map json = new HashMap();
			json.put("status", 300);
			sendJson(response, json);
		}
		log.info("IF00012    END");
	}

	private static final long serialVersionUID = 1L;
	private int len = 0;// 处理流
	private int mm = 0;// 重命名
	private static String systemDir;

	private static String baseDir = "/uploads/";// 上传文件存储目录
	private static String flexDir = "/COMBOIMG/";// 上传文件存储目录

	private static String quanDir = "/uploads/";// 上传文件存储目录

	private static String fileExt = "jpg,jpeg,bmp,gif,png";
	private static Long maxSize = 0l;
	// 0:不建目录 1:按天存入目录 2:按月存入目录 3:按扩展名存目录 建议使用按天存
	private static String dirType = "1";

	@RequestMapping("IF00022")
	public void IF00022(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("IF00022   START     ");
		String uid = request.getParameter("uuid");
		String fid = request.getParameter("user_id");
		System.out.println(fid);
		Integer uuid = Integer.valueOf(uid);
		Integer user_id = Integer.valueOf(fid);
		getServMgr().getPartyService().deleteRelation(uuid, user_id);
		getServMgr().getPartyService().deleteRelationForFriend(uuid, user_id);
		Map json = new HashMap();
		json.put("status", 200);
		sendJson(response, json);
		System.out.println("IF00022   END     ");
	}
	@RequestMapping("IF00066")
	public void IF00066(
			HttpServletRequest request, HttpServletResponse response) {
		String uid = request.getParameter("uuid");
		String user_nick = request.getParameter("user_nick");
		String user_sex = request.getParameter("user_sex");
		String userage = request.getParameter("user_age");
		String user_local = request.getParameter("user_local");
		String user_des = request.getParameter("user_des");
		String user_city = request.getParameter("user_city");
		Integer uuid = Integer.valueOf(uid);
		Integer user_age = Integer.valueOf(userage);
		Map json = new HashMap();
		json.put("status", 200);

		getServMgr().getUserService().updateUser(user_nick, null, user_sex,
				user_age, user_local, user_des, uuid, user_city);

		sendJson(response, json);

	}

	@RequestMapping("IF00016")
	public void IF00016(HttpServletRequest request, HttpServletResponse response) {
		String uuid = request.getParameter("uuid");
		String fo = request.getParameter("from");
		String t = request.getParameter("to");
		String type = request.getParameter("type");
		Integer to;
		Integer from;
		if (fo != null) {
			from = Integer.valueOf(fo);
		} else {
			from = 1;
		}
		if (t != null) {
			to = Integer.valueOf(t);
		} else {
			to = from+20-1;
		}
		Integer uid = null;
		try {
			uid = Integer.valueOf(uuid);
		} catch (Exception e) {
			// TODO: handle exception
			Map json = new HashMap();
			json.put("status", 300);
			sendJson(response, json);
			return ;
		}
		List friendMessage = getServMgr().getUserService().friendMessage(uid,
				from, to, type);
		Integer count_frendMessage = getServMgr().getUserService()
				.Count_friendMessage(uid);
		for (int i = 0; i < friendMessage.size(); i++) {
			Map fm = (Map) friendMessage.get(i);
			String sign = fm.get("SIGN").toString();
			String m_id = fm.get("M_ID").toString();
			String api = null;
			String app = null;
			if (sign.equals("party")) {
				Map pid = getServMgr().getUserService().friendMessage_ForP_id(
						m_id);
				String ppid = pid.get("P_ID").toString();
				Integer p_id = Integer.valueOf(ppid);
				Map pinf = getServMgr().getUserService()
						.friendMessage_ForP_Info(p_id);
				String p_title = pinf.get("P_TITLE").toString();
				String p_status = pinf.get("P_STATUS").toString();
				fm.put("p_id", ppid);
				fm.put("p_title", p_title);
				fm.put("p_status", p_status);
			} else if (sign.equals("friend")) {
				fm.put("p_id", 0);
			}
		}
		for (int q = 0; q < friendMessage.size(); q++) {
			Map fm1 = (Map) friendMessage.get(q);
			String mid = fm1.get("M_ID").toString();
			String m_sender = fm1.get("M_SENDER").toString();
			Integer m_id = Integer.valueOf(mid);
			Integer fid = Integer.valueOf(m_sender);
			Map sendUser = getServMgr().getUserService().sendUser(uid, m_id,
					fid);
			fm1.put("sender", sendUser);
		}

		Map json = new HashMap();
		json.put("Messages", friendMessage);
		json.put("index_num", count_frendMessage);
		json.put("total", friendMessage.size());
		json.put("status", 200);
		sendJson(response, json);

	}

	@RequestMapping("IF00013")
	public void IF00013(HttpServletRequest request, HttpServletResponse response) {
		log.info("IF00013   MAP PARAM "+request.getParameterMap()  +"START");
		
		String uuid = request.getParameter("uuid");
		Integer uid = Integer.valueOf(uuid);
		String f_id = request.getParameter("user_id");
		Integer fid = Integer.valueOf(f_id);
		int i = getServMgr().getUserService().Delete_ForUser(uid, fid);
		int j = getServMgr().getUserService().Delete_For_User(uid, fid);
		log.info("IF00013   1");
		getServMgr().getUserService().TrueForUser(uid, fid);
		log.info("IF00013   2");
		getServMgr().getUserService().TrueForFriend(uid, fid);
		String time = null;
		//try {
			//获取系统时间
			Map systime = getServMgr().getUserService().Select_Sysdate(uid, fid);
			time = systime.get("TIME").toString();
			System.out.println("系统时间"+time);
		//} catch (Exception e) {
			// TODO: handle exception
		//}
			// System.out.println((new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new time));

		getServMgr().getUserService().Delete_ForTrueUser_Message(uid, fid);
		getServMgr().getUserService().TrueForFriend_Message(time, uid, fid);
		log.info("IF00013   3");
		Map json = new HashMap();
		json.put("status", 200);
		sendJson(response, json);
		log.info("IF00013   MAP PARAM   END");

	}

	@RequestMapping("IF00030")
	public void IF00030(HttpServletRequest request, HttpServletResponse response) {
		try {

			String uuid = request.getParameter("uuid");
			Integer uid = Integer.valueOf(uuid);
			Map userInfo = getServMgr().getUserService().User_Info(uid);
			Map user_set = getServMgr().getUserService().User_Set(uid);
			Map user_set_bound = getServMgr().getUserService().User_Set_Bound(
					uid);
			Map json = new HashMap();
			json.put("status", 200);
			json.put("root", userInfo);
			json.put("user_setid", user_set);
			json.put("user_bounndid", user_set_bound);
			sendJson(response, json);
			return;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("IF000030   系统错误    " + e.getMessage());
			Map json = new HashMap();
			json.put("status", 300);
			json.put("message", "系统错误");
			sendJson(response, json);
			return;
		}
	}

	public Integer IF00036(String mail, String mailPass, String userPic,
			String userNick, String userSex, String userAge) {
		// 注册 接口

		// 接收数据
		log.info("\n\n \t\t  mail:" + mail + "mailPass:" + mailPass
				+ "userPic:" + userPic + "userNick:" + userNick);
		log.info("\n\n \t\t  userSex:" + userSex + "userAge:" + userAge);
		Integer age = null;
		try {
			age = Integer.valueOf(userAge);
		} catch (Exception e) {
			// TODO: handle exception
			log.info("\n\n 年龄输入错误");
		}

		// 验证邮箱 是否存在，

		int code = getServMgr().getUserService().validatorUser(mail, userNick);
		log.info("\n\n \t  验证邮箱是否存在  code:" + code);
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
			Map json = new HashMap();
			json.put("status", 300);
			return 0;
		} else if (code == 6) {
			// 昵称已存在
			log.info("昵称已注册");
			Map json = new HashMap();
			json.put("status", 300);
			return 0;
		} else if (code == 10) {
			// 存在此用户
			Map json = new HashMap();
			json.put("status", 300);
			return 0;
		}
		// 注册用户
		try {
			log.info("用户注册  START");
			Integer uuid = getServMgr().getUserService().createUser(mail,
					mailPass, userPic, userNick, userSex, age);
			log.info("用户注册  END");
			// 返回JSON
			if (uuid != null) {
				Map json = new HashMap();
				json.put("status", 200);
				json.put("uuid", uuid);
				return uuid;
			} else {
				Map json = new HashMap();
				json.put("status", 300);
				return 0;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info("用户注册  报错");
			Map json = new HashMap();
			json.put("status", 300);
			return 0;
		}

	}

	@RequestMapping("IF00036")
	public void IF00036(HttpServletRequest request, HttpServletResponse response) {
		// 注册 接口

		// 接收数据
		String mail = request.getParameter("mail");
		String mailPass = request.getParameter("mail_pass");
		String userPic = request.getParameter("user_pic");
		String userNick = request.getParameter("user_nick");
		String userSex = request.getParameter("user_sex");
		String userAge = request.getParameter("user_age");
		log.info("\n\n \t\t  mail:" + mail + "mailPass:" + mailPass
				+ "userPic:" + userPic + "userNick:" + userNick);
		log.info("\n\n \t\t  userSex:" + userSex + "userAge:" + userAge);
		Integer age = null;
		try {
			age = Integer.valueOf(userAge);
		} catch (Exception e) {
			// TODO: handle exception
			log.info("\n\n 年龄输入错误");
		}

		// 验证邮箱 是否存在，

		int code = getServMgr().getUserService().validatorUser(mail, userNick);
		log.info("\n\n \t  验证邮箱是否存在  code:" + code);
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
			Map json = new HashMap();
			json.put("status", 300);
			sendJson(response, json);
			return;
		} else if (code == 6) {
			// 昵称已存在
			log.info("昵称已注册");
			Map json = new HashMap();
			json.put("status", 300);
			sendJson(response, json);
			return;
		} else if (code == 10) {
			// 存在此用户
			Map json = new HashMap();
			json.put("status", 300);
			sendJson(response, json);
			return;
		}
		// 注册用户
		try {
			log.info("用户注册  START");
			Integer uuid = getServMgr().getUserService().createUser(mail,
					mailPass, userPic, userNick, userSex, age);
			log.info("用户注册  END");
			// 返回JSON
			if (uuid != null) {
				Map json = new HashMap();
				json.put("status", 200);
				json.put("uuid", uuid);
				sendJson(response, json);
			} else {
				Map json = new HashMap();
				json.put("status", 300);
				sendJson(response, json);
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info("用户注册  报错");
			Map json = new HashMap();
			json.put("status", 300);
			sendJson(response, json);
		}
	}

	// 登陆接口，服务器根据传入邮箱是否正确，返回正确标志以及密码以及用户id；
	@RequestMapping("IF00035")
	public void IF00035(HttpServletRequest request, HttpServletResponse response) {
		// 获得 email
		log.info("登录 START");
		String mail = request.getParameter("mail");
		Pattern pattern = Pattern
				.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
		Matcher matcher = pattern.matcher(mail);
		System.out.println(matcher.matches());
		if (!matcher.matches()) {
			System.out.println("邮箱格式错误");
			Map json = new HashMap();
			json.put("status", 400);
			json.put("message", "邮箱格式错误");
			sendJson(response, json);
			return;
		}
		Map user = getServMgr().getUserService().getUserByEmail(mail);
		if (user != null) {
			// 登录成功
			Map json = new HashMap();
			json.put("status", 200);
			json.put("mail_pass", user.get("PASS"));
			json.put("uuid", user.get("UUID"));
			sendJson(response, json);
			log.info("登录 END   成功");
			return;
		} else {
			// 登录失败
			Map json = new HashMap();
			json.put("status", 300);
			json.put("message", "登录失败");
			sendJson(response, json);
			log.info("登录失败 END   ");
			return;
		}
	}

	// 注册信息接口，服务器根据传入邮箱是否正确，返回正确标志；
	@RequestMapping("IF00034")
	public void IF00034(HttpServletRequest request, HttpServletResponse response) {
		// 获得 email
		String mail = request.getParameter("mail");
		System.out.println("mail:" + mail);
		Pattern pattern = Pattern
				.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
		Matcher matcher = pattern.matcher(mail);
		System.out.println(matcher.matches());
		if (!matcher.matches()) {
			System.out.println("邮箱格式错误");
			Map json = new HashMap();
			json.put("status", 400);
			json.put("message", "邮箱格式错误");
			sendJson(response, json);
			return;
		}

		Map user = getServMgr().getUserService().getUserByEmail(mail);
		if (user != null) {
			// 登录成功
			Map json = new HashMap();
			json.put("status", 300);
			json.put("message", "邮箱已存在");
			sendJson(response, json);
			return;
		} else {
			// 登录失败
			Map json = new HashMap();
			json.put("status", 200);
			json.put("message", "邮箱不存在");
			sendJson(response, json);
			return;
		}
	}

}
