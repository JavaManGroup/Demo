package com.antony.service;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.antonyframework.support.mail.MailBEAN;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MessageManager {

	private static MessageManager msgMgr;

	private static final Log LOG = LogFactory.getLog(MessageManager.class);

	private MessageManager() {

	}

	public static MessageManager getInstance() {
		if (msgMgr == null) {
			msgMgr = new MessageManager();
			msgMgr.init();
			MailBEAN m = new MailBEAN();
			msgMgr.putMail(m);
		}
		return msgMgr;
	}

	private void init() {
		Properties prop = System.getProperties();
		Object obj = prop.get("MessageThread");
		if (obj == null) {
			try {
				MessageThread msgThread = new MessageThread();
				prop.put("MessageThread", msgThread);
			} catch (Exception e) {
				LOG.fatal("Cannot create MailThread", e);
			}
		} else {
			Class mtClass = obj.getClass();
			try {
				Method closeMethod = mtClass.getMethod("close", new Class[0]);
				closeMethod.invoke(obj, new MessageThread[0]);
				MessageThread msgThread = new MessageThread();
				prop.put("MessageThread", msgThread);
			} catch (Exception e) {
				LOG.fatal("Cannot close MailThread", e);
			}
		}
	}

	private void putMail(MailBEAN mailBean) {
		System.out.println("MessageManager  putMail");
		Properties prop = System.getProperties();
		Object obj = prop.get("MessageThread");
		Class mtClass = obj.getClass();
		try {
			Method putMail = mtClass.getMethod("putMail",
					new Class[] { MailBEAN.class });
			putMail.invoke(obj, new Object[] { mailBean });
		} catch (Exception e) {
			LOG.error("cannot call putMail method of MailThread", e);
		}
	}

	public void createMsg() {
		MailBEAN mailBean = new MailBEAN();
		msgMgr.putMail(mailBean);
	}

	public Map createPartyInviteMsg(Map param) {
		return new HashMap();
	}

	public Map inviteFriendMsg() {
		// 邀请好友，

		return null;
	}

	public Map createFriendMsg() {
		return null;
	}

	public Map waitFriendMsg() {
		return null;
	}

	public Map createCollectionMsg() {

		return null;
	}

	public Map createPartyMsg() {
		return null;
	}

	public Map createInvitePartyMsg() {
		return null;
	}

	public Map createApplyCollection() {
		return null;
	}

}
