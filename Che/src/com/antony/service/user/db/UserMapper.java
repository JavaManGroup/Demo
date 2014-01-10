package com.antony.service.user.db;

import java.util.List;
import java.util.Map;

public interface UserMapper {
	
	Map getFriendInfoByUUIDandFriendId(Map param);

	List getFriendListByUUID(Map param);
	
	Integer Count_FriendListByUUID(Map param);

	Map getUserInfoByUUID(String uuid);
	
	Integer user_friend(Map param);
	
	Map userfriend(Map param);
	
	Map Delete_userfriend(Map param);
	
	Map verfriend(Map param);
	
	void updateUser(Map param);
	
	List friendMessage(Map param);
	
	Map friendMessage_ForP_id(Map param);
	
	Map friendMessage_ForP_Info(Map param);
	
	Integer Count_friendMessage(Map param);
	
	Map sendUser(Map param);
	
	Map Friend_addMessage(Map param);
	
	int TrueForFriend_Message(Map param);
	
	int Delete_ForTrueUser_Message(Map param);
	
	Map Select_Sysdate(Map param);

	void insertUserSet(Map set);
	
	void updateUserSinaUid(Map param);
	
	int update_M_CountForFriend(Map param);
	
	int TrueForUser(Map param);
	
	int Delete_ForUser(Map param);
	
	int Delete_ForTrueUser(Map param);
	
	int TrueForFriend(Map param);
	
	Map User_Info(Map param);
	
	Map User_Set(Map param);
	
	Map User_Set_Bound(Map param);

	Map getUserSinaIdByUUID(Map param);

	Map queryUserByEmail(Map param);

	Map queryUserByNick(String nick);

	int insertUser(Map param);

	int queryUserUUID();
	
	Map queryUserUUIDBySinaUid(Map param);

	int updateUserPass(Map param);

	List<Map> queryUserListByCity(Map param);

	List DBTest(Map param);

	int insertUserCount(Map param);

	int updatePassForget(Map param);
}