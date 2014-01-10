package weibo4j.examples.friendships;

import weibo4j.Friendships;
import weibo4j.Users;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

public class GetFriendsIds {

	public static void main(String[] args) {
		String access_token = "2.00bhLiVDB4ygRDc597e4af00JipLJB";
		String uid = "3216996331";
		Friendships fm = new Friendships();
		fm.client.setToken(access_token);
		try {
			String[] ids = fm.getFriendsIdsByUid(uid);
			for(String s : ids){
				String uuid =s;
				Users um = new Users();
				um.client.setToken(access_token);
				try {
					User user = um.showUserById(uuid);
					Log.logInfo(user.toString());
				} catch (WeiboException e) {
					e.printStackTrace();
				}
				
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}
