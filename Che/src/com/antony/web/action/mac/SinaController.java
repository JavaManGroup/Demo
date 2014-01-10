package com.antony.web.action.mac;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import weibo4j.examples.oauth2.Log;
import weibo4j.model.RateLimitStatus;
import weibo4j.model.User;

import com.antony.web.action.BaseController;

@Controller
@RequestMapping("/mac/sina")
public class SinaController extends BaseController {

	@RequestMapping("SF00001")
	public void SF00001(HttpServletRequest request, HttpServletResponse response) {
		String uuid = request.getParameter("uuid");
		String suid = request.getParameter("suid");
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		System.out.println("uuid:" + uuid + "suid:" + suid);
		Integer index = 10;
		Integer limit = 20;
		Integer end = 20;
		List friendList = getServMgr().getSinaService().getfriendList(uuid,
				suid);
		if (from != null) {
			try {
				index = Integer.valueOf(from);
			} catch (Exception e) {
				// TODO: handle exception
				Map json = new HashMap();
				json.put("status", 300);
				sendJson(response, json);
				return;
			}

			end = index + limit;

			if (end > friendList.size()) {
				end = friendList.size();
			}
			if (index > friendList.size()) {
				index = end - limit;
			}

		}
		System.out.println("index:" + index + "limit:" + limit + "end:" + end);
		List subList = friendList.subList(index, end);
		System.out.println(friendList);
		Map json = new HashMap();
		json.put("status", 200);
		json.put("friendShip", subList);
		json.put("total", friendList.size());
		json.put("size", subList.size());
		sendJson(response, json);
	}

	@RequestMapping("SIF00001")
	public void index(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("SIF00001 START"  );
		String uuid = request.getParameter("uuid");
		String suid = request.getParameter("suid");
		System.out.println("uuid:" + uuid + "suid:" + suid);
		Map json = new HashMap();
		int count = getServMgr().getSinaService().hasUserSet(suid);
		if(count == 0){
			User sinaUser = getServMgr().getSinaService().insertSinaUidByUUID(uuid,
					suid);
			json.put("status", 200);
			json.put("user", sinaUser);
			sendJson(response, json);
			System.out.println("SIF00001 END"  );
		}else{
			json.put("status", 300);
			sendJson(response, json);
			System.out.println("SIF00001 END"  );
		}
		
		
	}

	@RequestMapping("SIF00000")
	public void SIF00000(HttpServletRequest request,
			HttpServletResponse response) {
		
		Log.logInfo("SIF00000");
		// 接收新浪 SUID
		String suid = request.getParameter("suid");
		// 判断是否存在 这个新浪用户
		System.out.println("suid :" + suid);
		int count = getServMgr().getSinaService().hasUserSet(suid);
		// 得到新浪的个人信息
		if (count == 0) {
			User sinaUserDB = getServMgr().getSinaService().getSinaUserDB(suid);

			// 生成新的用户
			// 返回新浪的个人信息
			Integer createUser = getServMgr().getUserService().createUser(
					sinaUserDB.getId(), suid, sinaUserDB.getAvatarLarge(),
					sinaUserDB.getName(), "M", 0);
			Map json = new HashMap();
			json.put("status", 200);
			json.put("sina_user", sinaUserDB);
			json.put("uuid", createUser);
			sendJson(response, json);
		} else {
			Map json = new HashMap();
			Map sina_user = new HashMap();
			json.put("status", 300);
			sina_user.put("message", "用户已绑定");
			Map uuid = getServMgr().getUserService().getUUIDBySUID(suid);
			json.put("uuid", Integer.valueOf(uuid.get("USER_ID").toString()));
			json.put("sina_user", sina_user);
			
			sendJson(response, json);
		}
	}

	@RequestMapping("SIF00002")
	public void getFriends(HttpServletRequest request,
			HttpServletResponse response) {
		String uuid = request.getParameter("uuid");
		Map json = new HashMap();
		List friendList = getServMgr().getSinaService().list(uuid);
		json.put("status", 200);
		sendJson(response, json);

	}

	@RequestMapping("SIF00003")
	public void updateSinaDB(HttpServletRequest request,
			HttpServletResponse response) {
		String uuid = request.getParameter("uuid");
		getServMgr().getSinaService().updateSinaUser(uuid);

		Map json = new HashMap();
		json.put("status", 200);
		sendJson(response, json);
	}

	@RequestMapping("SIF10001")
	public void updateFriendShip(HttpServletRequest request,
			HttpServletResponse response) {
		String suid = request.getParameter("suid");
		Integer count = getServMgr().getSinaService()
				.insertSinaFriendShip(suid);
		Map json = new HashMap();
		json.put("status", 200);
		json.put("count", count);
		sendJson(response, json);
	}

	@RequestMapping("limit")
	public void limit(HttpServletRequest request, HttpServletResponse response) {
		String suid = request.getParameter("suid");
		RateLimitStatus limit = getServMgr().getSinaService()
				.getAccountRateLimitStatus();
		Map json = new HashMap();
		json.put("status", 200);
		json.put("limit", limit);
		sendJson(response, json);
	}

}
