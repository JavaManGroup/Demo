package com.antony.web.action.mac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.ListUI;

import org.antonyframework.support.mail.MailManager;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.antony.web.action.BaseController;

@Controller
@RequestMapping("/mac/party")
public class PartyController extends BaseController {
	private static final Log LOG = LogFactory.getLog(PartyController.class);
	@RequestMapping("IF00054")
	public void IF00054(HttpServletRequest request, HttpServletResponse response) {
		//接受数据
		String uid = request.getParameter("user_id");
		System.out.println("申请人ID"+uid);
		String p_id = request.getParameter("p_id");
		Integer user_id = Integer.valueOf(uid);
		Integer pid = Integer.valueOf(p_id);
		//获取派对发起人的ID
		Map userid = getServMgr().getPartyService().Select_Party_User(pid);
		String partycreaterid = userid.get("USERID").toString();
		Integer puid = Integer.valueOf(partycreaterid);
		//读取 message 中MID
		Map m_id = getServMgr().getMessageService().SelectMsgIdToTrueJoinParty(user_id, pid);
		Integer mid = Integer.valueOf(m_id.get("MSG_ID").toString());
		//更新c_take中的状态为Y
		getServMgr().getPartyService().updateRelationForParty(user_id, pid);
		//修改    message  M_PARTY    Y 
		getServMgr().getMessageService().updateFor_M_Pary(pid, mid);
		// 修改 message  M_VIEW    Y
		getServMgr().getMessageService().updateFor_M_VIEWForTrueJoinParty(puid, mid);
		// 修改 message 申请人状态改变 M_VIEW Y
		getServMgr().getMessageService().updateFor_M_VIEWForTrueJoinPartyForUser_Id(user_id, mid);
		// 插入派对邀请券 C_Message 数据
		getServMgr().getPartyService().Message_ForDeleteParty_Pass(puid,
				user_id, pid);
		getServMgr().getPartyService().Message_ForTureParty_Pass(puid, user_id,
				pid);
		// 系统信息 派对入场券计数器
				getServMgr().getPartyService().Update_M_CountForSystem(user_id);
				try {
					String uuid = uid;
					String content = "我们给您带来一条系统信息";
					Integer msgId= mid;
					//插入后台推送消息
					getServMgr().getMessageService().pushMsg(uuid, content, msgId,null);
				} catch (Exception e) {
					// TODO: handle exception
				}
		//返回
		Map json = new HashMap();
		json.put("status", 200);
		sendJson(response, json);
		
	}
	@RequestMapping("IF00053")
	public void IF00053(HttpServletRequest request, HttpServletResponse response) {
		String uid = request.getParameter("uuid");
		String p_id = request.getParameter("p_id");
		Integer user_id = Integer.valueOf(uid);
		Integer pid = Integer.valueOf(p_id);
		
		
		//接收数据
		Map userid = getServMgr().getPartyService().Select_Party_User(pid);
		String partycreaterid = userid.get("USERID").toString();
		String partytype = userid.get("PTYPE").toString();
		String c_id = userid.get("CID").toString();
		Integer cid = Integer.valueOf(c_id);
		Integer pt = Integer.valueOf(partytype);
		Integer puid = Integer.valueOf(partycreaterid);
		
		//修改  take  状态为Y
		getServMgr().getPartyService().updateRelationForCreats(user_id, pid);
		//修改 party 状态为Y
		getServMgr().getPartyService().updateFor_Pary(pid);
		//读取 message 中MID
		Map m_id = getServMgr().getMessageService().SelectMsgIdToUpdate(pid);
		Integer mid = Integer.valueOf(m_id.get("MSG_ID").toString());
		//修改    message  M_PARTY    Y 
		getServMgr().getMessageService().updateFor_M_Pary(pid, mid);
		// 修改 message  M_VIEW    Y
		getServMgr().getMessageService().updateFor_M_VIEW(user_id, mid);
		// 修改 派对创建者 M_VIEW Y
		getServMgr().getMessageService().updateFor_M_VIEWForCreater(puid, mid);
		// 插入派对入场券 C_MESSAGE 数据
		getServMgr().getPartyService().Message_ForDeletePartyCreats_Pass(puid,
				user_id, pid);
		getServMgr().getPartyService().Message_ForTurePartyCreater_Pass(puid,
				user_id, pid);
		// 系统信息 派对入场券计数器
		getServMgr().getPartyService().Update_M_CountForSystem(user_id);
		try {
			String uuid = uid;
			String content = "我们给您带来一条系统信息";
			Integer msgId= mid;
			//插入后台推送消息
			getServMgr().getMessageService().pushMsg(uuid, content, msgId,null);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// 插入活动邀请券 C_MESSAGE 数据
		if (pt != 1) {
			List friendId = getServMgr().getPartyService().Select_C_Take_Pass(
					user_id, cid);
			for (int q = 0; q < friendId.size(); q++) {
				Map friend = (Map) friendId.get(q);
				String f_id = friend.get("USERID").toString();
				Integer fid = Integer.valueOf(f_id);
				// 系统消息活动邀请券 计数器
				getServMgr().getPartyService().Update_M_CountForSystemForPass(fid);
				getServMgr().getPartyService().Insert_M_Message(pid, user_id,
						cid, fid);
				try {
					String uuid = f_id;
					String content = "我们给您带来一条系统信息";
					Integer msgId= mid;
					//插入后台推送消息
					getServMgr().getMessageService().pushMsg(uuid, content, msgId,null);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		//返回
		Map json = new HashMap();
		json.put("status", 200);
		sendJson(response, json);
	}
	
	@RequestMapping("IF00052")
	public void IF00052(HttpServletRequest request, HttpServletResponse response) {
		String uid = request.getParameter("uuid");
		String p_id = request.getParameter("p_id");
		String invite = request.getParameter("m_msg");
		Integer uu_id = Integer.valueOf(uid);
		Integer pid = Integer.valueOf(p_id);
		getServMgr().getPartyService().DeleteParty(uu_id, pid);
		getServMgr().getPartyService().JoinParty(uu_id, pid);
		//获取MSG_ID
		Map seq = getServMgr().getPartyService().getSeq();
		Integer mid = Integer.valueOf(seq.get("SMI").toString());
		//插入M_PARTY
		getServMgr().getMessageService().insertIntoM_PARTYForJoinParty(invite, pid, mid);
		//获取派对发起者的ID
		Map user_id = getServMgr().getPartyService().Select_Party_User(pid);
		String partycreaterid = user_id.get("USERID").toString();
		Integer puid = Integer.valueOf(partycreaterid);
		// getServMgr().getPartyService().insertMessage_ForParty_PartyCreater(puid,
		// pid, invite);
		//getServMgr().getPartyService().Delete_Message_ForParty(uuid, puid, pid);
		//getServMgr().getPartyService().insertMessage_ForParty(uuid, puid, pid,
			//	invite);
		//删除自己的信息 M_SEND表
		getServMgr().getMessageService().DeleteM_SENDFroMine(uu_id, mid);
		//删除M_SEND表内容
		getServMgr().getMessageService().DeleteM_SEND(uu_id, puid, mid);
		//插入自己的信息M_SEND表
		System.out.println("插入自己M_SEND表 11111111111111111111111111111111");
		getServMgr().getMessageService().insertIntoM_SENDForJoinPartyAndMine(uu_id, mid);
		//插入M_SEND表内容
		getServMgr().getMessageService().insertIntoM_SENDForJoinParty(puid, uu_id, mid);
		//删除M_VIEW表内容
		getServMgr().getMessageService().DeleteM_VIEW(uu_id, puid, mid);
		//删除自己的内容M_VIEW表
		getServMgr().getMessageService().DeleteM_VIEWFroMine(uu_id, puid, mid);
		//插入M_VIEW表内容
		getServMgr().getMessageService().insertIntoM_VIEWForJoinParty(puid, mid);
		//插入自己的内容M_VIEW表
		getServMgr().getMessageService().insertIntoM_VIEWForJoinPartyAndMine(uu_id, mid);
		//派对发起人  派对计数器
		Integer userid = puid;
		getServMgr().getPartyService().Update_M_CountForParty(userid);
		//派对发起人  派对计数器
		Integer Puserid = uu_id;
		getServMgr().getPartyService().Update_M_CountForParty(Puserid);
		try {
			String uuid = partycreaterid;
			String content = invite;
			Integer msgId= mid;
			//插入后台推送消息
			getServMgr().getMessageService().pushMsg(uuid, content, msgId,"1");
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			String uuid = uid;
			String content = invite;
			Integer msgId= mid;
			//插入后台推送消息
			getServMgr().getMessageService().pushMsg(uuid, content, msgId,"1");
		} catch (Exception e) {
			// TODO: handle exception
		}
		Map json = new HashMap();
		json.put("status", 200);
		sendJson(response, json);
	}
	@RequestMapping("IF00051")
	public void IF00051(HttpServletRequest request, HttpServletResponse response) {
		// 获取数据
		String title = request.getParameter("p_title");
		String local = request.getParameter("p_local");
		String stime = request.getParameter("p_stime");
		String type = request.getParameter("p_type");
		String user_id = request.getParameter("uuid");
		String info = request.getParameter("p_info");
		String c_id = request.getParameter("c_id");
		String city = request.getParameter("p_city");
		Integer userid = Integer.valueOf(user_id);
		String users = request.getParameter("users");
		String[] friendUser = users.split(",");
		String lng = request.getParameter("lng");
		String lat = request.getParameter("lat");
		String uphone = request.getParameter("p_phone");
		String invite = request.getParameter("p_invite");
		long phone = Long.valueOf(uphone);
		System.out.println("111111111111111" + title);
		System.out.println("lng:" + lng + "lat:" + lat);
		System.out.println("party type   " + type);
		System.out.println("user:" + users);
		Integer cid;
		Map seq;
		Integer spi;
		System.out.println(stime);
		if (info != null && info != "") {
		} else {
			info = "这个人太懒了！！！";
		}
		if (c_id != null && c_id != "") {
			cid = Integer.valueOf(c_id);
		} else {
			cid = 0;
		}
		seq = getServMgr().getPartyService().getSeq();
		// 生成 新的 pid
		spi = Integer.valueOf(seq.get("SPI").toString());
		//Integer newPartyId = Integer.valueOf(getServMgr().getPartyService()
			//	.getSeq().get("SPI").toString());
		//生成新的lid
		Integer sli = Integer.valueOf(seq.get("SLI").toString());
		//生成新的mid
				Integer smi = Integer.valueOf(seq.get("SMI").toString());
		// 插入 partyinfo
		getServMgr().getPartyService().insertParty(spi, title, local, stime,
				type, userid, info, cid, sli, city);
		//派对发起人  派对计数器
				getServMgr().getPartyService().Update_M_CountForParty(userid);
		// 插入 M_VIEW 派对发起人信息
		getServMgr().getMessageService().insertIntoM_VIEWforUser(userid, smi);
		try {
			String uuid = user_id;
			String content = info;
			Integer msgId= smi;
			//插入后台推送消息
			getServMgr().getMessageService().pushMsg(uuid, content, msgId,"1");
		} catch (Exception e) {
			// TODO: handle exception
		}
		//插入 M_SEND 派对发起人信息
		getServMgr().getMessageService().insertIntoM_SENDForUser(userid, smi);
		// 插入 创建人 take 信息
		getServMgr().getPartyService().insertTake_ToUser(spi, userid);
		// 插入 phone to c_user
		getServMgr().getPartyService().UpdatePhone(phone, userid);
		// 插入联合创建人
		for (int i = 0; i < friendUser.length; i++) {
			String user = friendUser[i];
			Integer f_user = Integer.valueOf(user);
			System.out.println("1111111111111111111111111111111111111111"
					+ f_user);
			//派对联合创建人计数器
			getServMgr().getPartyService().Update_M_CountForParty_ToCreater(f_user);
			// 插入联合创建人信息 C_TAKE
			getServMgr().getPartyService().insertTake(spi, f_user);
			// 插入 M_SEND
			getServMgr().getMessageService().insertIntoM_SEND(userid, f_user, smi);
			// 插入 M_VIEW 联合创始人信息
			getServMgr().getMessageService().insertIntoM_VIEW(f_user, smi);
			try {
				String uuid = user;
				String content = info;
				Integer msgId= smi;
				//插入后台推送消息
				getServMgr().getMessageService().pushMsg(uuid, content, msgId,"1");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		// 插入 M_PARTY
		getServMgr().getMessageService().insertIntoM_PARTY(invite, cid, spi, smi);
		// 插入C_LOCAL
		getServMgr().getPartyService().insertLocal(sli, lng, lat);
		Map json = new HashMap();
		json.put("status", 200);
		sendJson(response, json);
	}

	@RequestMapping("IF00050")
	public void IF00050(HttpServletRequest request, HttpServletResponse response) {
		// 获得数据 uuid
		String uuid = request.getParameter("uuid");
		// 临时变量
		String mcontent = null;
		String ppid = null;
		Map senduser;
		Map ruid;
		Map sendInfo = null;
		Integer userid = null;
		Map users = null;
		Map userinfo = null;

		Map creat = null;
		// 通过uuid 查询 主 消息数据
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
			to = from+20-1;
		}
		List msgPk = getServMgr().getMessageService().getMessageByUUID(uuid,
				from, to);
		for (int i = 0; i < msgPk.size(); i++) {
			Map pm = (Map) msgPk.get(i);
			String sender_id = pm.get("SENDER_ID").toString();
			Integer senderid = Integer.valueOf(sender_id);
			String userId = pm.get("USER_ID").toString();
			Integer u_id = Integer.valueOf(userId);
			Integer user_id = null;
			Map userInfo = null;
			Map user_Info=null;
			String pid = pm.get("P_ID").toString();
			Integer p_id = Integer.valueOf(pid);
			// 插入 派对info 信息
			Map mpi = getServMgr().getPartyService().Message_part_info(p_id);
			String use_id = mpi.get("P_UUID").toString();
			Integer uu_id = Integer.valueOf(use_id);
			if(senderid.equals(u_id)){
				//获取user信息
				System.out.println("获取自己的信息1111111111111111");
				user_Info=getServMgr().getPartyService().reUserToInfoFroUser_ID(uu_id);
				user_Info.put("USER_ID", 0);
				pm.put("user", user_Info);
			}else{
				 userInfo = getServMgr().getPartyService().reUserToInfo(u_id);	
				 pm.put("user", userInfo);
			}
			Map mpui = getServMgr().getPartyService().Message_party_UserInfo(
					uu_id);
			List creatersId = getServMgr().getPartyService().Creaters_ForId(
					p_id);
			List creats1 = new ArrayList();
			for (int z = 0; z < creatersId.size(); z++) {
				Map ct = (Map) creatersId.get(z);
				String cr = ct.get("CREAT_ID").toString();
				Integer creatid = Integer.valueOf(cr);
				creat = getServMgr().getPartyService().creat_Info(creatid);
				creats1.add(creat);
			}
			System.out.println("4444444444444444444444444444444444" + creats1);
			// 插入 sender 信息
			sendInfo = getServMgr().getPartyService().sendUserToParty(senderid);
			// 插入 user 信息
					
			mpi.put("p_user_id", mpui);
			pm.put("p_id", mpi);
			pm.put("creats", creats1);
			pm.put("sender", sendInfo);
			
		}
		// 返回数据
		Map tot = getServMgr().getPartyService().PartyToMessageForTotal(uuid);
		String total = tot.get("TOTAL").toString();
		Map json = new HashMap();
		json.put("total", msgPk.size());
		json.put("index_num", total);
		json.put("status", 200);
		json.put("Message", msgPk);
		sendJson(response, json);
	}

	@RequestMapping("IF00002")
	public void IF00002(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("IF00002");
		String uuid = request.getParameter("uuid");
		String party_id = request.getParameter("party_id");
		String c_id = request.getParameter("c_id");
		System.out.println("partId:" + party_id + " UUID:" + uuid);
		// 获得数据

		// 获得派对的基本信息

		Integer i_uuid = 0;
		try {

			i_uuid = Integer.valueOf(uuid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Map partyInfo = getServMgr().getPartyService().getPartyInfo(party_id,
				c_id, i_uuid);
		System.out.println("partyInfo: " + partyInfo);
		// 加入创建者
		try {

			String lat = partyInfo.get("LAT").toString();
			String lng = partyInfo.get("LNG").toString();
			Double d_lat = Double.valueOf(lat);
			Double d_lng = Double.valueOf(lng);
			partyInfo.put("LAT", d_lat);
			partyInfo.put("LNG", d_lng);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("转换出错   " + e.getMessage());
		}
		List creaters = getServMgr().getPartyService().getCreaters(
				Integer.valueOf(party_id));
		// 加入参与者
		// 用户的加入状态
		System.out.println("uuid:" + uuid);
		Map userStatus = getServMgr().getPartyService().getPartyTakeInfo(party_id, uuid);
		// 判断用户加入的状态是否为空
		if(userStatus!=null){
		String UStatus = userStatus.get("STATUS").toString();
		partyInfo.put("P_STATUS", UStatus);
		}else{
		partyInfo.put("P_STATUS", "N");
		}
		Integer pid = Integer.valueOf(party_id);
		List participants = getServMgr().getPartyService().getParticipants(pid);
		System.out.println("partyInfo:" + partyInfo);
		System.out.println("participants:" + participants);
		System.out.println("creaters:" + creaters);
		try {
			partyInfo.put("creaters", creaters);
			partyInfo.put("participants", participants);
		} catch (Exception e) {
		}
		// 判断是否加入
		Map json = new HashMap();
		json.put("status", 200);
		json.put("creat_num", creaters.size());
		json.put("part_num", participants.size());

		System.out.println("userStatus :" + userStatus);
		//if (userStatus != null)
			//partyInfo.put("P_STATUS", "Y");
		//else
			//partyInfo.put("P_STATUS", "N");
		

		json.put("party", partyInfo);
		sendJson(response, json);

	}

	@RequestMapping("IF00001")
	public void IF00001(HttpServletRequest request, HttpServletResponse response) {
		// 获取经纬度
		String lat = request.getParameter("lat");
		String lng = request.getParameter("lng");
		String uuid = request.getParameter("uuid");
		// 判断经纬度，，，是否为空

		String fo = request.getParameter("from");
		String t = request.getParameter("to");
		Integer to;
		Integer from;
		System.out.println("from1111"+fo);
		if (fo != null) {
			from = Integer.valueOf(fo);
		} else {
			from = 1;
		}
		if (t != null) {
			to = Integer.valueOf(t);
		} else {
			to = from+20-1;
			System.out.println("to1111"+to);
		}
		List partys = null;
		if (lat != null && lng != null) {
			// 查找附近的人
			// lat 纬度
			// lng 经度
			partys = getServMgr().getPartyService().getPartys_local(from, to, lat,
					lng);
			double a_1 = 0.1;
			double a_2 = 0.1;
			double b_1 = 0.2;
			double b_2 = 0.2;
			double gps2m = getServMgr().getLocalService().gps2m(a_1, a_2, b_1,
					b_2);
			// 获得精度
			System.out.println("123  uuid :" + uuid + " lat :" + lat + "lng :"
					+ lng);
			System.out.println("查找附近的人" + gps2m);
			// 返回结果

		} else {
			partys = getServMgr().getPartyService().getPartys(from, to, null,
					null);
		}

		System.out.println("PARTYS:" + partys);
		Integer partyCount = getServMgr().getPartyService().getCount();
		Integer pid = 0;
		for (int i = 0; i < partys.size(); i++) {
			Map pt = (Map) partys.get(i);
			Integer userid = Integer.valueOf(pt.get("USER_ID").toString());
			pid = Integer.valueOf(pt.get("P_ID").toString());
			Map pLable = getServMgr().getPartyService().Select_P_LABEL(pid);
			String P_lable = "";
			try {
				P_lable = pLable.get("P_LABLE").toString();
			} catch (Exception e) {
				// TODO: handle exception
			}
			Map user = getServMgr().getPartyService().getUser(userid, pid);
			Integer count_user = getServMgr().getPartyService().count_getUser(
					userid, pid);
			pt.put("P_LABLE", P_lable);
			pt.put("user", user);
			List users = new ArrayList();
			List buuser = getServMgr().getPartyService().buUser(pid);
			for (int j = 0; j < buuser.size(); j++) {
				Map bu = (Map) buuser.get(j);
				users.add(bu);
			}
			pt.put("user_num", count_user);

			pt.put("users", users);
			pt.put("usernum", users.size());
		}

		System.out.println("Partys    -- >" + partys);

		Map json = new HashMap();
		json.put("status", 200);
		json.put("partys", partys);
		json.put("index_num", partyCount);
		json.put("total", partys.size());
		sendJson(response, json);
	}

	@RequestMapping("IF00004")
	public void IF00004(HttpServletRequest request, HttpServletResponse response) {
		String CID = request.getParameter("c_id");
		String uuid = request.getParameter("uuid");
		if (CID != null) {
			Integer CO_ID = Integer.valueOf(CID);
			Integer u_id = Integer.valueOf(uuid);
			Map json = new HashMap();
			List fpic = getServMgr().getPartyService().getFpic(CO_ID);
			List activity = getServMgr().getPartyService().getActivity(CO_ID,
					u_id);
			for (int i = 0; i < activity.size(); i++) {
				Map at = (Map) activity.get(i);
				at.put("c_fpics", fpic);
			}
			json.put("status", 200);
			json.put("activity", activity);
			sendJson(response, json);
		} else {
			Map json = new HashMap();
			json.put("status", 300);
			sendJson(response, json);
		}

	}

	@RequestMapping("IF00005")
	public void IF00005(HttpServletRequest request, HttpServletResponse response) {
		String CID = request.getParameter("c_id");
		String uid = request.getParameter("uuid");
		Integer u_id = Integer.valueOf(uid);
		if (CID != null) {
			Integer CO_ID = Integer.valueOf(CID);
			List fpic = getServMgr().getPartyService().getFpic(CO_ID);
			List hot = getServMgr().getPartyService().getHotActivity(u_id,
					CO_ID);
			for (int i = 0; i < hot.size(); i++) {
				Map ht = (Map) hot.get(i);
				ht.put("c_fpics", fpic);
			}
			Map json = new HashMap();
			json.put("status", 200);
			json.put("hot", hot);
			sendJson(response, json);
		} else {
			Map json = new HashMap();
			json.put("status", 300);
			sendJson(response, json);
		}

	}

	@RequestMapping("IF00007")
	public void IF00007(HttpServletRequest request, HttpServletResponse response) {
		List users = new ArrayList();
		String fo = request.getParameter("from");
		String t = request.getParameter("to");
		String cid = request.getParameter("c_id");
		String uid = request.getParameter("uuid");
		Integer c_id = Integer.valueOf(cid);
		Integer uuid = Integer.valueOf(uid);
		System.out.println(uuid);
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
		Integer friend_id = null;
		List userInfo = getServMgr().getPartyService().getuserToInfo(c_id,
				from, to, uuid);
		System.out.println("11111111111111111111111111111111" + userInfo);
		System.out.println(userInfo);
		for (int j = 0; j < userInfo.size(); j++) {
			Map uf = (Map) userInfo.get(j);
			String friendid = uf.get("USER_ID").toString();
			friend_id = Integer.valueOf(friendid);

			// Map status =
			// getServMgr().getPartyService().userFriendStatus(uuid,friend_id);
			// System.out.println(status);
			// String ut = status.get("USER_STATUS").toString();
			// uf.put("USER_STATUS", ut);
			users.add(uf);
		}
		Integer userNum = getServMgr().getPartyService().getuserNum(c_id);
		Map json = new HashMap();
		json.put("status", 200);
		json.put("user_total", userInfo.size());
		json.put("user_num", userNum);
		json.put("users", users);
		sendJson(response, json);
	}

	@RequestMapping("IF00010")
	public void IF00010(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("接口IF00010");
		String title = request.getParameter("p_title");
		String local = request.getParameter("p_local");
		String stime = request.getParameter("p_stime");
		String type = request.getParameter("p_type");
		String user_id = request.getParameter("uuid");
		String info = request.getParameter("p_info");
		String c_id = request.getParameter("c_id");
		String city = request.getParameter("p_city");
		Integer userid = Integer.valueOf(user_id);
		String users = request.getParameter("users");
		String[] friendUser = users.split(",");
		String lng = request.getParameter("lng");
		String lat = request.getParameter("lat");
		String uphone = request.getParameter("p_phone");
		String invite = request.getParameter("p_invite");
		long phone = Long.valueOf(uphone);
		System.out.println("111111111111111" + title);
		System.out.println("lng:" + lng + "lat:" + lat);
		System.out.println("party type   " + type);
		System.out.println("user:" + users);
		Integer cid;
		Map seq;
		Integer spi;
		System.out.println(stime);
		if (info != null && info != "") {
		} else {
			info = "这个人太懒了！！！";
		}
		if (c_id != null && c_id != "") {
			cid = Integer.valueOf(c_id);
		} else {
			cid = 0;
		}
		seq = getServMgr().getPartyService().getSeq();
		spi = Integer.valueOf(seq.get("SPI").toString());
		Integer sli = Integer.valueOf(seq.get("SLI").toString());

		getServMgr().getPartyService().insertParty(spi, title, local, stime,
				type, userid, info, cid, sli, city);
		getServMgr().getPartyService().insertTake_ToUser(spi, userid);
		getServMgr().getPartyService().UpdatePhone(phone, userid);
		getServMgr().getPartyService().insertInvitational(userid, spi, invite);
		for (int i = 0; i < friendUser.length; i++) {
			String user = friendUser[i];
			Integer f_user = Integer.valueOf(user);
			System.out.println("1111111111111111111111111111111111111111"
					+ f_user);
			getServMgr().getPartyService().insertTake(spi, f_user);
			getServMgr().getPartyService().Message_For_Party(userid, f_user,
					spi);
		}
		List friendId = null;
		if (cid != 0) {
			friendId = getServMgr().getPartyService()
					.Select_C_Join(cid, userid);
			for (int j = 0; j < friendId.size(); j++) {
				Map friend = (Map) friendId.get(j);
				String f_id = friend.get("USERID").toString();
				Integer fid = Integer.valueOf(f_id);
				System.out.println(spi);
				getServMgr().getPartyService().Insert_M_Message_C(spi, cid,
						userid, fid);
				// getServMgr().getPartyService().Insert_M_Message_Party_C(spi,
				// userid, fid);
			}
		} else {
			friendId = getServMgr().getPartyService()
					.Select_C_Take(userid, spi);
			if (friendId != null)
				for (int q = 0; q < friendId.size(); q++) {
					Map friend = (Map) friendId.get(q);
					String f_id = friend.get("USERID").toString();
					Integer fid = Integer.valueOf(f_id);
					System.out.println(spi);
					// getServMgr().getPartyService().Insert_M_Message(spi,
					// userid, cid, fid);
					// getServMgr().getPartyService().Insert_M_Message_Party(spi,
					// cid, userid, fid);
				}
		}
		getServMgr().getPartyService().insertLocal(spi, lng, lat);
		Map json = new HashMap();
		json.put("status", 200);
		sendJson(response, json);

	}

	@RequestMapping("IF00020")
	public void IF00020(HttpServletRequest request, HttpServletResponse response) {
		String uid = request.getParameter("user_id");
		String p_id = request.getParameter("p_id");
		Integer user_id = Integer.valueOf(uid);
		Integer pid = Integer.valueOf(p_id);
		Map userid = getServMgr().getPartyService().Select_Party_User(pid);
		String partycreaterid = userid.get("USERID").toString();
		Integer puid = Integer.valueOf(partycreaterid);
		getServMgr().getPartyService().updateRelationForParty(user_id, pid);
		getServMgr().getPartyService().Message_ForDeleteParty_Pass(puid,
				user_id, pid);
		getServMgr().getPartyService().Message_ForTureParty_Pass(puid, user_id,
				pid);
		Map json = new HashMap();
		json.put("status", 200);
		sendJson(response, json);
	}

	@RequestMapping("IF00021")
	public void IF00021(HttpServletRequest request, HttpServletResponse response) {
		String uid = request.getParameter("uuid");
		String p_id = request.getParameter("p_id");
		Integer user_id = Integer.valueOf(uid);
		Integer pid = Integer.valueOf(p_id);
		Map userid = getServMgr().getPartyService().Select_Party_User(pid);
		String partycreaterid = userid.get("USERID").toString();
		String partytype = userid.get("PTYPE").toString();
		String c_id = userid.get("CID").toString();
		Integer cid = Integer.valueOf(c_id);
		Integer pt = Integer.valueOf(partytype);
		Integer puid = Integer.valueOf(partycreaterid);
		getServMgr().getPartyService().updateRelationForCreats(user_id, pid);
		getServMgr().getPartyService().updateFor_Pary(pid);
		getServMgr().getPartyService().updateFor_Message_Creater(puid, user_id,
				pid);
		getServMgr().getPartyService().Message_ForDeletePartyCreats_Pass(puid,
				user_id, pid);
		getServMgr().getPartyService().Message_ForTurePartyCreater_Pass(puid,
				user_id, pid);
		if (pt != 1) {
			List friendId = getServMgr().getPartyService().Select_C_Take_Pass(
					user_id, cid);
			for (int q = 0; q < friendId.size(); q++) {
				Map friend = (Map) friendId.get(q);
				String f_id = friend.get("USERID").toString();
				Integer fid = Integer.valueOf(f_id);
				getServMgr().getPartyService().Insert_M_Message(pid, user_id,
						cid, fid);
			}
		}
		Map json = new HashMap();
		json.put("status", 200);
		sendJson(response, json);
	}

	@RequestMapping("IF00026")
	public void IF00026(HttpServletRequest request, HttpServletResponse response) {
		String uid = request.getParameter("uuid");
		String cid = request.getParameter("c_id");
		Integer u_id = Integer.valueOf(uid);
		Integer c_id = Integer.valueOf(cid);
		getServMgr().getPartyService().joinActivityToDelete(c_id, u_id);
		getServMgr().getPartyService().joinActivity(c_id, u_id);
		Map json = new HashMap();
		json.put("status", 200);
		sendJson(response, json);
	}

	@RequestMapping("IF00027")
	public void IF00027(HttpServletRequest request, HttpServletResponse response) {
		String uid = request.getParameter("uuid");
		String cid = request.getParameter("c_id");
		Integer u_id = Integer.valueOf(uid);
		Integer c_id = Integer.valueOf(cid);
		getServMgr().getPartyService().deleteActivity(c_id, u_id);
		Map json = new HashMap();
		json.put("status", 200);
		sendJson(response, json);
	}

	@RequestMapping("IF00028")
	public void IF00028(HttpServletRequest request, HttpServletResponse response) {
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
			to = from+20-1;
		}
		List<Map> conllect = getServMgr().getPartyService().getActivityMain(
				from, to);
		for (Map m : conllect) {
			String cid = m.get("C_ID").toString();
			Integer c_id = Integer.valueOf(cid);
		}
		Integer index_num = getServMgr().getPartyService()
				.countActivityForActivity();
		Map json = new HashMap();
		json.put("status", 200);
		json.put("total", conllect.size());
		json.put("index_num", index_num);
		json.put("collects", conllect);
		sendJson(response, json);
	}

	@RequestMapping("IF00029")
	public void IF00029(HttpServletRequest request, HttpServletResponse response) {
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
			to = from+20-1;
		}
		List<Map> conllect = getServMgr().getPartyService()
				.getActivityMainForLocal(from, to);
		for (Map m : conllect) {
			String local_name = m.get("C_LOCAL").toString();
		}
		Integer indexnum = getServMgr().getPartyService()
				.countActivityForLocal();
		Map json = new HashMap();
		json.put("status", 200);
		json.put("total", conllect.size());
		json.put("index_num", indexnum);
		json.put("collects", conllect);
		sendJson(response, json);
	}

	@RequestMapping("IF00018")
	public void IF00018(HttpServletRequest request, HttpServletResponse response) {
		String uid = request.getParameter("uuid");
		String type = request.getParameter("m_type");
		String fo = request.getParameter("from");
		String t = request.getParameter("to");
		Integer uuid = Integer.valueOf(uid);
		Integer to;
		Integer from;
		Integer index_num = null;
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
		
		//获取 index_num 检索系统消息总数
		 index_num = getServMgr().getPartyService().Select_IndexNum_ForSystem(type, uuid);
		List Message = getServMgr().getPartyService().systemMessage(type, from,
				to, uuid);
		String sign;
		for (int i = 0; i < Message.size(); i++) {
			Map ms = (Map) Message.get(i);
			sign = ms.get("SIGN").toString();
			String m_id = ms.get("M_ID").toString();
			String s_id = ms.get("SENDER_ID").toString();
			String c_id = ms.get("C_ID").toString();
			Integer cid = Integer.valueOf(c_id);
			Integer mid = Integer.valueOf(m_id);
			Integer sid = Integer.valueOf(s_id);
			String ppid;
			Integer pp_id = null;
			if (sign.equals("pass")) {
				List pid = getServMgr().getPartyService().messagetoInfo(mid);
				for (int j = 0; j < pid.size(); j++) {
					Map ctitle = getServMgr().getPartyService()
							.systemMessage_CTITLE(cid);
					Map p_id = (Map) pid.get(j);
					ppid = p_id.get("P_ID").toString();
					pp_id = Integer.valueOf(ppid);
					Map phone = getServMgr().getPartyService()
							.userInfo_tophone(sid);
					Map p_title = getServMgr().getPartyService()
							.userInfo_toPartyTitle(pp_id);
					String ptitle = p_title.get("P_TITLE").toString();
					String plocal = p_title.get("P_LOCAL").toString();
					if (phone != null) {
						String ph = phone.get("PHONE").toString();
						ms.put("p_phone", ph);
					}
					ms.put("p_title", ptitle);
					ms.put("p_local", plocal);
					ms.put("p_id", ppid);
				}
			} else if (sign.equals("invite")) {
				List pid = getServMgr().getPartyService().messagetoInfo(mid);
				for (int z = 0; z < pid.size(); z++) {
					Map ctitle = getServMgr().getPartyService()
							.systemMessage_CTITLE(cid);
					String c_title = ctitle.get("C_TITLE").toString();
					String c_type = ctitle.get("C_TYPE").toString();
					Map p_id = (Map) pid.get(z);
					ppid = p_id.get("P_ID").toString();
					pp_id = Integer.valueOf(ppid);
					Map phone = getServMgr().getPartyService()
							.userInfo_tophone(sid);
					Map p_title = getServMgr().getPartyService()
							.userInfo_toPartyTitle(pp_id);
					String ptitle = p_title.get("P_TITLE").toString();
					String plocal = p_title.get("P_LOCAL").toString();
					if (phone != null) {
						String ph = phone.get("PHONE").toString();
						ms.put("p_phone", ph);
					}
					ms.put("p_title", ptitle);
					ms.put("p_local", plocal);
					ms.put("p_id", 0);
					ms.put("c_type", c_type);
					ms.put("c_title", c_title);
				}
			}
		}
		Map json = new HashMap();
		json.put("status", 200);
		json.put("Messages", Message);
		json.put("Index_num", index_num);
		json.put("Total", Message.size());
		sendJson(response, json);
	}

	@RequestMapping("IF00024")
	public void IF00024(HttpServletRequest request, HttpServletResponse response) {
		String uid = request.getParameter("uuid");
		String p_id = request.getParameter("p_id");
		String invite = request.getParameter("m_msg");
		Integer uuid = Integer.valueOf(uid);
		Integer pid = Integer.valueOf(p_id);
		getServMgr().getPartyService().DeleteParty(uuid, pid);
		getServMgr().getPartyService().JoinParty(uuid, pid);
		Map userid = getServMgr().getPartyService().Select_Party_User(pid);
		String partycreaterid = userid.get("USERID").toString();
		Integer puid = Integer.valueOf(partycreaterid);
		// getServMgr().getPartyService().insertMessage_ForParty_PartyCreater(puid,
		// pid, invite);
		getServMgr().getPartyService().Delete_Message_ForParty(uuid, puid, pid);
		getServMgr().getPartyService().insertMessage_ForParty(uuid, puid, pid,
				invite);
		Map json = new HashMap();
		json.put("status", 200);
		sendJson(response, json);
	}

	@RequestMapping("IF00017")
	public void IF00017(HttpServletRequest request, HttpServletResponse response) {
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
		String uid = request.getParameter("uuid");
		String type = request.getParameter("m_type");
		List<Map> partyMessagetoSender;
		Integer uuid = Integer.valueOf(uid);
		List partyMessage = getServMgr().getPartyService().PartyMessage(from,
				to, uuid, type);
		String mcontent = null;
		String ppid = null;
		Map senduser;
		Map ruid;
		Map sendInfo = null;
		Integer userid = null;
		Map users = null;
		Map userinfo = null;

		Map creat = null;

		for (int i = 0; i < partyMessage.size(); i++) {
			Map pm = (Map) partyMessage.get(i);
			String sender_id = pm.get("SENDER_USERID").toString();
			Integer senderid = Integer.valueOf(sender_id);
			String user_id = pm.get("USER_ID").toString();
			Integer u_id = Integer.valueOf(user_id);
			String pid = pm.get("BINFO").toString();
			Integer p_id = Integer.valueOf(pid);
			Map mpi = getServMgr().getPartyService().Message_part_info(p_id);
			String use_id = mpi.get("P_UUID").toString();
			Integer uu_id = Integer.valueOf(use_id);
			Map mpui = getServMgr().getPartyService().Message_party_UserInfo(
					uu_id);
			List creatersId = getServMgr().getPartyService().Creaters_ForId(
					p_id);
			List creats1 = new ArrayList();
			for (int z = 0; z < creatersId.size(); z++) {
				Map ct = (Map) creatersId.get(z);
				String cr = ct.get("CREAT_ID").toString();
				Integer creatid = Integer.valueOf(cr);
				creat = getServMgr().getPartyService().creat_Info(creatid);
				creats1.add(creat);
			}
			System.out.println("4444444444444444444444444444444444" + creats1);
			sendInfo = getServMgr().getPartyService().sendUserToParty(senderid);
			Map userInfo = getServMgr().getPartyService().reUserToInfo(u_id);
			mpi.put("p_user_id", mpui);
			pm.put("p_id", mpi);
			pm.put("creats", creats1);
			pm.put("sender", sendInfo);
			pm.put("user", userInfo);
		}
		System.out.println("888888888888888888888888888888" + partyMessage);
		partyMessagetoSender = getServMgr().getPartyService()
				.PartyMessageToSender(from, to, uuid, type);
		/*
		 * List<Map> list = new ArrayList(); boolean list_f = false; for(Map m
		 * :partyMessagetoSender){ if(!list_f){ list.add(m); } list_f =false;
		 * String pid = m.get("BINFO").toString(); String sign =
		 * m.get("SIGN").toString(); System.out.println("pid:"+pid
		 * +"sign:"+sign); if(list!=null){ for(Map mo:list){ String pidd =
		 * mo.get("BINFO").toString(); String signn = mo.get("SIGN").toString();
		 * System.out.println("pidd:"+pidd +"sign:"+signn);
		 * if(pid!=pidd&&signn!=sign){ list_f = true; } }} else{ list_f= false;
		 * }
		 * 
		 * 
		 * } System.out.println("lihao      list size "+list.size());
		 */
		// String logo = "a";
		// List partyMessagetoSender = null;
		for (int k = 0; k < partyMessagetoSender.size(); k++) {
			Map pms = (Map) partyMessagetoSender.get(k);
			String sign = pms.get("SIGN").toString();
			String cpid = pms.get("BINFO").toString();
			System.out.println("111111111111111111111111111111111" + sign);
			if (sign.equals("comcreater")) {
				// if(logo.equals(cpid)){
				// }else{
				// logo=pms.get("BINFO").toString();
				// System.out.println("comcreater.size zzzzzzzzzzzzzzzzzzzzzzzzzzzzz"+logo);
				// System.out.println("222222222222222222222222222222222");
				partyMessagetoSender = getServMgr().getPartyService()
						.PartyMessageToSender_comcreater(from, to, uuid, type,
								cpid);
				// }
			} else if (sign.equals("joinparty")) {
				System.out.println("33333333333333333333333333333333333");
				partyMessagetoSender = getServMgr().getPartyService()
						.PartyMessageToSender_joinparty(from, to, uuid, type);
			}
			System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
					+ partyMessagetoSender.size());
			for (int j = 0; j < partyMessagetoSender.size(); j++) {
				System.out.println("10100101010101010101010");
				Map ps = (Map) partyMessagetoSender.get(j);
				String user_id = ps.get("USER_ID").toString();
				String sender_id = ps.get("SENDER_USERID").toString();
				Integer senderid = Integer.valueOf(sender_id);
				Integer u_id = Integer.valueOf(user_id);
				String pid = ps.get("BINFO").toString();
				Integer p_id = Integer.valueOf(pid);
				Map mpi = getServMgr().getPartyService()
						.Message_part_info(p_id);
				String use_id = mpi.get("P_UUID").toString();
				Integer uu_id = Integer.valueOf(use_id);
				Map mpui = this.getServMgr().getPartyService()
						.Message_party_UserInfo(uu_id);
				List creatersId = getServMgr().getPartyService()
						.Creaters_ForId(p_id);
				List creats2 = new ArrayList();
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
						+ creats2);
				for (int q = 0; q < creatersId.size(); q++) {
					Map ct = (Map) creatersId.get(q);
					String cr = ct.get("CREAT_ID").toString();
					Integer creatid = Integer.valueOf(cr);
					creat = getServMgr().getPartyService().creat_Info(creatid);
					creats2.add(creat);
				}
				sendInfo = getServMgr().getPartyService().sendUserToParty(
						senderid);
				Map userInfo = getServMgr().getPartyService()
						.reUserToInfo(u_id);
				mpi.put("p_user_id", mpui);
				ps.put("p_id", mpi);
				ps.put("creats", creats2);
				ps.put("sender", sendInfo);
				ps.put("user", userInfo);
				partyMessage.add(ps);
				System.out.println("999999999999999999999999999999999999999999"
						+ ps);
			}
		}
		Map tot = getServMgr().getPartyService().PartyMessageForTotal(uuid,
				type);
		String total = tot.get("TOTAL").toString();
		Map json = new HashMap();
		json.put("message", partyMessage);
		json.put("total", partyMessage.size());
		json.put("index_num", total);
		json.put("status", 200);
		sendJson(response, json);
	}

	@RequestMapping("IF00006")
	public void IF00006(HttpServletRequest request, HttpServletResponse response) {
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
			to = from+20-1;
		}

		String uid = request.getParameter("uuid");
		String cid = request.getParameter("c_id");
		Integer c_id = Integer.valueOf(cid);
		Integer uuid = Integer.valueOf(uid);
		List party_Info = getServMgr().getPartyService().Partys_Info(from, to,
				c_id);
		System.out.println(party_Info);
		Map Creaters_Info = null;
		List comCreatersPic = null;
		for (int j = 0; j < party_Info.size(); j++) {
			Map pif = (Map) party_Info.get(j);
			String u = pif.get("USER_ID").toString();
			String p = pif.get("P_ID").toString();
			Integer p_id = Integer.valueOf(p);
			Integer u_id = Integer.valueOf(u);
			Creaters_Info = getServMgr().getPartyService().Creaters_Info(u_id);
			comCreatersPic = getServMgr().getPartyService()
					.comCreatersPic(p_id);
			Map cp = null;
			Integer count_comCreatersPic = null;
			count_comCreatersPic = getServMgr().getPartyService()
					.Count_comCreatersPic(p_id);
			pif.put("puni_creaters", comCreatersPic);
			pif.put("puni_num", count_comCreatersPic);
		}
		Integer count_party_info = getServMgr().getPartyService()
				.Count_Partys_Inof(c_id);
		Map Activity_label = getServMgr().getPartyService()
				.Activity_label(c_id);
		String label = Activity_label.get("C_LABEL").toString();
		for (int i = 0; i < party_Info.size(); i++) {
			Map pi = (Map) party_Info.get(i);
			pi.put("ps_creater", Creaters_Info);
		}
		Map json = new HashMap();
		json.put("status", 200);
		json.put("partys", party_Info);
		json.put("c_label", label);
		json.put("c_total", party_Info.size());
		json.put("c_pnum", count_party_info);
		sendJson(response, json);

	}

	@RequestMapping("IF00023")
	public void IF00023(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("\n  IF00023  PARAM:" + request.getParameterMap());
		String uid = request.getParameter("uuid");
		String p_id = request.getParameter("p_id");
		String f_id = request.getParameter("user_id");
		Integer uuid = Integer.valueOf(uid);
		Integer pid = null;
		try {
			pid = Integer.valueOf(p_id);
		} catch (Exception e) {
			// TODO: handle exception
			pid = null;
		}

		Integer fid = Integer.valueOf(f_id);
		getServMgr().getPartyService().DeletefriendToParty(uuid, fid, pid);
		getServMgr().getPartyService().AddfriendToParty(uuid, fid, pid);
		getServMgr().getPartyService()
				.DeletefriendTofriendParty(uuid, fid, pid);
		getServMgr().getPartyService()
				.InsertfriendTofriendParty(uuid, fid, pid);
		//邀请好友的计数器
		Integer friend_id = fid;
		getServMgr().getUserService().update_M_CountForFriend(friend_id);
		Map json = new HashMap();
		json.put("status", 200);
		sendJson(response, json);
		System.out.println("\n  IF00023  PARAM:" + request.getParameterMap()
				+ "END");
	}

	@RequestMapping("IF00041")
	public void IF00041(HttpServletRequest request, HttpServletResponse response) {
		String uid = request.getParameter("uuid");
		String p_id = request.getParameter("p_id");
		System.out.println("IF00041   uid:" + uid + " P_ID:" + p_id);
		Integer uuid = Integer.valueOf(uid);
		Integer pid = Integer.valueOf(p_id);
		getServMgr().getPartyService().ExitParty(uuid, pid);
		Map json = new HashMap();
		json.put("status", 200);
		sendJson(response, json);
	}

}
