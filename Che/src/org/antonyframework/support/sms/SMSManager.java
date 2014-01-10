package org.antonyframework.support.sms;

import java.lang.reflect.Method;
import java.util.Properties;

import org.antonyframework.support.mail.MailBEAN;
import org.antonyframework.support.mail.MailThread;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SMSManager {

	private static final Log LOG = LogFactory.getLog(SMSManager.class);

	private static SMSManager sms;

	private SMSManager() {
	}

	public static SMSManager getInstance() {
		if (sms == null) {
			sms = new SMSManager();
			sms.init();
		}
		return sms;
	}

	private void initMobile(){
		
		
	}
	private void init() {

		Properties prop = System.getProperties();
		Object obj = prop.get("SMSThread");

		if (obj == null) {

			try {
				SMSThread smsThread = new SMSThread();
				prop.put("SMSThread", smsThread);
			} catch (Exception e) {
				LOG.fatal("Cannot create MailThread", e);
			}

		} else {

			Class mtClass = obj.getClass();
			try {
				Method closeMethod = mtClass.getMethod("close", new Class[0]);
				closeMethod.invoke(obj, new Object[0]);
				MailThread mailThread = new MailThread();
				prop.put("SMSThread", mailThread);
			} catch (Exception e) {
				LOG.fatal("Cannot close MailThread", e);
			}

		}
	}

	public boolean sendSms(SMSBean mBean) {
		if (mBean == null)
			return false;
		putMail(mBean);
		return true;
	}

	private void putMail(SMSBean mBean) {
		Properties prop = System.getProperties();
		Object obj = prop.get("SMSThread");
		Class mtClass = obj.getClass();
		try {
			Method putMail = mtClass.getMethod("putSms",
					new Class[] { MailBEAN.class });
			putMail.invoke(obj, new Object[] { mBean });
		} catch (Exception e) {
			LOG.error("cannot call putMail method of MailThread", e);
		}
	}
}
