package com.antony.service.party.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.antonyframework.service.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import com.antony.service.party.db.PartyMapper;

public class PartyService extends BaseService {

	@Autowired
	private PartyMapper partyMapper;

	@Override
	public List list() throws RuntimeException {
		// TODO Auto-generated method stub
		List<Map> partys = partyMapper.getPartys(null);
		return partys;
	}

	public List getCreaters(Integer pid) {
		// TODO Auto-generated method stub
		Map param = new HashMap();
		System.out.println("11111111111111111111111111111" + pid);
		param.put("ID", pid);
		return partyMapper.getCreaters(param);
	}
	public List getParticipants(Integer pid) {
		// TODO Auto-generated method stub
		Map param = new HashMap();
		param.put("PID", String.valueOf(pid));
		List participants = partyMapper.getParticipants(param);
		try {
			return participants;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Integer getCount() {
		return partyMapper.getCount();
	}

	public List getPartys(Integer from, Integer to, String lat, String lng) {
		Map param = new HashMap();
		param.put("FROM", from);
		param.put("TO", to);
		param.put("LAT", lat);
		param.put("LNG", lng);
		return partyMapper.Partys(param);
	}
	public List getPartys_local(Integer from, Integer to, String lat, String lng) {
		Map param = new HashMap();
		param.put("FROM", from);
		param.put("TO", to);
		param.put("LAT", lat);
		param.put("LNG", lng);
		return partyMapper.Partys_local(param);
	}
	public Map Select_P_LABEL(Integer pid) {
		Map param = new HashMap();
		param.put("PID", pid);
		return partyMapper.Select_P_LABEL(param);
	}
	public Map getUser(Integer userid, Integer pid) {
		Map param = new HashMap();
		param.put("U_ID", userid);
		param.put("P_ID", pid);
		return partyMapper.getUser(param);
	}

	public Integer count_getUser(Integer userid, Integer pid) {
		Map param = new HashMap();
		param.put("U_ID", userid);
		param.put("P_ID", pid);
		return partyMapper.count_getUser(param);
	}

	public List buUser(Integer pid) {
		Map param = new HashMap();
		param.put("P_ID", pid);
		return partyMapper.buUser(param);
	}

	public List getActivity(Integer CO_ID, Integer u_id) {
		Map param = new HashMap();
		param.put("C_ID", CO_ID);
		param.put("UID", u_id);
		return partyMapper.getActivity(param);
	}

	public List getPartyList(String uuid, String c_id, String from, String to) {
		// TODO Auto-generated method stub
		Map param = new HashMap();
		param.put("C_ID", c_id);
		List<Map> partys = partyMapper.getPartys(param);
		return partys;
	}

	public List getFpic(Integer CO_ID) {
		Map param = new HashMap();
		param.put("CID", CO_ID);
		return partyMapper.getFpic(param);
	}

	public List getHotActivity(Integer u_id, Integer CO_ID) {
		Map param = new HashMap();
		param.put("CO_ID", CO_ID);
		param.put("UID", u_id);
		return partyMapper.getHotActivity(param);
	}
	public Integer getuserNum(Integer c_id) {
		Map param = new HashMap();
		param.put("CID", c_id);
		return partyMapper.user_Num_Friend(param);
	}

	public List getuserToInfo(Integer c_id, Integer from, Integer to,Integer uuid) {
		Map param = new HashMap();
		param.put("FROM", from);
		param.put("TO", to);
		param.put("C_ID", c_id);
		param.put("UID", uuid);
		return partyMapper.user_Info(param);
	}

	public Map userFriendStatus(Integer uuid, Integer friend_id) {
		Map param = new HashMap();
		param.put("UID", uuid);
		param.put("FID", friend_id);
		return partyMapper.userFriendStatus(param);
	}

	public Map getSeq() {
		return partyMapper.selectNextSeq(null);
	}

	public Map insertParty(Integer ID ,String title, String local, String stime,
			String type, Integer userid, String info, Integer cid, Integer sli,
			String city) {
		Map param = new HashMap();
		param.put("ID", ID);
		param.put("TITLE", title);
		param.put("LOCAL", local);
		param.put("STIME", stime);
		param.put("TYPE", type);
		param.put("USER_ID", userid);
		param.put("INFO", info);
		param.put("C_ID", cid);
		param.put("L_ID", sli);
		param.put("CITY", city);
		return partyMapper.insertParty(param);
	}

	public Map insertTake(Integer spi, Integer f_user) {
		Map param = new HashMap();
		param.put("p_id", spi);
		param.put("user_id", f_user);
		return partyMapper.insertTake(param);
	}
	public Map insertTake_ToUser(Integer spi, Integer userid) {
		Map param = new HashMap();
		param.put("p_id", spi);
		param.put("user_id", userid);
		return partyMapper.insertTake_ToUser(param);
	}
	public Map insertLocal(Integer sli, String lng, String lat) {
		Map param = new HashMap();
		param.put("ID", sli);
		param.put("LNG", lng);
		param.put("LAT", lat);
		return partyMapper.insertLocal(param);
	}

	public void updateFor_Pary(Integer pid) {
		Map param = new HashMap();
		param.put("PID", pid);
		partyMapper.updateFor_Pary(param);
	}

	public void updateRelationForCreats(Integer user_id, Integer pid) {
		Map param = new HashMap();
		param.put("UID", user_id);
		param.put("PID", pid);
		partyMapper.updateRelationForCreats(param);
	}
	public void updateFor_Message_Creater(Integer puid,Integer user_id, Integer pid) {
		Map param = new HashMap();
		param.put("UID", user_id);
		param.put("PUID", puid);
		param.put("PID", pid);
		partyMapper.updateFor_Message_Creater(param);
	}
	public void updateRelationForParty(Integer user_id, Integer pid) {
		Map param = new HashMap();
		param.put("UID", user_id);
		param.put("PID", pid);
		partyMapper.updateRelationForParty(param);
	}
	public Map Message_ForTureParty_Pass(Integer puid,Integer user_id, Integer pid) {
		Map param = new HashMap();
		param.put("UID", user_id);
		param.put("PID", pid);
		param.put("PUID", puid);
		return partyMapper.Message_ForTureParty_Pass(param);
	}
	public Map Message_ForTurePartyCreater_Pass(Integer puid,Integer user_id, Integer pid) {
		Map param = new HashMap();
		param.put("UID", user_id);
		param.put("PID", pid);
		param.put("PUID", puid);
		return partyMapper.Message_ForTurePartyCreater_Pass(param);
	}
	public Map Message_ForDeletePartyCreats_Pass(Integer puid,Integer user_id, Integer pid) {
		Map param = new HashMap();
		param.put("UID", user_id);
		param.put("PID", pid);
		param.put("PUID", puid);
		return partyMapper.Message_ForDeletePartyCreats_Pass(param);
	}
	public Map Message_ForDeleteParty_Pass(Integer puid,Integer user_id, Integer pid) {
		Map param = new HashMap();
		param.put("UID", user_id);
		param.put("PID", pid);
		param.put("PUID", puid);
		return partyMapper.Message_ForDeleteParty_Pass(param);
	}
	public Map deleteRelation(Integer uuid, Integer user_id) {
		Map param = new HashMap();
		param.put("UID", uuid);
		param.put("FID", user_id);
		return partyMapper.deleteRelation(param);
	}

	public Map deleteRelationForFriend(Integer uuid, Integer user_id) {
		Map param = new HashMap();
		param.put("UID", user_id);
		param.put("FID", uuid);
		return partyMapper.deleteRelationForFriend(param);
	}

	public Map joinActivity(Integer c_id, Integer u_id) {
		Map param = new HashMap();
		param.put("C_ID", c_id);
		param.put("U_ID", u_id);
		return partyMapper.joinActivity(param);
	}

	public Map joinActivityToDelete(Integer c_id, Integer u_id) {
		Map param = new HashMap();
		param.put("C_ID", c_id);
		param.put("U_ID", u_id);
		return partyMapper.joinActivityToDelete(param);
	}

	public Map deleteActivity(Integer c_id, Integer u_id) {
		Map param = new HashMap();
		param.put("C_ID", c_id);
		param.put("U_ID", u_id);
		return partyMapper.deleteActivity(param);
	}

	public List getActivityMain(Integer from, Integer to) {
		Map param = new HashMap();
		param.put("FROM", from);
		param.put("TO", to);
		return partyMapper.Activity(param);
	}

	public Integer countActivityForActivity() {
		Map param = new HashMap();
		return partyMapper.countActivityForActivity(param);
	}

	public List getActivityMainForLocal(Integer from, Integer to) {
		Map param = new HashMap();
		param.put("FROM", from);
		param.put("TO", to);
		return partyMapper.ActivityForLocal(param);
	}

	public Integer countActivityForLocal() {
		Map param = new HashMap();
		return partyMapper.countActivityForLocal(param);
	}
	public Integer Select_IndexNum_ForSystem(String type,Integer uuid) {
		Map param = new HashMap();
		param.put("TYPE", type);
		param.put("UID", uuid);
		return partyMapper.Select_IndexNum_ForSystem(param);
	}
	public List systemMessage(String type, Integer from, Integer to,
			Integer uuid) {
		Map param = new HashMap();
		param.put("TYPE", type);
		param.put("FROM", from);
		param.put("TO", to);
		param.put("UID", uuid);
		return partyMapper.systemMessage(param);
	}
	public List Select_C_Join (Integer cid,Integer userid) {
		Map param = new HashMap();
		param.put("CID", cid);
		param.put("UID", userid);
		return partyMapper.Select_C_Join(param);
	}
	public List Select_C_Take (Integer userid,Integer pid) {
		Map param = new HashMap();
		param.put("PID", pid);
		param.put("UID", userid);
		return partyMapper.Select_C_Take(param);
	}
	public List Select_C_Take_Pass(Integer user_id,Integer cid) {
		Map param = new HashMap();
		param.put("CID", cid);
		param.put("UID", user_id);
		return partyMapper.Select_C_Take_Pass(param);
	}
	public Map Insert_M_Message (Integer spi,Integer user_id,Integer cid,Integer fid) {
		Map param = new HashMap();
		param.put("UID", user_id);
		param.put("FID", fid);
		param.put("PID", spi);
		param.put("CID", cid);
		return partyMapper.Insert_M_Message(param);
	}
	public Map Insert_M_Message_C (Integer spi,Integer cid,Integer userid,Integer fid) {
		Map param = new HashMap();
		param.put("UID", userid);
		param.put("CID", cid);
		param.put("FID", fid);
		param.put("PID", spi);
		return partyMapper.Insert_M_Message_C(param);
	}
	public Map Insert_M_Message_Party (Integer spi,Integer cid,Integer userid,Integer fid) {
		Map param = new HashMap();
		param.put("UID", userid);
		param.put("FID", fid);
		param.put("PID", spi);
		param.put("CID", cid);
		return partyMapper.Insert_M_Message_Party(param);
	}
	public Map Insert_M_Message_Party_C(Integer spi,Integer userid,Integer fid) {
		Map param = new HashMap();
		param.put("UID", userid);
		param.put("FID", fid);
		param.put("PID", spi);
		return partyMapper.Insert_M_Message_Party_C(param);
	}
	public Map userInfo_tophone(Integer sid) {
		Map param = new HashMap();
		param.put("SID", sid);
		return partyMapper.userInfo_tophone(param);
	}

	public Map systemMessage_CTITLE(Integer cid) {
		Map param = new HashMap();
		param.put("CID", cid);
		return partyMapper.systemMessage_CTITLE(param);
	}

	public Map userInfo_toPartyTitle(Integer pp_id) {
		Map param = new HashMap();
		param.put("PID", pp_id);
		return partyMapper.userInfo_toPartyTitle(param);
	}

	public Map JoinParty(Integer uu_id, Integer pid) {
		Map param = new HashMap();
		param.put("UID", uu_id);
		param.put("PID", pid);
		return partyMapper.JoinToParty(param);
	}
	public Map DeleteParty(Integer uu_id, Integer pid) {
		Map param = new HashMap();
		param.put("UID", uu_id);
		param.put("PID", pid);
		return partyMapper.DeleteParty(param);
	}
	public Map ExitParty(Integer uuid, Integer pid) {
		Map param = new HashMap();
		param.put("UID", uuid);
		param.put("PID", pid);
		return partyMapper.ExitParty(param);
	}

	public Map userInfo(Integer uuid, Integer pid) {
		Map param = new HashMap();
		param.put("UID", uuid);
		param.put("PID", pid);
		return partyMapper.userInfo(param);
	}

	public Map PartyMessageForTotal(Integer uuid, String type) {
		Map param = new HashMap();
		param.put("TYPE", type);
		param.put("UID", uuid);
		return partyMapper.PartyMessageForTotal(param);
	}
	public Map PartyToMessageForTotal(String uuid) {
		Map param = new HashMap();
		param.put("UID", uuid);
		return partyMapper.PartyToMessageForTotal(param);
	}

	public List PartyMessage(Integer from, Integer to, Integer uuid, String type) {
		Map param = new HashMap();
		param.put("TYPE", type);
		param.put("UID", uuid);
		param.put("FROM", from);
		param.put("TO", to);
		return partyMapper.PartyMessage(param);
	}
	public List PartyMessageToSender(Integer from, Integer to, Integer uuid,
			String type) {
		Map param = new HashMap();
		param.put("TYPE", type);
		param.put("UID", uuid);
		param.put("FROM", from);
		param.put("TO", to);
		return partyMapper.PartyMessageToSender(param);
	}
	public List PartyMessageToSender_joinparty(Integer from, Integer to, Integer uuid,
			String type) {
		Map param = new HashMap();
		param.put("TYPE", type);
		param.put("UID", uuid);
		param.put("FROM", from);
		param.put("TO", to);
		return partyMapper.PartyMessageToSender_joinparty(param);
	}
	public List PartyMessageToSender_comcreater(Integer from, Integer to, Integer uuid,
			String type,String cpid) {
		Map param = new HashMap();
		param.put("TYPE", type);
		param.put("UID", uuid);
		param.put("FROM", from);
		param.put("TO", to);
		param.put("PID",cpid);
		return partyMapper.PartyMessageToSender_comcreater(param);
	}
	public Map Message_part_info(Integer p_id) {
		Map param = new HashMap();
		param.put("PID", p_id);
		return partyMapper.Message_part_info(param);
	}
	public int Update_M_CountForParty(Integer userid) {
		Map param = new HashMap();
		param.put("UID", userid);
		return partyMapper.Update_M_CountForParty(param);
	}
	public int Update_M_CountForParty_ToCreater(Integer f_user) {
		Map param = new HashMap();
		param.put("FID", f_user);
		return partyMapper.Update_M_CountForParty_ToCreater(param);
	}
	public int Update_M_CountForSystem(Integer user_id) {
		Map param = new HashMap();
		param.put("UID", user_id);
		return partyMapper.Update_M_CountForSystem(param);
	}
	public int Update_M_CountForSystemForPass(Integer fid) {
		Map param = new HashMap();
		param.put("UID", fid);
		return partyMapper.Update_M_CountForSystemForPass(param);
	}
	public Map Message_party_UserInfo(Integer uu_id) {
		Map param = new HashMap();
		param.put("UID", uu_id);
		return partyMapper.Message_party_UserInfo(param);
	}
	public List messageInfo(Integer uuid, String type) {
		Map param = new HashMap();
		param.put("TYPE", type);
		param.put("UID", uuid);
		return partyMapper.messageInfo(param);
	}
	public List Creaters_ForId(Integer p_id) {
		Map param = new HashMap();
		param.put("PID", p_id);
		return partyMapper.Creaters_ForId(param);
	}
	public List messagetoInfo(Integer mid) {
		Map param = new HashMap();
		param.put("MID", mid);
		return partyMapper.messagetoinfo(param);
	}

	public Map sendUserToParty(Integer senderid) {
		Map param = new HashMap();
		param.put("UID", senderid);
		return partyMapper.sendUserToParty(param);
	}
	public Map creat_Info (Integer creatid) {
		Map param = new HashMap();
		param.put("UID", creatid);
		return partyMapper.creat_Info(param);
	}
	public Map reUserInfo(Integer uuid, Integer pid, String type) {
		Map param = new HashMap();
		param.put("TYPE", type);
		param.put("UID", uuid);
		param.put("PID", pid);
		return partyMapper.reUserInfo(param);
	}

	public Map reUserToInfo(Integer u_id) {
		Map param = new HashMap();
		param.put("RUID", u_id);
		return partyMapper.reUserToInfo(param);
	}
	public Map reUserToInfoFroUser_ID(Integer uu_id) {
		Map param = new HashMap();
		param.put("RUID", uu_id);
		return partyMapper.reUserToInfoFroUser_ID(param);
	}

	public Map getPartyForPoartyTitle(Integer pid) {
		Map param = new HashMap();
		param.put("PID", pid);
		return partyMapper.getPartyForPoartyTitle(param);
	}

	public List comCreatersPic(Integer p_id) {
		Map param = new HashMap();
		param.put("PID", p_id);
		return partyMapper.comCreatersPic(param);
	}

	public Map Creaters_Info(Integer u_id) {
		Map param = new HashMap();
		param.put("UID", u_id);
		return partyMapper.Creaters_Info(param);
	}

	public List Partys_Info(Integer from, Integer to, Integer c_id) {
		Map param = new HashMap();
		param.put("FROM", from);
		param.put("TO", to);
		param.put("CID", c_id);
		return partyMapper.Partys_Info(param);
	}

	public Integer Count_Partys_Inof(Integer c_id) {
		Map param = new HashMap();
		param.put("CID", c_id);
		return partyMapper.Count_Partys_Info(param);
	}

	public Map Activity_label(Integer c_id) {
		Map param = new HashMap();
		param.put("CID", c_id);
		return partyMapper.Activity_label(param);
	}

	public Map AddfriendToParty(Integer uuid, Integer fid, Integer pid) {
		Map param = new HashMap();
		param.put("UID", uuid);
		param.put("FID", fid);
		param.put("PID", pid);
		return partyMapper.AddfriendToParty(param);
	}
	public Map DeletefriendToParty(Integer uuid, Integer fid, Integer pid) {
		Map param = new HashMap();
		param.put("UID", uuid);
		param.put("FID", fid);
		param.put("PID", pid);
		return partyMapper.DeletefriendToParty(param);
	}
	public Map DeletefriendTofriendParty(Integer uuid, Integer fid, Integer pid) {
		Map param = new HashMap();
		param.put("UID", uuid);
		param.put("FID", fid);
		param.put("PID", pid);
		return partyMapper.DeletefriendTofriendParty(param);
	}
	public Map InsertfriendTofriendParty(Integer uuid, Integer fid, Integer pid) {
		Map param = new HashMap();
		param.put("UID", uuid);
		param.put("FID", fid);
		param.put("PID", pid);
		return partyMapper.InsertfriendTofriendParty(param);
	}
	public Map Message_For_Party(Integer userid, Integer f_user, Integer spi) {
		Map param = new HashMap();
		param.put("UID", userid);
		param.put("FID", f_user);
		param.put("PID", spi);
		return partyMapper.Message_For_Party(param);
	}
	public Map getPartyInfo(String party_id,String c_id,Integer uuid) {
		// TODO Auto-generated method stub

		Map param = new HashMap();
		param.put("PID", Integer.valueOf(party_id));
		param.put("UUID", uuid);
		if(c_id!=null){
		param.put("CID", Integer.valueOf(c_id));
		}
		Map part = partyMapper.getPartyInfoByPid(param);
		return part;
	}

	public void UpdatePhone(long phone, Integer userid) {
		Map param = new HashMap();
		param.put("PHONE", phone);
		param.put("UID", userid);
		partyMapper.UpdatePhone(param);
	}

	public Map insertInvitational(Integer userid, Integer spi, String invite) {
		Map param = new HashMap();
		param.put("UID", userid);
		param.put("PID", spi);
		param.put("INVITE", invite);
		System.out.println(userid);
		System.out.println(spi);
		System.out.println(invite);
		return partyMapper.insertInvitational(param);
	}

	public Integer Count_comCreatersPic(Integer p_id) {
		Map param = new HashMap();
		param.put("PID", p_id);
		return partyMapper.Count_comCreatersPic(param);
	}

	public Map insertMessage_ForParty(Integer uuid,Integer puid,Integer pid, String invite) {
		Map param = new HashMap();
		param.put("UID", uuid);
		param.put("PID", pid);
		param.put("PUID", puid);
		param.put("INVITE", invite);
		return partyMapper.insertMessage_ForParty(param);
	}
	public Map Delete_Message_ForParty(Integer uuid,Integer puid,Integer pid) {
		Map param = new HashMap();
		param.put("UID", uuid);
		param.put("PID", pid);
		param.put("PUID", puid);
		return partyMapper.Delete_Message_ForParty(param);
	}
	public Map insertMessage_ForParty_PartyCreater(Integer puid, Integer pid, String invite) {
		Map param = new HashMap();
		param.put("PUID", puid);
		param.put("PID", pid);
		param.put("INVITE", invite);
		return partyMapper.insertMessage_ForParty_PartyCreater(param);
	}
	public Map Select_Party_User(Integer pid) {
		Map param = new HashMap();
		param.put("PID", pid);
		return partyMapper.Select_Party_User(param);
	}

	public Map getPartyTakeInfo(String party_id, String uuid) {
		// TODO Auto-generated method stub
		Map param = new HashMap();
		param.put("PID", party_id);
		param.put("UID", Integer.valueOf(uuid));
		Map take = partyMapper.getPartyTakeInfoByUUIDAndPartyId(param);
		System.out.println("take " +take);
		return take;
	}
}
