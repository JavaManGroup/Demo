package com.antony.service.msg.db;

import java.util.List;
import java.util.Map;


public interface MessageMapper {

	List<Map> queryMessageByUUID(Map param);
	
	Map SelectMsgId(Map param);
	
	Map SelectMsgIdToUpdate(Map param);

	Map SelectMsgIdToTrueJoinParty(Map param);
	
	int insertIntoM_SEND(Map param);
	
	int insertIntoM_SENDForUser(Map param);
	
	int insertIntoM_PARTY(Map param);
	
	int insertIntoM_VIEW(Map param);
	
	int insertIntoM_VIEWforUser(Map param);
	
	int DeleteM_SEND(Map param);
	
	int DeleteM_SENDFroMine(Map param);
	
	int insertIntoM_SENDForJoinParty(Map param);
	
	int insertIntoM_SENDForJoinPartyAndMine(Map param);
	
	int DeleteM_VIEW(Map param);
	
	int DeleteM_VIEWFroMine(Map param);
	
	int insertIntoM_VIEWForJoinParty(Map param);
	
	int insertIntoM_VIEWForJoinPartyAndMine(Map param);
	
	int insertIntoM_PARTYForJoinParty(Map param);
	
	void updateFor_M_Pary(Map param);
	
	void updateFor_M_VIEW(Map param);
	
	void updateFor_M_VIEWForCreater(Map param);
	
	void updateFor_M_VIEWForTrueJoinParty(Map param);
	
	void updateFor_M_VIEWForTrueJoinPartyForUser_Id(Map param);

	Map queryMsgCount(Map param);

	int updateResetMsgCount(Map param);

	Map queryTokenByUUID(Map param);
	
	int updateTokenByUUID(Map param);
}