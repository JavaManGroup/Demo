package com.antony.service.msg.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javapns.back.PushNotificationManager;
import javapns.back.SSLConnectionHelper;
import javapns.data.Device;
import javapns.data.PayLoad;

import org.antonyframework.service.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import com.antony.service.MessageManager;
import com.antony.service.msg.db.MessageMapper;

public class MessageService extends BaseService {

	public int updateToken(String uuid ,String token){
		Map param = new HashMap();
		param.put("uuid", Integer.valueOf(uuid));
		param.put("token", token);
		int i = messageMapper.updateTokenByUUID(param);
		return i;
	}
	
	public int pushMsg(String uuid, String content,Integer msgId,String type) {
		// 通过uuid 获得token
		System.out.println("推送消息  uuid:"+uuid +"content:"+content+"type:"+type);
		
		String token = "";
		Map param = new HashMap();
		param.put("uuid", Integer.valueOf(uuid));
		Map M_token = messageMapper.queryTokenByUUID(param);
		System.out.println(M_token.get("TOKEN"));
		token = M_token.get("TOKEN").toString();
		// 发送消息
		System.out.println("推送消息 1");
		if(token==null||token=="0"){
			System.out.println("推送消息 1  -1");
			return -1;
			
		}
		if(type=="1")
			content = "派对消息";
		
		System.out.println("后台推送");
		// TODO Auto-generated method stub
		/* 第二步：获取请求的参数 */
		String device = token;// 设备号
		/* 第三步：获取参数值，并设置证书 */
		try {
			System.out.println("推送消息 2");
			//device = "43e13e20 81b345d0 dd649108 3f18c6c1 aac56105 fabfc449 b7824f45 0342455a";
			System.out.println(content);
			System.out.println(device);
			String deviceToken = device;// 设备号
			PayLoad payLoad = new PayLoad();
			payLoad.addAlert(content);// 信息内容
			payLoad.addBadge(1);// 消息的数量
			payLoad.addSound("default");// 设置推送的声音
			
			System.out.println("推送消息 3");
			PushNotificationManager pushManager = PushNotificationManager
					.getInstance();
			pushManager.addDevice("iPhone", deviceToken.trim());
			System.out.println("推送消息 4");
			String host = "gateway.sandbox.push.apple.com";
			int port = 2195;
			String certificatePath = "D:/aps_development5.p12";// p12证书的路径

			String certificationPassword = "123456";// 证书的密码

			pushManager.initializeConnection(host, port, certificatePath,
					certificationPassword,
					SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);
			System.out.println("推送消息 5");
			// send push
			Device client = pushManager.getDevice("iPhone");
			pushManager.sendNotification(client, payLoad);
			pushManager.stopConnection();
			pushManager.removeDevice("iPhone");
			System.out.println("推送消息 6");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		System.out.println("push succeed");
		return 1;

	}

	@Autowired
	private MessageMapper messageMapper;

	private static MessageManager instance;

	public void init() {
		instance = MessageManager.getInstance();
	}

	public void createMsg() {
		// TODO Auto-generated method stub
		instance.createMsg();
	}

	private String a = "select * from c_message where ";

	private String sql = "UPDATE C_MESSAGE SET STATUS = 'N' WHERE STATUS != 'N' AND ID IN (SELECT ID AS A FROM C_MESSAGE M WHERE ROUND(TO_NUMBER (SYSDATE - M.STIME) * 24 * 60)> 15)";

	private String sql1 = "UPDATE m_party  " + " SET STATUS    = 'N' "
			+ " WHERE " + " ID       IN "
			+ "  (SELECT ID AS A " + "  FROM m_party M "
			+ "  WHERE ROUND(TO_NUMBER (SYSDATE - M.STIME) * 24 * 60)> 14 "
			+ " ) AND (STATUS = 'N' OR STATUS = 'W' ) ";

	
	private String sql2 = "UPDATE m_VIEW   SET STATUS    = 'N'  "
            + "  WHERE  MSG_ID       IN " 
           +  "  (SELECT ID AS A  FROM m_party M 　"
          + "  WHERE ROUND(TO_NUMBER (SYSDATE - M.STIME) * 24 * 60)> 14 "
        + "   )  AND (STATUS = 'N' OR STATUS = 'W' ) ";
	
	public void updateStatus() {
		// TODO Auto-generated method stub
		int update = jt.update(sql);
		int update2 = jt.update(sql2);
		System.out.println("更改 消息   1  "+update+" update xiaoxi  2"+ update2);
	}

	public List getMessageByUUID(String uuid, Integer from, Integer to) {
		Integer Iuuid = 0;
		// TODO Auto-generated method stub
		if (uuid != null)
			Iuuid = Integer.valueOf(uuid);

		Map param = new HashMap();
		param.put("UID", Iuuid);
		param.put("FROM", from);
		param.put("TO", to);
		List msgs = messageMapper.queryMessageByUUID(param);

		return msgs;
	}

	public int insertIntoM_SEND(Integer userid, Integer f_user, Integer smi) {
		Map param = new HashMap();
		param.put("UID", userid);
		param.put("FID", f_user);
		param.put("MID", smi);
		return messageMapper.insertIntoM_SEND(param);
	}

	public int insertIntoM_SENDForUser(Integer userid, Integer smi) {
		Map param = new HashMap();
		param.put("UID", userid);
		param.put("MID", smi);
		return messageMapper.insertIntoM_SENDForUser(param);
	}

	public int insertIntoM_PARTY(String invite, Integer cid, Integer spi,
			Integer smi) {
		Map param = new HashMap();
		param.put("PID", spi);
		param.put("CID", cid);
		param.put("MID", smi);
		param.put("INVITE", invite);
		return messageMapper.insertIntoM_PARTY(param);
	}

	public int insertIntoM_VIEW(Integer f_user, Integer smi) {
		Map param = new HashMap();
		param.put("FID", f_user);
		param.put("MID", smi);
		return messageMapper.insertIntoM_VIEW(param);
	}

	public int insertIntoM_VIEWforUser(Integer userid, Integer smi) {
		Map param = new HashMap();
		param.put("UID", userid);
		param.put("MID", smi);
		return messageMapper.insertIntoM_VIEWforUser(param);
	}

	public int DeleteM_SEND(Integer uu_id, Integer puid, Integer mid) {
		Map param = new HashMap();
		param.put("SID", uu_id);
		param.put("UID", puid);
		param.put("MID", mid);
		return messageMapper.DeleteM_SEND(param);
	}
	public int DeleteM_SENDFroMine(Integer uu_id,Integer mid) {
		Map param = new HashMap();
		param.put("SID", uu_id);
		param.put("MID", mid);
		return messageMapper.DeleteM_SENDFroMine(param);
	}
	public Map SelectMsgId(Integer pid) {
		Map param = new HashMap();
		param.put("PID", pid);
		return messageMapper.SelectMsgId(param);
	}

	public Map SelectMsgIdToUpdate(Integer pid) {
		Map param = new HashMap();
		param.put("PID", pid);
		return messageMapper.SelectMsgIdToUpdate(param);
	}

	public Map SelectMsgIdToTrueJoinParty(Integer user_id, Integer pid) {
		Map param = new HashMap();
		param.put("UID", user_id);
		param.put("PID", pid);
		return messageMapper.SelectMsgIdToTrueJoinParty(param);
	}

	public int insertIntoM_SENDForJoinParty(Integer puid, Integer uu_id,
			Integer mid) {
		Map param = new HashMap();
		param.put("SID", uu_id);
		param.put("UID", puid);
		param.put("MID", mid);
		return messageMapper.insertIntoM_SENDForJoinParty(param);
	}
	public int insertIntoM_SENDForJoinPartyAndMine(Integer uu_id,
			Integer mid) {
		Map param = new HashMap();
		param.put("SID", uu_id);
		param.put("MID", mid);
		return messageMapper.insertIntoM_SENDForJoinPartyAndMine(param);
	}
	public int DeleteM_VIEW(Integer uu_id, Integer puid, Integer mid) {
		Map param = new HashMap();
		param.put("UID", puid);
		param.put("MID", mid);
		return messageMapper.DeleteM_VIEW(param);
	}
	public int DeleteM_VIEWFroMine(Integer uu_id, Integer puid, Integer mid) {
		Map param = new HashMap();
		param.put("UID", uu_id);
		param.put("MID", mid);
		return messageMapper.DeleteM_VIEWFroMine(param);
	}
	public int insertIntoM_VIEWForJoinParty(Integer puid, Integer mid) {
		Map param = new HashMap();
		param.put("UID", puid);
		param.put("MID", mid);
		return messageMapper.insertIntoM_VIEWForJoinParty(param);
	}
	public int insertIntoM_VIEWForJoinPartyAndMine(Integer uu_id, Integer mid) {
		Map param = new HashMap();
		param.put("UID", uu_id);
		param.put("MID", mid);
		return messageMapper.insertIntoM_VIEWForJoinPartyAndMine(param);
	}
	public int insertIntoM_PARTYForJoinParty(String invite, Integer pid,
			Integer mid) {
		Map param = new HashMap();
		param.put("PID", pid);
		param.put("MID", mid);
		param.put("INVITE", invite);
		return messageMapper.insertIntoM_PARTYForJoinParty(param);
	}

	public void updateFor_M_Pary(Integer pid, Integer mid) {
		Map param = new HashMap();
		param.put("PID", pid);
		param.put("MID", mid);
		messageMapper.updateFor_M_Pary(param);
	}

	public void updateFor_M_VIEW(Integer user_id, Integer mid) {
		Map param = new HashMap();
		param.put("UID", user_id);
		param.put("MID", mid);
		messageMapper.updateFor_M_VIEW(param);
	}

	public void updateFor_M_VIEWForCreater(Integer puid, Integer mid) {
		Map param = new HashMap();
		param.put("PUID", puid);
		param.put("MID", mid);
		messageMapper.updateFor_M_VIEWForCreater(param);
	}

	public void updateFor_M_VIEWForTrueJoinParty(Integer puid, Integer mid) {
		Map param = new HashMap();
		param.put("UID", puid);
		param.put("MID", mid);
		messageMapper.updateFor_M_VIEWForTrueJoinParty(param);
	}
	public void updateFor_M_VIEWForTrueJoinPartyForUser_Id(Integer user_id, Integer mid) {
		Map param = new HashMap();
		param.put("UID", user_id);
		param.put("MID", mid);
		messageMapper.updateFor_M_VIEWForTrueJoinPartyForUser_Id(param);
	}

	public Map getMsgCount(String uuid) {
		// TODO Auto-generated method stub
		Map param = new HashMap();
		param.put("uuid", Integer.valueOf(uuid));
		Map c = messageMapper.queryMsgCount(param);
		System.out.println(c);
		return c;
	}

	public int resetMsgCount(String uuid, String type) {
		// TODO Auto-generated method stub
		Map param = new HashMap();
		param.put("uuid", Integer.valueOf(uuid));
		if (type == "1") {

		}
		if (type == "2") {

		}
		if (type == "3") {

		}
		param.put("uuid", Integer.valueOf(uuid));
		param.put("type", type);

		int i = messageMapper.updateResetMsgCount(param);

		return 0;
	}

}
