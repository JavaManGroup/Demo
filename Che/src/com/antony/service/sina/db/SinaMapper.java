package com.antony.service.sina.db;

import java.util.List;
import java.util.Map;

public interface SinaMapper {

	Integer hasUserSet(Map param);
	
	Integer countSinaUserByUuidanfSuid(Map param);

	Integer hasSinaAccount(Map param);

	int insertSinaAccount(Map sina);

	Integer queryId();
	
	Integer queryFriendShipId();

	Integer getSinaPkBySinaId(String suid);

	Integer getUUIDBySinaId(String suid);

	List queryFriendShipByUUIDAndSUID(Map param);

	int insertFriendShip(Map param);

	int updateSinaAccount(Map param);

	int deletSinaAccount(Map param);
	
	int deletSinaFriendShip(Map param);

	int hasUserSetByBOUNDSINAID(Map param);
	
}