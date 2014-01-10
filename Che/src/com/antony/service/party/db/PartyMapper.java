package com.antony.service.party.db;

import java.util.List;
import java.util.Map;

public interface PartyMapper {
	
	List<Map> getPartys(Map param);

	List getCreaters(Map param);

	List getParticipants(Map param);
	
	Integer count();
	
	Integer getCount();
	
	Map getUser(Map param);
	
	Integer count_getUser(Map param); 
	
	List Partys(Map param);
	
	List Partys_local(Map param);
	
	Map Select_P_LABEL(Map param);
	
	List getActivity(Map param);
	
	List getFpic(Map param);
	
	List getHotActivity(Map param);
	
	Integer user_Num_Friend(Map param);
	
	List user_Info(Map param);
	
	List buUser(Map param);
	
	Map selectNextSeq(Map param);
	
	Map insertParty(Map param);
	
	void UpdatePhone(Map param);
	
	Map insertTake(Map param);
	
	Map insertTake_ToUser(Map param);
	
	Map insertLocal(Map param);
	
	void updateFor_Pary(Map param);
	
	void updateRelationForParty(Map param);
	
	void updateRelationForCreats(Map param);
	
	void updateFor_Message_Creater(Map param);
	
	Map deleteRelation(Map param);
	
	Map Message_ForTureParty_Pass(Map param);
	
	Map Message_ForTurePartyCreater_Pass(Map param);
	
	Map Message_ForDeleteParty_Pass(Map param);
	
	Map deleteRelationForFriend(Map param);
	
	Map Message_ForDeletePartyCreats_Pass(Map param);
	
	Map joinActivity(Map param);
	
	Map deleteActivity(Map param);
	
	Map joinActivityToDelete(Map param);
	
	List Activity(Map param);
	
	Integer countActivityForActivity(Map param);
	
	List ActivityForLocal(Map param);
	
	Integer countActivityForLocal(Map param);
	
	Integer Select_IndexNum_ForSystem(Map param);
	
	List systemMessage(Map param);
	
	List Select_C_Join(Map param);
	
	List Select_C_Take(Map param);
	
	List Select_C_Take_Pass(Map param);
	
	Map Insert_M_Message(Map param);
	
	Map Insert_M_Message_C(Map param);
	
	Map Insert_M_Message_Party(Map param);
	
	Map Insert_M_Message_Party_C(Map param);
	
	Map  systemMessage_CTITLE(Map param);
	
	Map userInfo_toPartyTitle(Map param);
	
	Map userInfo_tophone(Map param);
	
	Map JoinToParty(Map param);
	
	Map DeleteParty(Map param);
	
	Map ExitParty(Map param);
	
	Map userInfo(Map param);
	
	Map PartyMessageForTotal(Map param);
	
	Map PartyToMessageForTotal(Map param);
	
	List PartyMessage(Map param);
	
	List PartyMessageToSender(Map param);
	
	List PartyMessageToSender_joinparty(Map param);
	
	List PartyMessageToSender_comcreater(Map param);
	
	Map Message_part_info(Map param);
	
	int Update_M_CountForParty(Map param);
	
	int Update_M_CountForParty_ToCreater(Map param);
	
	int Update_M_CountForSystem(Map param);
	
	int Update_M_CountForSystemForPass(Map param);
	
	Map Message_party_UserInfo(Map param);
	
	List Creaters_ForId(Map param);
	
	List messageInfo(Map param);
	
	List messagetoinfo(Map param);
	
	Map sendUserToParty(Map param);
	
	Map creat_Info(Map param);
	
	Map reUserInfo(Map param);
	
	Map reUserToInfo(Map param);
	
	Map reUserToInfoFroUser_ID(Map param);
	
	Map getPartyForPoartyTitle(Map param);
	
	Map userFriendStatus(Map param);
	
	List comCreatersPic(Map param);
	
	Integer Count_comCreatersPic(Map param);
	
	Map Creaters_Info(Map param);
	
	List Partys_Info(Map param);
	
	Integer Count_Partys_Info(Map param);
	
	Map Activity_label(Map param);
	
	Map AddfriendToParty(Map param);
	
	Map DeletefriendToParty(Map param);
	
	Map DeletefriendTofriendParty(Map param);
	
	Map InsertfriendTofriendParty(Map param);
	
	Map Message_For_Party(Map param);

	Map getPartyInfoByPid(Map param);
	
	Map insertInvitational(Map param);
	
	Map insertMessage_ForParty(Map param);
	
	Map Delete_Message_ForParty(Map param);
	
	Map insertMessage_ForParty_PartyCreater(Map param);
	
	Map Select_Party_User(Map param);

	Map getPartyTakeInfoByUUIDAndPartyId(Map param);
}