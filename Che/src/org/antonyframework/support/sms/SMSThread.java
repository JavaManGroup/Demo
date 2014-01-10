package org.antonyframework.support.sms;

import java.util.Vector;

import org.antonyframework.support.mail.MailBEAN;
import org.antonyframework.support.mail.MailThread;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SMSThread implements Runnable {

	private static final Log LOG = LogFactory.getLog(SMSThread.class);
	private boolean runFlag = true;
	private Vector vector = new Vector();
	Thread thread = null;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (runFlag) {
			try {
				Thread.sleep(500);
				MailBEAN mBean = null;
				synchronized (vector) {
					if (mBean == null)
						break;
				}
			} catch (Exception e) {
			}
		}
	}

	public void putSms(SMSBean mBean) {
		synchronized (vector) {
			if (mBean == null)
				return;
			if (vector.isEmpty() && (thread == null || !thread.isAlive())) {
				vector.add(mBean);
				thread = new Thread(this);
				thread.start();
			} else {
				vector.add(mBean);
			}
		}
	}

	public SMSBean getSms() {
		SMSBean mBean = null;
		if (!vector.isEmpty()) {
			mBean = (SMSBean) vector.firstElement();
			vector.remove(0);
		}
		return mBean;
	}

	public void close() {
		try {
			runFlag = false;
			// timer.cancel();
			// timer = null;
		} catch (Exception e) {
			LOG.warn("Cannot close MailThread.", e);
		}
	}

	protected void finalize() {
		try {
			runFlag = false;
			// timer.cancel();
			// thread.destroy();
		} catch (Exception e) {
		}
	}

}
